package com.synex.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Reviews {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int feedbackId;
	private int starRating;
	private String feedback;
	
	public Reviews() {
		super();
	}

	public Reviews(int feedbackId, int starRating, String feedback) {
		super();
		this.feedbackId = feedbackId;
		this.starRating = starRating;
		this.feedback = feedback;
	}

	public int getFeedbackId() {
		return feedbackId;
	}

	public void setFeedbackId(int feedbackId) {
		this.feedbackId = feedbackId;
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
		return "Reviews [feedbackId=" + feedbackId + ", starRating=" + starRating + ", feedback=" + feedback + "]";
	}
	
	
}
