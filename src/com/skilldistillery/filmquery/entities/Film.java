package com.skilldistillery.filmquery.entities;

import java.util.ArrayList;

public class Film {
	private int id;
	private String title; 
	private String description; 
	private int releasYear;
	private int languageId;
	private int rentalDuration;
	private double rental_rate;
	private int length;
	private double replacement_cost; 
	private String rating;
	private String specialFeatures;
	private ArrayList <Actor> actor = new ArrayList<>(); 
	
	
	
	public Film() {
	}


	

	public Film(int id, String title, String description, int releasYear, int languageId, int rentalDuration,
			double rental_rate, int length, double replacement_cost, String rating, String specialFeatures) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.releasYear = releasYear;
		this.languageId = languageId;
		this.rentalDuration = rentalDuration;
		this.rental_rate = rental_rate;
		this.length = length;
		this.replacement_cost = replacement_cost;
		this.rating = rating;
		this.specialFeatures = specialFeatures;
	}



 
	public Film(int id, String title, String description, int releasYear, int languageId, int rentalDuration,
			double rental_rate, int length, double replacement_cost, String rating, String specialFeatures,
			ArrayList<Actor> actor) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.releasYear = releasYear;
		this.languageId = languageId;
		this.rentalDuration = rentalDuration;
		this.rental_rate = rental_rate;
		this.length = length;
		this.replacement_cost = replacement_cost;
		this.rating = rating;
		this.specialFeatures = specialFeatures;
		this.actor = actor;
	}

	public int getId() {
		return id;
	}



	public String getTitle() {
		return title;
	}



	public String getDescription() {
		return description;
	}



	public int getReleasYear() {
		return releasYear;
	}



	public int getLanguageId() {
		return languageId;
	}



	public int getRentalDuration() {
		return rentalDuration;
	}



	public double getRental_rate() {
		return rental_rate;
	}



	public int getLength() {
		return length;
	}



	public double getReplacement_cost() {
		return replacement_cost;
	}



	public String getRating() {
		return rating;
	}



	public String getSpecialFeatures() {
		return specialFeatures;
	}



	public void setId(int id) {
		this.id = id;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public void setReleasYear(int releasYear) {
		this.releasYear = releasYear;
	}



	public void setLanguageId(int languageId) {
		this.languageId = languageId;
	}



	public void setRentalDuration(int rentalDuration) {
		this.rentalDuration = rentalDuration;
	}



	public void setRental_rate(double rental_rate) {
		this.rental_rate = rental_rate;
	}



	public void setLength(int length) {
		this.length = length;
	}



	public void setReplacement_cost(double replacement_cost) {
		this.replacement_cost = replacement_cost;
	}



	public void setRating(String rating) {
		this.rating = rating;
	}



	public void setSpecialFeatures(String specialFeatures) {
		this.specialFeatures = specialFeatures;
	}


	public ArrayList<Actor> getActor() {
		return actor;
	}


	public void setActor(ArrayList<Actor> actor) {
		this.actor = actor;
	}

	public void displayMyway() { System.out.println("Film: " + this.title + 
			" Released in " + this.releasYear + " Rating " + this.rating + 
			"\n Description: " + this.description);
	}
	
	@Override
	public String toString() {
		return "Film [id=" + id + ", title=" + title + ", description=" + description + ", releasYear=" + releasYear
				+ ", languageId=" + languageId + ", rentalDuration=" + rentalDuration + ", rental_rate=" + rental_rate
				+ ", length=" + length + ", replacement_cost=" + replacement_cost + ", rating=" + rating
				+ ", specialFeatures=" + specialFeatures + ", actor=" + actor + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((actor == null) ? 0 : actor.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + id;
		result = prime * result + languageId;
		result = prime * result + length;
		result = prime * result + ((rating == null) ? 0 : rating.hashCode());
		result = prime * result + releasYear;
		result = prime * result + rentalDuration;
		long temp;
		temp = Double.doubleToLongBits(rental_rate);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(replacement_cost);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((specialFeatures == null) ? 0 : specialFeatures.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Film other = (Film) obj;
		if (actor == null) {
			if (other.actor != null)
				return false;
		} else if (!actor.equals(other.actor))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id != other.id)
			return false;
		if (languageId != other.languageId)
			return false;
		if (length != other.length)
			return false;
		if (rating == null) {
			if (other.rating != null)
				return false;
		} else if (!rating.equals(other.rating))
			return false;
		if (releasYear != other.releasYear)
			return false;
		if (rentalDuration != other.rentalDuration)
			return false;
		if (Double.doubleToLongBits(rental_rate) != Double.doubleToLongBits(other.rental_rate))
			return false;
		if (Double.doubleToLongBits(replacement_cost) != Double.doubleToLongBits(other.replacement_cost))
			return false;
		if (specialFeatures == null) {
			if (other.specialFeatures != null)
				return false;
		} else if (!specialFeatures.equals(other.specialFeatures))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}


}

