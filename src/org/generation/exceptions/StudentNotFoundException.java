package org.generation.exceptions;

public class StudentNotFoundException extends Exception{

    public StudentNotFoundException(String message) {
        super( "Student with ID ["+ message+"] was not found! " );
    }//StudentNotFoundException
}//class StudentNotFoundException