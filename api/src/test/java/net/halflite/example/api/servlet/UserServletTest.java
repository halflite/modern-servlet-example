package net.halflite.example.api.servlet;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Map;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.ImmutableMap;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import net.halflite.example.api.dao.AccountDao;
import net.halflite.example.api.exception.NotFoundException;

public class UserServletTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testDoGetHttpServletRequestHttpServletResponse() {
    }

    @Test
    public void testDoGet() throws ServletException, IOException {
        Gson gson = new GsonBuilder().serializeNulls()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();
        AccountDao accountDao = mock(AccountDao.class);
        Long id = 12L;
        Map<String, Object> record = ImmutableMap.<String, Object> builder()
                .put("id", Long.valueOf(31L))
                .put("email", "abc@example.com")
                .put("displayName", "海老氏")
                .put("status", "DISABLED")
                .put("division", "ADMIN")
                .build();
        Optional<Map<String, Object>> optRecord = Optional.of(record);
        when(accountDao.selectAccountAndAdminById(id)).thenReturn(optRecord);
        UserServlet userServlet = new UserServlet(gson, accountDao);

        HttpServletRequest req = mock(HttpServletRequest.class);
        when(req.getServletPath()).thenReturn("/user/12");

        HttpServletResponse resp = mock(HttpServletResponse.class);
        StringWriter sw = new StringWriter();
        PrintWriter writer = new PrintWriter(sw);
        when(resp.getWriter()).thenReturn(writer);
        userServlet.doGet(req, resp);

        verify(resp, times(1)).setStatus(200);
        verify(resp, times(1)).setContentType("application/json");

        String json = sw.toString();
        assertThat(json).isEqualTo("{\"id\":31,"
                + "\"email\":\"abc@example.com\","
                + "\"display_name\":\"海老氏\","
                + "\"status\":\"DISABLED\","
                + "\"division\":\"ADMIN\"}");
    }

    @Test
    public void testDoGetNotFoundId() throws ServletException, IOException {
        Gson gson = new Gson();
        AccountDao accountDao = mock(AccountDao.class);
        Long id = 12L;
        when(accountDao.selectAccountAndAdminById(id)).thenReturn(Optional.empty());
        UserServlet userServlet = new UserServlet(gson, accountDao);
        HttpServletRequest req = mock(HttpServletRequest.class);
        when(req.getServletPath()).thenReturn("/user/12");
        HttpServletResponse resp = mock(HttpServletResponse.class);
        userServlet.doGet(req, resp);

        verify(resp, times(1)).sendError(400);
    }

    @Test
    public void testGetId() {
        Gson gson = new Gson();
        AccountDao accountDao = mock(AccountDao.class);
        UserServlet userServlet = new UserServlet(gson, accountDao);
        HttpServletRequest req = mock(HttpServletRequest.class);
        when(req.getServletPath()).thenReturn("/user/12");

        Long id = userServlet.getId(req);
        assertThat(id).isEqualTo(12L);
    }

    @Test
    public void testGetIdNotNumericId() {
        Gson gson = new Gson();
        AccountDao accountDao = mock(AccountDao.class);
        UserServlet userServlet = new UserServlet(gson, accountDao);
        HttpServletRequest req = mock(HttpServletRequest.class);
        when(req.getServletPath()).thenReturn("/user/xxx");

        try {
            userServlet.getId(req);
            fail("例外が発生しませんでした。");
        } catch (NotFoundException e) {
            assertThat(e).isInstanceOf(NotFoundException.class);
            assertThat(e.getMessage()).isEqualTo("path:/user/xxx");
        }
    }
}
