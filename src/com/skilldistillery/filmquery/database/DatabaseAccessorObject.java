package com.skilldistillery.filmquery.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public class DatabaseAccessorObject implements DatabaseAccessor {

	private static final String url = "jdbc:mysql://localhost:3306/sdvid?useSSL=false";
	private final String userName = "student";
	private final String password = "student";

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Film findFilmById(int filmId) {
		Film film = null;

		try {
			Connection conn = DriverManager.getConnection(url, userName, password);
			String sql = "SELECT film.id, title, description, release_year, rating, name FROM film JOIN language ON language.id = film.language_id WHERE film.id = ?";

			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, filmId);
			ResultSet filmResult = stmt.executeQuery();
			if (filmResult.next()) {
				film = new Film();
				film.setId(filmResult.getInt(1));
				film.setTitle(filmResult.getString(2));
				film.setDescription(filmResult.getString(3));
				film.setReleasYear(filmResult.getInt(4));
				film.setRating(filmResult.getString(5));
				film.setLanguage(filmResult.getString(6));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return film;
	}

	@Override
	public List<Film> findFilmByKeyword(String filmTitle) {
		List<Film> films = new ArrayList<>();

		try {
			Connection conn = DriverManager.getConnection(url, userName, password);

			String sql = "SELECT title, description, release_year, rating FROM film WHERE description LIKE ? OR title LIKE ?";

			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setString(1, "%" + filmTitle + "%");
			stmt.setString(2, "%" + filmTitle + "%");

			ResultSet filmResult = stmt.executeQuery();


			while (filmResult.next()) {
				Film film = new Film(); 
				film.setTitle(filmResult.getNString("title"));
				film.setDescription(filmResult.getString("description"));
				film.setReleasYear(filmResult.getInt("release_Year"));
				film.setRating(filmResult.getString("rating"));
				films.add(film);
			}
			filmResult.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return films;
	}

	@Override
	public List<Actor> findActorsByFilmId(int filmId) {
		List<Actor> actors = new ArrayList<>();

		try {
			Connection conn = DriverManager.getConnection(url, userName, password);
			String sql = "SELECT actor.id, actor.first_name, actor.last_name " + "FROM actor "
					+ "JOIN film_actor ON film_actor.actor_id = actor.id "
					+ "JOIN film ON film_actor.film_id = film.id " + "WHERE film.id = ?";

			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, filmId);
			ResultSet actorResult = stmt.executeQuery();

			while (actorResult.next()) {
				Actor actor = new Actor();
				actor.setId(actorResult.getInt(1));
				actor.setFirstName(actorResult.getNString(2));
				actor.setLastName(actorResult.getNString(3));
				actors.add(actor);
			}

			actorResult.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return actors;
	}

	@Override
	public Actor findActorById(int actorId) {
		return null;
	}

}
