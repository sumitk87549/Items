package com.inventory.mini.demo;

import org.springframework.security.crypto.password.PasswordEncoder;

public class JwtPasswordEncoder implements PasswordEncoder {

	@Override
	public String encode(CharSequence rawPassword) {
		return rawPassword.toString();
	}

	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		return rawPassword.toString().equals(encodedPassword);
	}

	public static PasswordEncoder getInstance() {
		return INSTANCE;
	}

	private static final PasswordEncoder INSTANCE = new JwtPasswordEncoder();

	private JwtPasswordEncoder() {
	}

}
