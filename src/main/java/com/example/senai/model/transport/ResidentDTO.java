package com.example.senai.model.transport;

import java.math.BigDecimal;

public class ResidentDTO {
	
	private Integer id;
	private String name;
    private String lastName;
    private String birthday;
    private BigDecimal income;
    private String cpf;
    private Integer adm_id;
    private String email;
    private String password;
    private Integer is_admin;
    
    public ResidentDTO() {}
    
	public ResidentDTO(Integer id, String name, String lastName, String birthday, BigDecimal income, String cpf, Integer adm_id,
			String email, String password, Integer is_admin) {
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.birthday = birthday;
		this.income = income;
		this.cpf = cpf;
		this.adm_id = adm_id;
		this.email = email;
		this.password = password;
		this.is_admin = is_admin;
	}
	
	public ResidentDTO(Integer id, String name) {
		this.id = id;
		this.name = name;
	}


	public Integer getId() {
		return id;
	}


	public void setName(Integer id) {
		this.id = id;
	}

	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getBirthday() {
		return birthday;
	}


	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}


	public BigDecimal getIncome() {
		return income;
	}


	public void setIncome(BigDecimal income) {
		this.income = income;
	}


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public Integer getAdm_id() {
		return adm_id;
	}


	public void setAdm_id(Integer adm_id) {
		this.adm_id = adm_id;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public Integer getIs_admin() {
		return is_admin;
	}


	public void setIs_admin(Integer is_admin) {
		this.is_admin = is_admin;
	}
    
}
