package com.in28minutes.rest.webservices.restfulwebservices;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptEncoderTest {
	
	public static void main(String[] args) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		for (int i = 0; i < 10; i++) {
			String encodedString = encoder.encode("password!23@#!");
			System.out.println(encodedString);
			//$2a$10$QxF2RuKv9bZsSUBQsVW/HOhIkEOSW6bW.e/af7RsGnDuylf./NVeq
		}
	}

}
