package com.synex.domain;

public class Feedback {
	private int bookingId;
	private int starRating;
	private String feedback;
	
	public Feedback() {
		super();
	}

	public Feedback(int bookingId, int starRating, String feedback) {
		super();
		this.bookingId = bookingId;
		this.starRating = starRating;
		this.feedback = feedback;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public int getStarRating() {
		return starRating;
	}

	public void setStarRating(int starRating) {
		this.starRating = starRating;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	@Override
	public String toString() {
		return "Feedback [bookingId=" + bookingId + ", starRating=" + starRating + ", feedback=" + feedback + "]";
	}
	
	
}
