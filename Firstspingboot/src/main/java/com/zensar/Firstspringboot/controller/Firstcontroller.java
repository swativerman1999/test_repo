package com.zensar.Firstspringboot.controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Firstcontroller {
	
	@RequestMapping("/")
	public String welcome() {
		return "Welcome to String Boot";
	}
	
	@RequestMapping("/hello")
	public String hello() {
		return "Hellow World";
	}
	
	//Hello zensar
	

}
