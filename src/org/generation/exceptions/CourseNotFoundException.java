package org.generation.exceptions;

public class CourseNotFoundException extends Exception  {
	 public CourseNotFoundException(String message) {
	        super("The course ["+message+"] was not found");
	 } //CourseNotFoundException
}//class CourseNotFoundException 
