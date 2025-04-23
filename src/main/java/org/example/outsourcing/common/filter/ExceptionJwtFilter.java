package org.example.outsourcing.common.filter;

import java.io.IOException;

import org.example.outsourcing.common.dto.CommonResponse;
import org.example.outsourcing.common.filter.exception.FilterException;
import org.springframework.web.filter.OncePerRequestFilter;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;

public class ExceptionJwtFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(
		@NonNull HttpServletRequest request,
		@NonNull HttpServletResponse response,
		@NonNull FilterChain filterChain
	) throws ServletException, IOException {
		ObjectMapper objectMapper = new ObjectMapper();

		try {
			filterChain.doFilter(request, response);
		} catch (FilterException filterException) {
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			objectMapper.writeValue(
				response.getWriter(),
				CommonResponse.from(filterException.getResponseCode())
			);
		}
	}
}