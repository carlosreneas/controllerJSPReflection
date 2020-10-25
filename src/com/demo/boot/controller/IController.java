package com.demo.boot.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface IController {
	public void probar();
	
	public void cargar(HttpServletRequest request, HttpServletResponse response, String action) throws ServletException, IOException;
	
	public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException;

	public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException;

	public void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException ;

	public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException;

	public void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException;

	public void cnew(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException ;
	
	
}
