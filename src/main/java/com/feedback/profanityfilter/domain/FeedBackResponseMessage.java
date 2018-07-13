package com.feedback.profanityfilter.domain;

public enum FeedBackResponseMessage {
	SUCCESS("Feedback posted successfully"),
	PROFANITY("Profanity has been detected. Please rephrase your feedback.");

	private String message;

	private FeedBackResponseMessage(String message){
		this.message = message;
	}

	public String getMessage() {
		return this.message;
	}
}
