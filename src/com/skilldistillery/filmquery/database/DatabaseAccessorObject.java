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
			String sql = "SELECT id, title FROM film WHERE id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, filmId);
			ResultSet filmResult = stmt.executeQuery();
			if (filmResult.next()) {
				film = new Film(); 
				film.setId(filmResult.getInt(1));
				film.setTitle(filmResult.getString(2));
			}
					
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return film;
	}

	public Actor findActorById(int actorId) {
		Actor actor = null;

		try {

			Connection conn = DriverManager.getConnection(url, userName, password);

			String sql = "SELECT id, first_name, last_name FROM actor WHERE id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, actorId);
			ResultSet actorResult = stmt.executeQuery();
			if (actorResult.next()) {
				actor = new Actor();
				actor.setId(actorResult.getInt(1));
				actor.setFirstName(actorResult.getString(2));
				actor.setLastName(actorResult.getString(3));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return actor;
	}


	public List<Actor> findActorsByFilmId(int filmId) {
		List<Actor> actors = new ArrayList<>();
		
		try {
			Connection conn = DriverManager.getConnection(url, userName, password);
			String sql = "SELECT actor.id, actor.first_name, actor.last_name "
					+ "FROM actor "
					+ "JOIN film_actor ON film_actor.actor_id = actor.id "
					+ "JOIN film ON film_actor.film_id = film.id "
					+ "WHERE film.id = ?";
	
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, filmId);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {			
				int actorId = rs.getInt(1); 
				String firstName = rs.getString(2);
				String lastName = rs.getString(3); 	
				Actor actor = new Actor(actorId, firstName, lastName);
				actors.add(actor);	
//				System.out.println(actor + " inside find actors by film id");
			}
			
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return actors;
	}

//	@Override
//	public List<Actor> findActorsByFilmId(int filmId) {
//		// TODO Auto-generated method stub
//		return null;
//	}

//	@Override
//	public List<Actor> findActorsByFilmId(int filmId) {
//		// TODO Auto-generated method stub
//		return null;
//	}



}
