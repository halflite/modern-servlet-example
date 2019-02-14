package net.halflite.example.api.servlet;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;

public class IndexServletTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testDoGetHttpServletRequestHttpServletResponse() throws ServletException, IOException {
        IndexServlet indexServlet = new IndexServlet();

        HttpServletRequest req = mock(HttpServletRequest.class);
        String path = "/index.ftl";
        RequestDispatcher requestDispatcher = mock(RequestDispatcher.class);
        when(req.getRequestDispatcher(path)).thenReturn(requestDispatcher );
        HttpServletResponse resp = mock(HttpServletResponse.class);
        indexServlet.doGet(req, resp);
        
        verify(requestDispatcher, times(1)).forward(req, resp);
        verify(req, times(1)).getRequestDispatcher(path);
    }

}
