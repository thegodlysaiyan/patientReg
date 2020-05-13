package com.task.patientreg.dto;

public class Patientdto {
	private long id;
	private String height;
	private String weight;
	private String temperature;
	private String blood_pressure;
	private String bmi;
	private String heart_rate;
	public Patientdto(long id, String height, String weight, String temperature, String blood_pressure, String bmi,
			String heart_rate) {
		super();
		this.id = id;
		this.height = height;
		this.weight = weight;
		this.temperature = temperature;
		this.blood_pressure = blood_pressure;
		this.bmi = bmi;
		this.heart_rate = heart_rate;
	}
	public Patientdto() {
		// TODO Auto-generated constructor stub
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getTemperature() {
		return temperature;
	}
	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}
	public String getBlood_pressure() {
		return blood_pressure;
	}
	public void setBlood_pressure(String blood_pressure) {
		this.blood_pressure = blood_pressure;
	}
	public String getBmi() {
		return bmi;
	}
	public void setBmi(String bmi) {
		this.bmi = bmi;
	}
	public String getHeart_rate() {
		return heart_rate;
	}
	public void setHeart_rate(String heart_rate) {
		this.heart_rate = heart_rate;
	}
	
	

}
