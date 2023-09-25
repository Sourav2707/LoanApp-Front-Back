package com.bridgelabz.finserve.utility;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.stereotype.Component;

@Component
public class TokenUtility {
    private static final String TOKEN_SECRET = "Open_Sesame";

    public String generateToken(int Id) {
        Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
        String token = JWT.create().withClaim("Id", Id).sign(algorithm);
        return token;
    }
}
