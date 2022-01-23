package controller;

import java.io.IOException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import beans.Client;
import beans.Creneaux;
import beans.Salle;
import service.CrenauxService;

/**
 * Servlet implementation class CreneauController
 */
@WebServlet("/CreneauController")
public class CreneauController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CrenauxService cs = new CrenauxService();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreneauController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");

		if (request.getParameter("op") != null) {
			if (request.getParameter("op").equals("load")) {
				response.setContentType("application/json");
				List<Creneaux> creneaux = cs.findAll();
				Gson json = new Gson();
				response.getWriter().write(json.toJson(creneaux));
			} else if (request.getParameter("op").equals("delete")) {
				int id = Integer.parseInt(request.getParameter("id"));
				cs.delete(cs.findById(id));
				response.setContentType("application/json");
				List<Creneaux> creneaux = cs.findAll();
				Gson json = new Gson();
				response.getWriter().write(json.toJson(creneaux));
			}

			else if (request.getParameter("op").equals("update")) {

				int id = Integer.parseInt(request.getParameter("id"));
				Time heurDebut = Time.valueOf(request.getParameter("heurDebut") + ":00");
				Time heurFin = Time.valueOf(request.getParameter("heurFin") + ":00");
				Creneaux o = cs.findById(id);
				o.setHeurDebut(heurDebut);
				o.setHeurFin(heurFin);
				cs.update(o);
				response.setContentType("application/json");
				List<Creneaux> creneaux = cs.findAll();
				Gson json = new Gson();
				response.getWriter().write(json.toJson(creneaux));
			}
			} else {

				Time heurDebut = Time.valueOf(request.getParameter("heurDebut") + ":00");
				Time heurFin = Time.valueOf(request.getParameter("heurFin") + ":00");
				cs.create(new Creneaux(heurDebut, heurFin));
				response.setContentType("application/json");
				List<Creneaux> creneaux = cs.findAll();
				Gson json = new Gson();
				response.getWriter().write(json.toJson(creneaux));

			}
		

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		processRequest(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		processRequest(request, response);
	}

}
