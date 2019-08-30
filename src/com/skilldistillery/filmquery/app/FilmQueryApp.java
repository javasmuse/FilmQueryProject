package com.skilldistillery.filmquery.app;

import java.util.List;
import java.util.Scanner;

import com.skilldistillery.filmquery.database.DatabaseAccessor;
import com.skilldistillery.filmquery.database.DatabaseAccessorObject;
import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public class FilmQueryApp {

	DatabaseAccessor db = new DatabaseAccessorObject();
	boolean keepGoing = true; 

	public static void main(String[] args) {
		FilmQueryApp app = new FilmQueryApp();
//		app.test();
		app.launch();
	}

	private void test() {
		Film film = db.findFilmById(25);
		Actor actor = db.findActorById(5);
		List<Actor> actors = db.findActorsByFilmId(33);
		List<Film> films = db.findFilmByKeyword("thrilling");

		System.out.println(film);
		System.out.println(actor);
		System.out.println(actors);
		System.out.println(films);
	}

	private void launch() {
		Scanner input = new Scanner(System.in);

		startUserInterface(input);

		input.close();
	}

	private void startUserInterface(Scanner input) {

		do {
			
		System.out.println("                *************   Welcome to Lewy's Omniplex   *************");
		System.out.println(
				"****************************                                  ************************************");
		System.out.println(
				"******  Your typical theatre experience complete with sticky floors and overpriced popcorn  ******");
		System.out.println();
		System.out.println("Please make a choice: ");
		System.out.println("Look up a film by its id (1)");
		System.out.println("Look up a film by a keyword (2)");
		System.out.println("Exit application (0)");
		int choice = input.nextInt();
		
		switch (choice) {
		case (1):
			System.out.println("Please enter an id: ");
			int numb = input.nextInt();
			
			Film film = db.findFilmById(numb);
			if (film == null) {
				System.out.println("Sorry, I can't find a film with that id. Please try again.\n\n");
				keepGoing = true; 
				break;
			} else { 
				
				film.displayMyway();
				
				System.out.println("Actors:");
				List<Actor> actors = db.findActorsByFilmId(numb);
				for (Actor actor : actors) {
					System.out.println(actor);
				}   
				
				System.out.println(
						"\nWould you like to see every little detail about the film? (Press 1 for details / 0 for main menu)\n\n");
				int extra = input.nextInt();
				switch (extra) {
				case (1):
					film.displayDetailed();
					Film film2 = db.findCategory(numb);
					film2.displayCategory();
					System.out.println("\n\nBack to the main, you can exit from here or submit another query.\n\n");
					keepGoing = true; 
					break;
				case (0):    
					keepGoing = true; 
					break;
				default:
					System.out.println("I didn't understand your entry, please start again. \n\n");
					keepGoing = true; 
					break; 
				}
			}
			
				break;
		
		case (2):
			System.out.println("Please enter a keyword: ");
			String kw = input.next();
			List<Film> films = db.findFilmByKeyword(kw);
			for (Film film2 : films) {
				film2.displayMyway2();
			}

			if (films.isEmpty()) {
				System.out.println();
				System.out.println();
				System.out.println("Sorry, I couldn't find a match for " + kw);
				System.out.println("Let's start over.\n\n");
				System.out.println();
				keepGoing = true; 
			}
			keepGoing = true; 
			break;
		case (0):
			System.out.println("See ya later, alligator\n");
			keepGoing = false; 
			break;
		default:
			System.out.println("I didn't understand your entry, please start again. \n\n");
			keepGoing = true; 
			break;
		}  
} while (keepGoing); 	


}
	
}