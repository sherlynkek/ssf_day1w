package sg.edu.nus.iss.vttp5_day1w;

import java.util.Collections;

import javax.swing.Spring;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.DefaultApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Vttp5Day1wApplication {

	public static void main(String[] args) {
		// SpringApplication.run(Vttp5Day1wApplication.class, args);

		// Creates an instance of the SpringApplication class for the Vttp5Day1wApplication class, 
		// which is your main Spring Boot application.
		// This object (app) will be used to configure and launch the Spring Boot application
		SpringApplication app = new SpringApplication(Vttp5Day1wApplication.class);
		// Initializes a variable port with a default value of "3000".
		// This will be used as the default server port 
		// if no specific port is provided through command-line arguments.
		String port = "3000";
		// Parses the command-line arguments passed to the application (args).
		// DefaultApplicationArguments is a Spring Boot utility that simplifies 
		// accessing arguments passed via the command line.
		ApplicationArguments argsOptions = new DefaultApplicationArguments(args);


		// Checks if the command-line arguments include an option named "port".
		// If found, retrieves the first value associated with the "port" option 
		// using getOptionValues("port").get(0) and updates the port variable.
		if(argsOptions.containsOption("port")) {
			port = argsOptions.getOptionValues("port").get(0);
		}


		// Dynamically sets the server.port property for the Spring Boot application.
		// This determines the port the server will use when the application runs.
		// It allows running the application on a custom port without modifying the application.properties file.
		app.setDefaultProperties(Collections.singletonMap("server.port", port));


		// Initializes a variable dirFile as an empty string. 
		// This will later store the directory or file path if specified via command-line arguments.
		String dirFile = "";
		// Checks if a "file" option is provided in the command-line arguments.
		// If the "file" option is found:
		// Retrieves its value and assigns it to the dirFile variable.
		// Prints the directory or file path to the console using System.out.println.
		if(argsOptions.containsOption("file")) {
			dirFile = argsOptions.getOptionValues("file").get(0);

			System.out.println("Directory File: " + dirFile);
		}
		// Starts the Spring Boot application with the provided arguments.
		app.run(args);
	}
}
