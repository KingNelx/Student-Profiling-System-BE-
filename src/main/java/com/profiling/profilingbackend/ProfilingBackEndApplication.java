package com.profiling.profilingbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProfilingBackEndApplication {
	public static void main(String[] args) {
		SpringApplication.run(ProfilingBackEndApplication.class, args);
	}

	/*
	 * public class PasswordProtectionProgram {
	 * public static void main(String[] args) {
	 * HashMap<String, String> credentials = new HashMap<>();
	 * credentials.put("user1", "password123");
	 * credentials.put("user2", "abc123");
	 * Scanner scanner = new Scanner(System.in);
	 * System.out.print("Enter your username: ");
	 * String username = scanner.nextLine();
	 * System.out.print("Enter your password: ");
	 * String enteredPassword = scanner.nextLine();
	 * String correctPassword = credentials.get(username);
	 * if (correctPassword != null && enteredPassword.equals(correctPassword)) {
	 * System.out.println("Access granted! You have entered the correct password.");
	 * } else {
	 * System.out.println("Access denied! Incorrect username or password.");
	 * }
	 * scanner.close();
	 * }
	 * }
	 */
}
