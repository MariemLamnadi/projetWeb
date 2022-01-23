package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.attribute.UserPrincipalLookupService;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.jasper.tagplugins.jstl.core.Out;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.xdevapi.PreparableStatement;

import beans.Salle;
import beans.User;
import connexion.Connexion;
import service.UserService;

/**
 * Servlet implementation class UserController
 */
@WebServlet("/UserController")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserService us = new UserService();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserController() {
		super();
		// TODO Auto-generated constructor stub
	}

	private static PrintWriter out;
	private static String message;
	private static Gson gson;
	private JsonObject obj;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		gson = new Gson();
		obj = new JsonObject();

		String login = request.getParameter("login");
		String password = request.getParameter("password");
		response.setContentType("text/html;charset=UTF-8");

		out = response.getWriter();
		HttpSession session = request.getSession();

		HttpServletResponse httpResponse = (HttpServletResponse) response;

		httpResponse.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		response.addHeader("Cache-Control", "post-check=0, pre-check=0");
		httpResponse.setHeader("Pragma", "no-cache");
		httpResponse.setDateHeader("Expires", 0);

		boolean connexion = us.login(login, password);

		if (connexion) {

			session.setAttribute("login", login);
			if (session.getAttribute("username") == null) {
				response.sendRedirect("home.jsp");
			} else {
				obj.addProperty("status", true);
				obj.addProperty("erreur", "Login Sucess");

			}

		} else {
			session.invalidate();
			obj.addProperty("status", false);
			obj.addProperty("erreur", "Login Sucess");
			;
		}
		message = gson.toJson(obj);
		out.println(message);

	}

}
