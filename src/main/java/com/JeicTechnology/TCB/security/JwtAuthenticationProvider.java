package com.JeicTechnology.TCB.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.JeicTechnology.TCB.domain.dto.ClienteDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;

@Component
public class JwtAuthenticationProvider {

    @Value("${jwt.secret.key}")
    private String SecretKey;

    /**
     * lista blanca con los jwt creados
     */
    private HashMap<String, ClienteDto> listToken = new HashMap<>();

    public String createToken(ClienteDto clienteJwt){

        Date now = new Date();
        Date validity = new Date(now.getTime() + 3600000);

        Algorithm algorithm = Algorithm.HMAC256(SecretKey);

        String tokenCreated = JWT.create()
                .withClaim("idCard", clienteJwt.getIdCard())
                .withClaim("fullName", clienteJwt.getFullName())
                .withClaim("cellphone", clienteJwt.getCellphone())
                .withClaim("address", clienteJwt.getAddress())
                .withClaim("email", clienteJwt.getEmail())
                .withIssuedAt(now)
                .withExpiresAt(validity)
                .sign(algorithm);

        listToken.put(tokenCreated, clienteJwt);
        return tokenCreated;
    }

    public Authentication validateToken(String token) throws AuthenticationException {

        JWT.require(Algorithm.HMAC256(SecretKey)).build().verify(token);

        ClienteDto exists = listToken.get(token);
        if (exists == null){
            throw new BadCredentialsException("Usuario no registrado");
        }

        //UserDetails userDetails = User.withUsername(exists.getName()).password(exists.getPassword()).roles(exists.getRol()).build();
        //userDetails.getAuthorities().forEach(System.out::println);

        HashSet<SimpleGrantedAuthority> rolesAndAuthorities = new HashSet<>();
        rolesAndAuthorities.add(new SimpleGrantedAuthority("ROLE_"+exists.getRol()));
        rolesAndAuthorities.add(new SimpleGrantedAuthority("WRITE_PRIVILEGE"));

        return new UsernamePasswordAuthenticationToken(exists, token, rolesAndAuthorities);
    }

    public String deleteToken(String jwt){
        if(!listToken.containsKey(jwt)){
            return "No existe token";
        }
        listToken.remove(jwt);
        return "Sesión cerrada exitosamente";
    }
}
