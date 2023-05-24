package test.spring.component;

import java.util.Date;

import lombok.Data;


public class ParameterDTO {
	private String id;
	private String pw;
	private int age;
	private Date day;
	
	public ParameterDTO() {
		System.out.println("ParameterDTO()");
	}
	
	public ParameterDTO(String id , Date day) {
		System.out.println("ParameterDTO(String , Date)");
		this.id = id;
		this.day = day;
	}
	
	public ParameterDTO(String id , String pw , int age) {
		System.out.println("ParameterDTO(String , String , int)");
		this.id = id;
		this.pw = pw;
		this.age = age;
	}

	public Date getDay() {
		return day;
	}

	public void setDay(Date day) {
		System.out.println("ParameterDTO setDay()");
		this.day = day;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		System.out.println("ParameterDTO setId()");
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		System.out.println("ParameterDTO setPw()");
		this.pw = pw;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		System.out.println("ParameterDTO setAge()");
		this.age = age;
	}
	
	
}
