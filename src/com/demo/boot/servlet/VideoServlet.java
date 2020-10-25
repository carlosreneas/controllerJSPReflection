package com.demo.boot.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class VideoServlet
 */
//@WebServlet("/video/*")
public class VideoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VideoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String pat = request.getServletPath();
		
		String action = request.getParameter("op");
		
		System.out.println(action);
		//System.out.println(op);
		
		switch(action) {
			case "cnew":
				cnew(request, response);
				break;
			case "insert":
				insert(request, response);
				break;
			case "delete":
				delete(request, response);
				break;
			case "edit":
				edit(request, response);
				break;
			case "update":
				actualizar(request, response);
				break;
			default:
				list(request, response);
				break;
		
		}
		
	}
    
    private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Listar: ").append(request.getContextPath());
		
		
	}

	private void actualizar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Actualizar: ").append(request.getContextPath());
		
	}

	private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Editar: ").append(request.getContextPath());
		
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Eliminar: ").append(request.getContextPath());
		
	}

	private void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Insertar: ").append(request.getContextPath());
		
	}

	private void cnew(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		response.getWriter().append("Nuevo: ").append(request.getContextPath());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
