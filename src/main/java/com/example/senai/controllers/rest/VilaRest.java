package com.example.senai.controllers.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.senai.controllers.service.AvengerService;
import com.example.senai.exceptions.AvengersNotFoundExcetion;
import com.example.senai.model.transport.AvengerDTO;

@RestController
@RequestMapping("/api")
public class VilaRest {
	
	
	private AvengerService avengerService;
	
	public VilaRest(AvengerService avengerService) {
		this.avengerService = avengerService;
	}
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@GetMapping("/list")
	public List<String> listOldAvengers() throws AvengersNotFoundExcetion{
		return avengerService.listOldAvengers();
	}
	
	@GetMapping("/list-all")
	public List<String> listAvengers() throws AvengersNotFoundExcetion{
		return avengerService.listAvengers();
	}
	
	@PostMapping("/create")
	public ResponseEntity<HttpStatus> createNewAvenger(@RequestBody AvengerDTO avenger){
		Boolean response = this.avengerService.create(avenger);
		
		if (response == false) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
}
