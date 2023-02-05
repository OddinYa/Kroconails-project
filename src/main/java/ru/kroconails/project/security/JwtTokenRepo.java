package ru.kroconails.project.security;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.Getter;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.DefaultCsrfToken;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.UUID;

@Repository
public class JwtTokenRepo implements CsrfTokenRepository {
    @Getter
    private String secret;

    public JwtTokenRepo(){
        this.secret = "springsecret";
    }
    @Override
    public CsrfToken generateToken(HttpServletRequest request) {
        String id = UUID.randomUUID().toString().replace("-","");

        Date now = new Date();
        Date exp = Date.from(LocalDateTime.now().plusMinutes(35).atZone(ZoneId.systemDefault())
                .toInstant());

        String token = null;
        try {
            token = Jwts.builder()
                    .setId(id)
                    .setIssuedAt(now)
                    .setNotBefore(now)
                    .setExpiration(exp)
                    .signWith(SignatureAlgorithm.HS256,secret)
                    .compact();
        }catch (JwtException e){
            e.printStackTrace();
        }
        return new DefaultCsrfToken("x-csrf-token","_csrf",token);

    }

    @Override
    public void saveToken(CsrfToken token, HttpServletRequest request, HttpServletResponse response) {
    }

    @Override
    public CsrfToken loadToken(HttpServletRequest request) {
        return null;
    }
}
