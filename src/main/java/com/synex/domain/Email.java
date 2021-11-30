package com.synex.domain;

public class Email {
	private String subject;
	private String textbody;
	
	public Email() {}

	public Email(String subject, String textbody) {
		super();
		this.subject = subject;
		this.textbody = textbody;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getTextbody() {
		return textbody;
	}

	public void setTextbody(String textbody) {
		this.textbody = textbody;
	}

	@Override
	public String toString() {
		return "Email [subject=" + subject + ", textbody=" + textbody + "]";
	}
	
}
