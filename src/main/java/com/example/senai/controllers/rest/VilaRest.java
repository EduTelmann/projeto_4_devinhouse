package com.example.senai.controllers.rest;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.senai.controllers.service.AvengerService;
import com.example.senai.controllers.service.ResidentService;
import com.example.senai.exceptions.AvengersNotFoundExcetion;
import com.example.senai.model.transport.AvengerDTO;
import com.example.senai.model.transport.ListDTO;
import com.example.senai.model.transport.ReportDTO;
import com.example.senai.model.transport.ResidentDTO;

@RestController
@RequestMapping("/api")
public class VilaRest {
	
	
	private AvengerService avengerService;
	private ResidentService residentService;
	
	public VilaRest(AvengerService avengerService, ResidentService residentService) {
		this.avengerService = avengerService;
		this.residentService = residentService;
	}
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@GetMapping("/listall")
	public List<ResidentDTO> listResidents() throws SQLException{
		return residentService.listResidentsAll();
	}
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@GetMapping("/list")
	public List<ListDTO> listResidentsNames() throws SQLException{
		return residentService.listResidentsNames();
	}
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@GetMapping("/filter-by-name")
    public List<ListDTO> listByName(@RequestParam("name") String name) throws SQLException {
        return residentService.filterByName(name);
    }
	
	@PreAuthorize("hasAnyRole('ADMIN')")
    @PostMapping("/add")
    public ResponseEntity<String> addResident(@RequestBody ResidentDTO residentDTO){
        try {
        	residentService.addResident(residentDTO);
            return ResponseEntity.ok("Usuário cadastrado com sucesso");
        }catch (Exception e){
            return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
        }
    }
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@GetMapping("/report")
    public ReportDTO report() throws SQLException{
		return residentService.getReport();
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
