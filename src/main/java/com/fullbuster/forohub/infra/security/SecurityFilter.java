package com.fullbuster.forohub.infra.security;

import com.fullbuster.forohub.domain.usuario.UsuarioRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    @Autowired
    private TokenService tokenService;
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {   // Se sobreescriben los methods de la clase OncePerRequestFilter
        // Obtener el token del header
        var authHeader = request.getHeader("Authorization");

        if (authHeader != null) {
            // Dando un mejor formato al request del token
            var token = authHeader.replace("Bearer ", "");

            var subject = tokenService.getSubject(token);
            if (subject != null) {
                // Token valido
                var usuario = usuarioRepository.findByCorreo(subject);
                var authentication = new UsernamePasswordAuthenticationToken(usuario, null, usuario.getAuthorities());  // Forzamos un inicio de sesión
                SecurityContextHolder.getContext().setAuthentication(authentication);   // Sereamos manualmente la autentiicacion
            }

        }
        filterChain.doFilter(request, response);    // Pasamos los requests al siguiente filtro
    }

}
