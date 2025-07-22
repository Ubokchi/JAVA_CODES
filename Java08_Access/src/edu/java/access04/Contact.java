package edu.java.access04;

public class Contact {
    // 멤버 변수 (캡슐화)
    private int no;
    private String name;
    private String phone;
    private String email;

    // 기본 생성자
    public Contact() {}

    // 모든 필드를 초기화하는 생성자
    public Contact(int no, String name, String phone, String email) {
        this.no = no;
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    // Getter / Setter 메서드
    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
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

    // 객체 정보를 문자열로 표현
    @Override
    public String toString() {
        return "Contact [no=" + no + ", name=" + name + ", phone=" + phone + ", email=" + email + "]";
    }
}
