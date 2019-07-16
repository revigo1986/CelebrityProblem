package com.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.services.IOrchestator;

@RestController
public class Controller {

	@Autowired
	private IOrchestator orchestator;

	@RequestMapping(path = "/CelebrityProblem", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public Integer findTheCelebrity() throws IOException {
		return orchestator.execute();
	}
}
