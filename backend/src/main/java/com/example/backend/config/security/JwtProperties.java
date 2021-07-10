package com.example.backend.config.security;

public class JwtProperties {
    public static final String SECRET = "SECRET";
    public static final int EXPIRATION_TIME = 864_000_000;
    public static final String TOKEN_PREFIX = "Bearer ";
    private JwtProperties() {
    }
}