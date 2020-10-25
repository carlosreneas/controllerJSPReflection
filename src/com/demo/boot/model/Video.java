package com.demo.boot.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Video implements Serializable {
	
	private int id;
	
	private String descripcion;
	
	private String nombre;
	
	private String enlace;
	
	private Usuario usuario;
	
}
