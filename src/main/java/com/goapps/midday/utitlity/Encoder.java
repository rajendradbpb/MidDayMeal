package com.goapps.midday.utitlity;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class Encoder {
	public static String getEncodedText(String text) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(12); // Strength set as 12
		String encodedPassword = passwordEncoder.encode(text);
		return encodedPassword;
	}
	
	public static boolean isMatching(String text, String encodedText) {
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		return passwordEncoder.matches(text, encodedText);
	}
}
