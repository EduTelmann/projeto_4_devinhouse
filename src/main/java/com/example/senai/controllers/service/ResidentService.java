package com.example.senai.controllers.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.senai.dao.ResidentDAO;
import com.example.senai.model.transport.ListDTO;
import com.example.senai.model.transport.ResidentDTO;

@Service
public class ResidentService {
	
	private ResidentDAO residentDao;
	
	public ResidentService(ResidentDAO residentDao) {
		this.residentDao = residentDao;
	}
	
	public List<ResidentDTO> listResidentsAll() throws SQLException{
		List<ResidentDTO> residents = this.residentDao.getResidents();
		return residents;
	}
	
	public List<ListDTO> listResidentsNames() throws SQLException{
		List<ListDTO> residents = this.residentDao.listResidentNames();
		return residents;
	}
}
