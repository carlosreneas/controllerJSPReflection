package com.demo.boot.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CategoriaController extends BaseController implements IController {
	
	public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Listar"); 
		RequestDispatcher dispatcher = request.getRequestDispatcher("../view/"+view+"/list.jsp");
        dispatcher.forward(request, response);
		
	}

	public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Actualizar");
		forward(request, response, "../view/" + view + "/list.jsp");
	}

	@Override
	public void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

	@Override
	public void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

	@Override
	public void cnew(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	}


}
