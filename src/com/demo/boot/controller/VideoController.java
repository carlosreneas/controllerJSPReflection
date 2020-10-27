package com.demo.boot.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.boot.dao.UsuarioDao;
import com.demo.boot.dao.UsuarioDaoImpl;
import com.demo.boot.dao.VideoDao;
import com.demo.boot.entities.Video;
import com.demo.boot.model.Usuario;

public class VideoController extends BaseController implements IController {
	
	private VideoDao videoDao;
	

	public VideoController() {
		this.view = "video";
		videoDao = new VideoDao();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List <Video> list = videoDao.list();
		request.setAttribute("list", list);
		forward(request, response, "list");
		
	}

	@Override
	public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("update");
		
		int id = Integer.parseInt(request.getParameter("id"));
		String nombre = request.getParameter("nombre");
		String descripcion = request.getParameter("descripcion");
		String enlace = request.getParameter("enlace");
		
		Video video = videoDao.find(id);
		
		video.setEnlace(enlace);
		video.setDescripcion(descripcion);
		video.setNombre(nombre);
		
		videoDao.update(video);
		
		redirect(request, response, "list");
		
	}

	@Override
	public void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		Video video = videoDao.find(id);
		
		request.setAttribute("object", video);
		forward(request, response, "form");
		
	}

	@Override
	public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Video video = videoDao.find(id);
		
		videoDao.delete(video);
		redirect(request, response, "list");
		
	}

	@Override
	public void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Insertar Video");
		String nombre = request.getParameter("nombre");
		String descripcion = request.getParameter("descripcion");
		String enlace = request.getParameter("enlace");
		
		Video video = new Video();
		
		video.setEnlace(enlace);
		video.setDescripcion(descripcion);
		video.setNombre(nombre);
		
		videoDao.insert(video);
		redirect(request, response, "list");
		
	}

	@Override
	public void cnew(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		forward(request, response, "form");
		
	}
	
	private Usuario obtenerPropietario() {
		UsuarioDao usuarioDao = new UsuarioDaoImpl(this.type);
		Usuario u = usuarioDao.select(1);
		return null;
	}
	

}
