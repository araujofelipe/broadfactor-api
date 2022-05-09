package com.broadfactor.api.common;
public class Constantes {
	
	private Constantes() {}
	
	public static final String PATH_API_VERSION = "/api/v1" ;
	
	public static final String LOGIN_PATH = PATH_API_VERSION + "/login";
	
	public static final String USUARIO_CREATE_PATH = PATH_API_VERSION + "/usuario";
	
	public static final String [] PUBLIC_PATHS = {LOGIN_PATH, USUARIO_CREATE_PATH}; 
}
