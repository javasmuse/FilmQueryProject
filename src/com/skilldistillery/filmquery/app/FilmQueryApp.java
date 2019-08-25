package com.skilldistillery.filmquery.app;

import java.util.List;
import java.util.Scanner;

import com.skilldistillery.filmquery.database.DatabaseAccessor;
import com.skilldistillery.filmquery.database.DatabaseAccessorObject;
import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public class FilmQueryApp {

	DatabaseAccessor db = new DatabaseAccessorObject();

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
			if (numb < 1001) {
				Film film = db.findFilmById(numb);
				film.displayMyway();
				System.out.println("Actors:");
				List<Actor> actors = db.findActorsByFilmId(numb);
				for (Actor actor : actors) {
					System.out.println(actor);
				}
				if (numb < 0) {
					System.out.println("Sorry there are only 1000 films available, please try again.");
					System.out.println();
					System.out.println();
					launch();
				}
			} else {
				System.out.println("Sorry there are only 1000 films available, please try again.");
				launch();
			}
			break;
		case (2):
			System.out.println("Please enter a keyword: ");
			String kw = input.next();
			List<Film> films = db.findFilmByKeyword(kw);
			for (Film film2 : films) {
				film2.displayMyway();
				int fID = film2.getId();
				System.out.println("Actors:");
				List<Actor> actors2 = db.findActorsByFilmId(fID);
				for (Actor act : actors2) {
					System.out.println(act);
				}
			}
			if (films.isEmpty()) {
				System.out.println();
				System.out.println();
				System.out.println("Sorry, I didn't understand your request. Please try again.");
				System.out.println();
				System.out.println();
				launch();
			} else {
				System.out.println();
				System.out.println();
				launch();
			}
			break;
		case (0):
			System.out.println("Are you sure?");
			break;
		default:
			launch();
			break;
		}

		System.out.println("\n\nWould you like to try again? (press 1 for Yes / 0 for No)");
		int rePlay = input.nextInt();
		switch (rePlay) {
		case (1):
			System.out.println();
			System.out.println();
			launch();
			break;
		case (0):
			break;
		default:
			System.out.println("Sorry, I didn't get that. Game Over.");
		}
	}

}
