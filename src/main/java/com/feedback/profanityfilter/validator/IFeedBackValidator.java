package com.feedback.profanityfilter.validator;

import com.feedback.profanityfilter.domain.FeedBackValidatonResponse;

public interface IFeedBackValidator {
	public FeedBackValidatonResponse validate(String feedBack);
}
