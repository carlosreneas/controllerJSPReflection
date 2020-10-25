package com.demo.boot.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.boot.dao.UsuarioDao;
import com.demo.boot.dao.UsuarioDaoImpl;
import com.demo.boot.model.Usuario;

public class UsuarioController extends BaseController implements IController {
	
	private UsuarioDao usuarioDao;
	
	public UsuarioController(){
		this.view = "usuario";
		usuarioDao = new UsuarioDaoImpl(this.type);
	}

	public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		List <Usuario> listUsuarios = usuarioDao.selectAll();
		request.setAttribute("listUsuarios", listUsuarios);
		forward(request, response, "list");
	}

	public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		System.out.println("update");
		
		int id = Integer.parseInt(request.getParameter("id"));
		String nombre = request.getParameter("nombre");
		String email = request.getParameter("email");
		String pais = request.getParameter("pais");
		String clave = request.getParameter("clave");
		
		Usuario usuario = new Usuario (id, nombre, email, pais, clave);
		
		usuarioDao.update(usuario);
		
		redirect(request, response, "list");
	}

	public void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		Usuario usuarioActual = usuarioDao.select(id);
		
		request.setAttribute("usuario", usuarioActual);
		forward(request, response, "form");
		
	}

	public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		
		usuarioDao.delete(id);
		redirect(request, response, "list");
	}

	public void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		System.out.println("Insertar");
		String nombre = request.getParameter("nombre");
		String email = request.getParameter("email");
		String pais = request.getParameter("pais");
		String clave = request.getParameter("clave");
		
		Usuario usuario = new Usuario (nombre, email, pais, clave);
		
		usuarioDao.insert(usuario);
		redirect(request, response, "list");
	}

	public void cnew(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		forward(request, response, "form");
	}

	
}
