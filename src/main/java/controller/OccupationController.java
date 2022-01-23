package controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import beans.Client;
import beans.Creneaux;
import beans.Occupation;
import beans.Salle;
import service.ClientService;
import service.CrenauxService;
import service.OccupationService;
import service.SalleService;

/**
 * Servlet implementation class OccupationController
 */
@WebServlet("/OccupationController")
public class OccupationController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	OccupationService os = new OccupationService();
	SalleService ss = new SalleService();
	CrenauxService cs = new CrenauxService();
	ClientService sc = new ClientService();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public OccupationController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getParameter("op") != null) {
			if (request.getParameter("op").equals("load")) {
				response.setContentType("application/json");
				List<Occupation> occupations = os.findAll();
				Gson gson = new Gson();
				response.getWriter().write(gson.toJson(occupations));
			} else if (request.getParameter("op").equals("delete")) {
				int id = Integer.parseInt(request.getParameter("id"));
				os.delete(os.findById(id));
				response.setContentType("application/json");
				List<Occupation> occupations = os.findAll();
				Gson gson = new Gson();
				response.getWriter().write(gson.toJson(occupations));
			} else if (request.getParameter("op").equals("update")) {

				try {
					int id = Integer.parseInt(request.getParameter("id"));
					int IDsalle = Integer.parseInt(request.getParameter("IDsalle"));
					int IDcreneaux = Integer.parseInt(request.getParameter("IDcreneaux"));
					int IDclient = Integer.parseInt(request.getParameter("IDclient"));
					Date date = new Date(request.getParameter("date").replace("-", "/"));
					os.update(new Occupation(id, ss.findById(IDsalle), cs.findById(IDcreneaux), date,
							sc.findById(IDclient)));
					response.setContentType("application/json");
					List<Occupation> occupations = os.findAll();
					Gson gson = new Gson();
					response.getWriter().write(gson.toJson(occupations));

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}} else {
				try {

					Salle s = ss.findById(Integer.parseInt(request.getParameter("IDsalle")));
					Creneaux cr = cs.findById(Integer.parseInt(request.getParameter("IDcreneaux")));
					Date date = new Date(request.getParameter("date").replace("-", "/"));
					Client c = sc.findById(Integer.parseInt(request.getParameter("IDclient")));
					os.create(new Occupation(s, cr, date, c));
					response.setContentType("application/json");
					List<Occupation> occupations = os.findAll();
					Gson json = new Gson();
					response.getWriter().write(json.toJson(occupations));
				} catch (Exception e) {
					e.printStackTrace();
				}

			
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
