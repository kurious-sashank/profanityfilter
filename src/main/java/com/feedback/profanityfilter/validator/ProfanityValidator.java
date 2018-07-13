package com.feedback.profanityfilter.validator;

import com.feedback.profanityfilter.domain.FeedBackResponseMessage;
import com.feedback.profanityfilter.domain.FeedBackValidatonResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@Component
public class ProfanityValidator implements IFeedBackValidator{

	@Value("#{'${profanities}'.split(',')}")
	private List<String> profanities;

	@Override
	public FeedBackValidatonResponse validate(String feedBack) {
		FeedBackValidatonResponse response = FeedBackValidatonResponse.getSuccessTemplate();
		for(String word : feedBack.split("\\s+")) {
				if(profanities.contains(word)){
					response = new FeedBackValidatonResponse();
					response.setMessage(FeedBackResponseMessage.PROFANITY.getMessage());
					response.setValid(false);
					break;
				}
		}
		return response;
	}
}
