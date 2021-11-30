package com.synex.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "support")
public class Support {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int supportId;
	
	private String question;
	private String answer;
	
	public Support() {
		super();
	}

	public Support(String question, String answer) {
		super();
		this.question = question;
		this.answer = answer;
	}

	public int getSupportId() {
		return supportId;
	}

	public void setSupportId(int supportId) {
		this.supportId = supportId;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	@Override
	public String toString() {
		return "Support [supportId=" + supportId + ", question=" + question + ", answer=" + answer + "]";
	}
	
	
}
