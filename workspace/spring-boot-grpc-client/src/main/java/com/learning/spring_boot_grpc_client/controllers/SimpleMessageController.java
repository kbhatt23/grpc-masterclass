package com.learning.spring_boot_grpc_client.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.spring_boot_grpc_client.simplemessage.SimpleMessageClientService;
import com.learning.spring_boot_grpc_client.simplemessage.SimpleMessageDTO;

@RestController
@RequestMapping("/simple-message")
public class SimpleMessageController {

	@Autowired
	private SimpleMessageClientService service;
	
	@GetMapping("/{number}")
	public SimpleMessageDTO processSimpleMessage(@PathVariable int number) {
		return service.findResponse(number);
	}
}
