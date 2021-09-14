package com.sil.gpc.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.sil.gpc.domains.Utilisateur;
import com.sil.gpc.repositories.UtilisateurRepository;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class AuthorizationFilter extends OncePerRequestFilter {



	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT, OPTIONS");
		response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept, Accept-Encoding, Accept-Language, Host, Referer, Connection, User-Agent, authorization, sw-useragent, sw-version");
		response.setHeader("Access-Control-Expose-Headers", "Access-Control-Allow-Credentials");
		
		if(request.getMethod().equals(HttpMethod.OPTIONS.toString())) {
			response.setStatus(HttpStatus.OK.value());
		}
		else {
			
			String token = request.getHeader(SecurityConstante.STRING_HEADER);
			
			if(token == null) {
				
				if(request.getRequestURI().startsWith(SecurityConstante.STRING_ASK_URI) && request.getMethod().equals(HttpMethod.GET.toString())) {
					
					//System.out.println(request.getRequestURI());
					
					WebApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(request.getServletContext());
					
					UtilisateurRepository serviceUser = ctx.getBean(UtilisateurRepository.class);
					
					String login = request.getRequestURI().replace(SecurityConstante.STRING_ASK_URI, "");
					//System.out.println("**********login : "+login+" test "+serviceUser);
					Utilisateur utilisateur = serviceUser.findByLogin(login);
					if(utilisateur.isAskMdp1erLance()) {
						
						String newTok = Jwts.builder()
								.setSubject(utilisateur.getLogin())
								.setExpiration(new Date(System.currentTimeMillis()+(SecurityConstante.ASK_EXPIRATION*1000)))
								.signWith(SignatureAlgorithm.HS256, SecurityConstante.CLE)
								.claim(SecurityConstante.STRING_ROLES, new ArrayList<>())
								.compact();
				
						response.addHeader(SecurityConstante.STRING_HEADER, SecurityConstante.PREFIX+newTok);
						response.setStatus(HttpStatus.OK.value());
						
					}
					else {
						
						filterChain.doFilter(request, response);
					}
				}
				else {
					filterChain.doFilter(request, response);
				}
				
			}
			else if(!token.startsWith(SecurityConstante.PREFIX)) {
				filterChain.doFilter(request, response);
			}
			else {
				
				Claims claims = null;
				
				claims = Jwts.parser()
						.setSigningKey(SecurityConstante.CLE)
						.parseClaimsJws(token.replace(SecurityConstante.PREFIX, ""))
						.getBody();
				
				String login = claims.getSubject();
				
				List<Map<String, String>> roles = (List<Map<String, String>>) claims.get(SecurityConstante.STRING_ROLES);
				
				Collection<GrantedAuthority> authorities = new ArrayList<>();
				
				roles.forEach(r-> {
					authorities.add(new SimpleGrantedAuthority(r.get("authority")));
				});
				
				UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(login, null, authorities);
				
				SecurityContextHolder.getContext().setAuthentication(authentication);
				
				filterChain.doFilter(request, response);
				
			}
			
		}
		
	}

}
