package com.example.senai.exceptions;

public class AvengersNotFoundExcetion extends Exception{
	private static final long serialVersionUID = 1L;

	public AvengersNotFoundExcetion() {
		super("Não foram encontrados Vingadores no Banco");
	}
}
