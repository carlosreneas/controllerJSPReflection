package com.demo.boot.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BaseController {
	
	protected String view;
	
	public static String type;
	
	public void probar() {
		
	}
	
	public void cargar(HttpServletRequest request, HttpServletResponse response, String action) throws ServletException, IOException {
		switch(action) {
			default:
				try {
					Class[] cArg = new Class[2];
			        cArg[0] = HttpServletRequest.class;
			        cArg[1] = HttpServletResponse.class;
					Method miMetodo = this.getClass().getMethod(action, cArg);
					miMetodo.invoke(this, request, response);
				} catch (NoSuchMethodException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
		}
		
		
	}
	
	protected void forward(HttpServletRequest request, HttpServletResponse response, String recurso) throws ServletException, IOException {
		this.forward(request, response, recurso, view);
	}
	
	
	protected void forward(HttpServletRequest request, HttpServletResponse response, String recurso, String folder) throws ServletException, IOException {
		String vista = "../view/"+folder+"/"+recurso+".jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(vista);
        dispatcher.forward(request, response);
	}
	
	protected void redirect(HttpServletRequest request, HttpServletResponse response, String recurso) throws ServletException, IOException {
		response.sendRedirect(recurso);
		
	}
	
	protected void redirect(HttpServletRequest request, HttpServletResponse response, String recurso, String folder) throws ServletException, IOException {
		response.sendRedirect(folder+"/"+recurso);
		
	}
	
	
}
