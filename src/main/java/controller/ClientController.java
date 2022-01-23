package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import beans.Client;
import beans.Salle;
import service.ClientService;

/**
 * Servlet implementation class ClientController
 */
@WebServlet("/ClientController")
public class ClientController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ClientService cs = new ClientService();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ClientController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getParameter("op") != null) {
			if (request.getParameter("op").equals("load")) {
				response.setContentType("application/json");
				List<Client> clients = cs.findAll();
				Gson json = new Gson();
				response.getWriter().write(json.toJson(clients));
			} else if (request.getParameter("op").equals("delete")) {
				int id = Integer.parseInt(request.getParameter("id"));
				cs.delete(cs.findById(id));
				response.setContentType("application/json");
				List<Client> clients = cs.findAll();
				Gson json = new Gson();
				response.getWriter().write(json.toJson(clients));

			} else if (request.getParameter("op").equals("update")) {
				int id = Integer.parseInt(request.getParameter("id"));
				String nom = request.getParameter("nom");
				String prenom = request.getParameter("prenom");
				String cin = request.getParameter("cin");
				String email = request.getParameter("email");
				String password = request.getParameter("password");
				Client o = cs.findById(id);
				System.out.println(id);
				o.setNom(nom);
				o.setPrenom(prenom);
				o.setCin(cin);
				o.setEmail(email);
				o.setPassword(password);
				cs.update(o);
				response.setContentType("application/json");
				List<Client> clients = cs.findAll();
				Gson json = new Gson();
				response.getWriter().write(json.toJson(clients));
			}
		} else {
			String nom = request.getParameter("nom");
			String prenom = request.getParameter("prenom");
			String cin = request.getParameter("cin");
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			cs.create(new Client(nom, prenom, cin, email, password));
			response.setContentType("application/json");
			List<Client> clients = cs.findAll();
			Gson json = new Gson();
			response.getWriter().write(json.toJson(clients));
		}

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		processRequest(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		processRequest(request, response);

	}

}
