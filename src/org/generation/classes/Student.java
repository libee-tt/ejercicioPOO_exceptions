package org.generation.classes;

import java.util.ArrayList;
//import java.util.Date;
import java.util.List;

public class Student {
	private String name;
	private String id;
	private int age;
	
    public final List<Course> courseList = new ArrayList<>();
    
//Constructor
    public Student( String name, String id, int age){
        this.name = name;
        this.id = id;
        this.age = age;
    }//Constructor Student

//    Getters y Setters
	public String getName() {
		return name;
	} //getName

	public void setName(String name) {
		this.name = name;
	}//setName

	public String getId() {
		return id;
	}// getId

	public void setId(String id) {
		this.id = id;
	}//setId

	public int getAge() {
		return age;
	}//getAge

	public void setAge(int age) {
		this.age = age;
	}//setAge

    
    
    
}//class Student
