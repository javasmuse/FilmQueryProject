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
			Film film = db.findFilmById(numb);
			film.displayMyway();
			System.out.println("Actors:");
			List<Actor> actors = db.findActorsByFilmId(numb);
			for (Actor actor : actors) {
				System.out.println(actor);
			}
			break;
		case (2):
			System.out.println("Please enter a keyword: ");
			String kw = input.next();
			List<Film> films = db.findFilmByKeyword(kw);
			for (Film film2 : films) {
				System.out.println(film2);
			}
			break;
		case (0):
			break;
		}
	}
}
