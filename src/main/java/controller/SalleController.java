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


import beans.Salle;
import service.SalleService;

/**
 * Servlet implementation class SalleController
 */
@WebServlet(urlPatterns = {"/SalleController"})
public class SalleController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       SalleService ss = new SalleService();
    /**
     * @see HttpServlet#HttpServlet()
     */

	
	
    public SalleController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if (request.getParameter("op") != null) {
            if (request.getParameter("op").equals("load")) {
                response.setContentType("application/json");
                List<Salle> salles = ss.findAll();
                Gson json = new Gson();
                response.getWriter().write(json.toJson(salles));
            }else if(request.getParameter("op").equals("delete")){
                int id = Integer.parseInt(request.getParameter("id"));
                ss.delete(ss.findById(id));
                response.setContentType("application/json");
                List<Salle> salles = ss.findAll();
                Gson json = new Gson();
                response.getWriter().write(json.toJson(salles));
                
            }
            
            else if(request.getParameter("op").equals("update")){
                int id = Integer.parseInt(request.getParameter("id"));
                String code = request.getParameter("code");
                String type = request.getParameter("type");
                int capacite = Integer.parseInt(request.getParameter("capacite"));
              
                Salle s = ss.findById(id);
                System.out.println(id);
                s.setCode(code);
                s.setType(type);
                s.setCapacite(capacite);
                ss.update(s);
                response.setContentType("application/json");
                List<Salle> salles = ss.findAll();
                Gson json = new Gson();
                response.getWriter().write(json.toJson(salles));
                
            }
        } else {
            String code = request.getParameter("code");
            String type = request.getParameter("type");
            int capacite = Integer.parseInt(request.getParameter("capacite"));
          
            ss.create(new Salle(code,capacite, type));
            response.setContentType("application/json");
            List<Salle> salles = ss.findAll();
            Gson json = new Gson();
            response.getWriter().write(json.toJson(salles));
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }}