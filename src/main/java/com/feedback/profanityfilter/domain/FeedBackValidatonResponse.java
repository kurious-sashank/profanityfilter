package com.feedback.profanityfilter.domain;

public class FeedBackValidatonResponse {
	private boolean valid;
	private String message;

	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public static FeedBackValidatonResponse getSuccessTemplate(){
		FeedBackValidatonResponse response = new FeedBackValidatonResponse();
		response.setValid(true);
		response.setMessage(FeedBackResponseMessage.SUCCESS.getMessage());
		return response;
	}
}
