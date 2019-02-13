package net.halflite.example.api.servlet;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.google.gson.stream.JsonWriter;

import net.halflite.example.api.dao.AccountDao;
import net.halflite.example.api.dto.result.AccountResultDto;
import net.halflite.example.api.exception.NotFoundException;

@Singleton
public class UserServlet extends HttpServlet {

    private static final long serialVersionUID = -1L;

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServlet.class);

    private static final Pattern ID_REGEX = Pattern.compile("^.*\\/(?<id>[0-9]+)$");

    private final Gson gson;
    private final AccountDao accountDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Long id = getId(req);
            AccountResultDto result = accountDao.selectAccountAndAdminById(id)
                    .map(AccountResultDto::from)
                    .orElseThrow(() -> new NotFoundException(String.format("id:%s", id)));

            resp.setStatus(HttpServletResponse.SC_OK);
            resp.setContentType("application/json");
            gson.toJson(result, resp.getWriter());
        } catch (NotFoundException e) {
            LOGGER.info(e.getMessage(), e);
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
        }
    }

    protected Long getId(HttpServletRequest req) throws NotFoundException {
        String servletPath = req.getServletPath();
        Matcher matcher = ID_REGEX.matcher(servletPath);
        if (matcher.matches()) {
            return Long.valueOf(matcher.group("id"));
        }

        throw new NotFoundException(String.format("path:%s", servletPath));
    }

    @Inject
    public UserServlet(Gson gson, AccountDao accountDao) {
        this.gson = gson;
        this.accountDao = accountDao;
    }
}
