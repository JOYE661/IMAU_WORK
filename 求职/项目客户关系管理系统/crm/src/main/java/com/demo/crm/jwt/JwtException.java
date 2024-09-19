package com.demo.crm.jwt;

public class JwtException extends RuntimeException {
    public JwtException() {
        super("Token错误");
    }
}
