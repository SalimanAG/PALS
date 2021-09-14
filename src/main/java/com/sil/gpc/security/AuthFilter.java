package com.sil.gpc.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.sil.gpc.domains.Utilisateur;
import com.sil.gpc.repositories.UtilisateurRepository;
import com.sil.gpc.services.UtilisateurService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class AuthFilter extends UsernamePasswordAuthenticationFilter{
	
	private AuthenticationManager authenticationManager;
	
	
	
	public AuthFilter(AuthenticationManager authenticationManager) {
		super();
		this.authenticationManager = authenticationManager;
	}



	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		// TODO Auto-generated method stub
		
		Utilisateur utilisateur = null;
		
		try {
			utilisateur = new ObjectMapper().readValue(request.getInputStream(), Utilisateur.class);
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
		
		//System.out.println("*********user : "+utilisateur);
		
		return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(utilisateur.getLogin(), utilisateur.getMotDePass()));//super.attemptAuthentication(request, response);
	}
	
	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		// TODO Auto-generated method stub
		//super.successfulAuthentication(request, response, chain, authResult);
		
		User springUser = (User) authResult.getPrincipal();
		
		/*WebApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(request.getServletContext());
		
		UtilisateurService serviceUser = ctx.getBean(UtilisateurService.class);
		Collection<GrantedAuthority> authorities = new ArrayList<>();
		
		serviceUser.getRolesByUserLogin(serviceUser.findByLoginUtilisateur(springUser.getUsername())).forEach(r->{
			authorities.add(new SimpleGrantedAuthority(r));
		});*/
		
		String token = Jwts.builder()
						.setSubject(springUser.getUsername())
						.setExpiration(new Date(System.currentTimeMillis()+(SecurityConstante.EXPIRATION*1000)))
						.signWith(SignatureAlgorithm.HS256, SecurityConstante.CLE)
						.claim(SecurityConstante.STRING_ROLES, springUser.getAuthorities())
						.compact();
		
		response.addHeader(SecurityConstante.STRING_HEADER, SecurityConstante.PREFIX+token);
		
		
	}

}
