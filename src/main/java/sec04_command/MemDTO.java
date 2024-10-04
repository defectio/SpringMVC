package sec04_command;

public class MemDTO {
	//form 태그의 name 속성에 지정하는 값과 멤버변수명이 같으면 auto-mapping됨.
	private String name;
	private int age;
	
	public MemDTO() {}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}