package net.halflite.example.api.servlet;

import java.io.IOException;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

@Singleton
public class IndexServlet extends HttpServlet {

	private static final long serialVersionUID = -1L;

	private final Gson gson;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doGet(req, resp);
	}

	@Inject
	public IndexServlet(Gson gson) {
		this.gson = gson;
	}
}
