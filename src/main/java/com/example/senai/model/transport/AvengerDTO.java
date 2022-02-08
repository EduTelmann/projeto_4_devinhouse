package com.example.senai.model.transport;

public class AvengerDTO {

	private String realName;

	private String name;

	private Integer age;

	private String superPower;

	public AvengerDTO() {
	}

	public AvengerDTO(String realName, String name, Integer age, String superPower) {
		this.realName = realName;
		this.name = name;
		this.age = age;
		this.superPower = superPower;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getSuperPower() {
		return superPower;
	}

	public void setSuperPower(String superPower) {
		this.superPower = superPower;
	}

	@Override
	public String toString() {
		return "AvengerDTO [realName=" + realName + ", name=" + name + ", age=" + age + ", superPower=" + superPower
				+ "]";
	}

}
