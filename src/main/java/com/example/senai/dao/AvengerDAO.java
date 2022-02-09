package com.example.senai.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.senai.model.transport.AvengerDTO;

@Repository
public class AvengerDAO {

	public static List<String> oldAvengers = Arrays.asList("Capitão América", "Hulk", 
			"Thor", "Homem de Ferro","Gavião Arqueiro", "Viúva Negra");
	
	public static List<String> avengersNames = new ArrayList<>();
	
	public AvengerDAO() {
		avengersNames.addAll(oldAvengers);
	}

	public List<String> listOldAvengers() {
		return oldAvengers;
	}

	public Boolean create(AvengerDTO avenger) {
		return avengersNames.add(avenger.getName());
	}

	public List<String> listAvengers() {
		return avengersNames;
	}
}
