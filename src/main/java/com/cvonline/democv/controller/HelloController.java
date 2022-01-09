package com.cvonline.democv.controller;

import java.time.LocalDate;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class HelloController {
	
	@GetMapping ("/Hello")
	public String hello () {
		return "Hello the date is " + LocalDate.now();
	}

}
