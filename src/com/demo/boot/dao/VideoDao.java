package com.demo.boot.dao;

import com.demo.boot.entities.Video;
import com.demo.boot.util.ConexionJPA;

public class VideoDao 
extends ConexionJPA<Video> 
implements GenericDao<Video> {

public VideoDao() {
	super(Video.class);
}

}
