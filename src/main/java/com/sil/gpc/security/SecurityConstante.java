package com.sil.gpc.security;

public class SecurityConstante {
	
	public static final String CLE = "dom.pal2021Buc0*";
	public static final String PREFIX = "Bearer ";
	public static final String STRING_HEADER = "Authorization";
	public static final String STRING_ROLES = "roles";
	public static final long EXPIRATION = 120000000;//en seconde
	
	public static final String STRING_ASK_URI = "/utilisat/askMdp/";
	public static final String STRING_LOGIN_URI = "/login";
	public static final long ASK_EXPIRATION = 300;//en seconde
	
}
