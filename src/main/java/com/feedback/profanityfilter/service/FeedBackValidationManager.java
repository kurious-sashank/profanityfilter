package com.feedback.profanityfilter.service;

import com.feedback.profanityfilter.ProfanityfilterApplication;
import com.feedback.profanityfilter.domain.FeedBackValidatonResponse;
import com.feedback.profanityfilter.validator.IFeedBackValidator;
import com.feedback.profanityfilter.validator.ProfanityValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FeedBackValidationManager {

	private List<IFeedBackValidator> validators = new ArrayList<>();
	private ProfanityValidator profanityValidator;

	@Autowired
	public FeedBackValidationManager(ProfanityValidator profanityValidator){
			validators.add(profanityValidator);
	}

	public FeedBackValidatonResponse triggerValidation(String feedBack){
		boolean result = true;
		String message = "Validaton Succeeded";
		FeedBackValidatonResponse response = FeedBackValidatonResponse.getSuccessTemplate();
		for(IFeedBackValidator validator:validators){
			response = validator.validate(feedBack);
			if(!response.isValid()){
				return response;
			}
		}
		return response;
	}
}
