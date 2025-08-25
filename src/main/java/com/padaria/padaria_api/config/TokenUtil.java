//package com.padaria.padaria_api.config;
//
//import com.padaria.padaria_api.models.Usuario;
//import io.jsonwebtoken.security.Keys;
//
//
//public class TokenUtil {
//
//    private static final String HEADER = "Authorization";
//    private static final String PREFIX = "Bearer ";
//    private static final long EXPIRATION = 12*60*60*1000;
//private static final String SECRET_KEY = "MyK3yt0T0k3nP4r@S3CuRiTY@Sp3c14L";
//private static final String EMISSOR = "DevNice";
//
//private static String createToken(Usuario usuario) {
//    Key secretKey = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
//    String token = Jwts.builder().setSubject(usuario.getNome
//        return null;
//
//
//    }
//}
