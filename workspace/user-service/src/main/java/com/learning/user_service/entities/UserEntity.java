package com.learning.user_service.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name = "users")
public class UserEntity {

	@Id
	@Column(name = "user_id")
	private Integer userID;
	
	@NotNull
	@Column(name="favourite_genre")
	private String favouriteGenre;

	public UserEntity(Integer userID, String favouriteGenre) {
		super();
		this.userID = userID;
		this.favouriteGenre = favouriteGenre;
	}

	public UserEntity() {
		super();
	}

	public Integer getUserID() {
		return userID;
	}

	public void setUserID(Integer userID) {
		this.userID = userID;
	}

	public String getFavouriteGenre() {
		return favouriteGenre;
	}

	public void setFavouriteGenre(String favouriteGenre) {
		this.favouriteGenre = favouriteGenre;
	}

	@Override
	public String toString() {
		return "UserEntity [userID=" + userID + ", favouriteGenre=" + favouriteGenre + "]";
	}
	
	
}
