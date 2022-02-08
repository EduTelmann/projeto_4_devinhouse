package com.example.senai.controllers.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.senai.exceptions.AvengersNotFoundExcetion;
import com.example.senai.model.dao.AvengerDAO;
import com.example.senai.model.transport.AvengerDTO;

@Service
public class AvengerService {
	
	private AvengerDAO avengerDAO;
	
	public AvengerService(AvengerDAO avengerDAO) {
		this.avengerDAO = avengerDAO;
	}

	public List<String> listOldAvengers() throws AvengersNotFoundExcetion{
		List<String> listOldAvengers = this.avengerDAO.listOldAvengers();
		
		if (listOldAvengers.isEmpty()) {
			System.out.println("Não foram encontrados Vingadores no Banco!");
			throw new AvengersNotFoundExcetion();
		}
		return listOldAvengers;
	}

	public Boolean create(AvengerDTO avenger) {
		if (avenger == null) {
			throw new IllegalArgumentException("O Avenger está nulo!");
		}
		return this.avengerDAO.create(avenger);
	}

	public List<String> listAvengers() {
		return this.avengerDAO.listAvengers();
	}
}
