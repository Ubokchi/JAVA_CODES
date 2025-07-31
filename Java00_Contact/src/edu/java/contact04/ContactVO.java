package edu.java.contact04;

import java.io.Serializable;

// VO(Value Object) : MVC 디자인 패턴에서 Model 클래스. 데이터 정보
// or DTO(Data Transfer Object)

public class ContactVO implements Serializable {
	// 멤버 변수
	private String name;
	private String phone;
	private String email;
	
	public ContactVO() {
	}

	public ContactVO(String name, String phone, String email) {
		this.name = name;
		this.phone = phone;
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Contact [name=" + name + ", phone=" + phone + ", email=" + email + "]";
	}

}






