package com.example.senai.model.transport;

public class ListDTO {
	
	private Integer id;
	private String name;
    private String lastame;
    
    public ListDTO(){}
    
	public ListDTO(Integer id, String name, String lastame) {
		this.id = id;
		this.name = name;
		this.lastame = lastame;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastame() {
		return lastame;
	}

	public void setLastame(String lastame) {
		this.lastame = lastame;
	}
}
