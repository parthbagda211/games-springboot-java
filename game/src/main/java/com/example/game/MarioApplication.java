package com.example.game;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

@SpringBootApplication
public class MarioApplication {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		Scanner scanner = new Scanner(System.in);

		System.out.println("Select a game to run: ");
		System.out.println("1. Pacman");
		System.out.println("2. Mario");
		System.out.println("3. TempleRun");
//		System.out.println("0. Default");

		int choice = scanner.nextInt();
		scanner.close();

		Game game;
//
//		if(choice==1){
//			game = (Game) context.getBean("pacman");
//		}
		switch (choice) {
			case 1:
				game = (Game) context.getBean("pacman");
				break;
			case 2:
				game = (Game) context.getBean("mario");
				break;
			case 3:
				game = (Game) context.getBean("templeRun");
				break;
			default:
				game = (Game) context.getBean("defaultGame");
		}

		GameRunner gameRunner = new GameRunner(game);
		gameRunner.run();
	}

}
