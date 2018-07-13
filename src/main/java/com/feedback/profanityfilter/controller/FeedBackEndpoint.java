package com.feedback.profanityfilter.controller;

import com.feedback.profanityfilter.service.FeedBackValidationManager;
import com.feedback.profanityfilter.validator.IFeedBackValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeedBackEndpoint {

	@Autowired
	private FeedBackValidationManager validationManager;

	@RequestMapping(value = "/feedback", method = RequestMethod.POST)
	@ResponseBody
	public String recieveFeedBack(@RequestParam("comment")String comment){
		return validationManager.triggerValidation(comment).getMessage();
	}
}
