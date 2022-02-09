package com.example.senai.controllers.service;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.senai.dao.ResidentDAO;
import com.example.senai.model.transport.ListDTO;
import com.example.senai.model.transport.ReportDTO;
import com.example.senai.model.transport.ResidentDTO;
import com.fasterxml.jackson.databind.ser.std.StdArraySerializers.BooleanArraySerializer;

@Service
public class ResidentService {
	
	private ResidentDAO residentDao;
	private BigDecimal orcamentoDaVila;
	
	
	public ResidentService(ResidentDAO residentDao, @Value("${vila.orcamento:0}") BigDecimal orcamentoDaVila) {
		this.residentDao = residentDao;
		this.orcamentoDaVila = orcamentoDaVila;
	}
	
	public List<ResidentDTO> listResidentsAll() throws SQLException{
		List<ResidentDTO> residents = this.residentDao.getResidents();
		return residents;
	}
	
	public List<ListDTO> listResidentsNames() throws SQLException{
		List<ListDTO> residents = this.residentDao.listResidentNames();
		return residents;
	}
	
	public List<ListDTO> filterByName(String name) throws SQLException{
		List<ListDTO> residents = this.residentDao.listResidentsByName(name);
		return residents;
	}
	
	public ResponseEntity<String> addResident(ResidentDTO residentDTO){
		Boolean result = this.residentDao.addResident(residentDTO);
		if(result) {
			return new ResponseEntity<String>("OK", HttpStatus.OK);
		}else {
			return new ResponseEntity<String>("Erro", HttpStatus.BAD_REQUEST);
		}
    }
	
	public ReportDTO getReport()throws SQLException{
		ReportDTO report = this.residentDao.getReport(this.orcamentoDaVila);
		return report;
	}
}
