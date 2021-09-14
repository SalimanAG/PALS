package com.sil.gpc.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

public class AuthorizationFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT, OPTIONS");
		response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept, Accept-Encoding, Accept-Language, Host, Referer, Connection, User-Agent, authorization, sw-useragent, sw-version");
		response.setHeader("Access-Control-Expose-Headers", "Access-Control-Allow-Credentials");
		
		if(request.getMethod() == HttpMethod.OPTIONS.toString()) {
			response.setStatus(HttpStatus.OK.value());
		}
		else {
			
			String token = request.getHeader(SecurityConstante.STRING_HEADER);
			
			if(token == null || !token.startsWith(SecurityConstante.PREFIX) ) {
				filterChain.doFilter(request, response);
			}
			else {
				
				Claims claims = Jwts.parser()
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
