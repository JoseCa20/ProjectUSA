package com.JeicTechnology.TCB.security;

import com.JeicTechnology.TCB.exception.UnauthorizedException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
public class JwtAuthFilter extends OncePerRequestFilter {

    private final JwtAuthenticationProvider jwtAuthenticationProvider;

    //Lista de url´s que se deben omitir en la autenticación JWT
    private List<String> urlsToSkip = Arrays.asList("/auth/sign-up", "/auth/sign-in");

    // Método para determinar si se debe omitir el filtro para una solicitud específica
    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        return urlsToSkip.stream().anyMatch(url -> request.getRequestURI().contains(url));
    }

    // Método principal para realizar la lógica de filtrado
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        // Obtener el encabezado Authorization de la solicitud
        String header = request.getHeader(HttpHeaders.AUTHORIZATION);

        // Verificar si el encabezado está ausente
        if(header == null){
            try {
                throw new UnauthorizedException();
            } catch (UnauthorizedException e) {
                throw new RuntimeException(e);
            }
        }

        // Dividir el encabezado Authorization para extraer el token JWT
        String[] authElements = header.split(" ");

        // Verificar el formato del encabezado Authorization
        if(authElements.length != 2 || !"Bearer".equals(authElements[0])) {
            throw new UnauthorizedException();
        }

        try {
            // Validar el token JWT utilizando JwtAuthenticationProvider
            Authentication auth = jwtAuthenticationProvider.validateToken(authElements[1]);

            // Establecer la autenticación válida en el contexto de seguridad
            SecurityContextHolder.getContext().setAuthentication(auth);
        }catch (RuntimeException e){
            // Limpiar el contexto de seguridad en caso de excepción
            SecurityContextHolder.clearContext();
            // Lanza una excepción de RuntimeException en caso de error durante la validación del token
            throw new RuntimeException(e);
        }
        // Continuar con la cadena de filtros
        filterChain.doFilter(request, response);
    }


}
