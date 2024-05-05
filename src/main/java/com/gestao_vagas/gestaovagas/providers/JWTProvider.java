package com.gestao_vagas.gestaovagas.providers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;

@Service
public class JWTProvider {
  @Value("${security.token.secret}")
  private String secretKey;

  public String validateToken(String token) {
    token = token.replace("Bearer ", "");
    Algorithm algorithm = Algorithm.HMAC256(secretKey);

    try {
      var result = JWT.require(algorithm).build().verify(token).getSubject();
      return result;
    } catch (JWTVerificationException e) {
      e.printStackTrace();
      return "";
    }
  }
}
