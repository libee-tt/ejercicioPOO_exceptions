package org.generation;
import org.generation.classes.Student;
import org.generation.classes.StudentService;
import org.generation.exceptions.CourseNotFoundException;
import org.generation.exceptions.StudentNotFoundException;

public class Main {

	public static void main(String[] args) throws StudentNotFoundException, CourseNotFoundException {
	    StudentService studentService = new StudentService();
        studentService.addStudent( "1030", new Student( "Carlos", "1030", 31 ) );
        studentService.addStudent( "1040", new Student( "Ian", "1020", 28 ) );
        studentService.addStudent( "1050", new Student( "Elise", "1020", 26 ) );
        studentService.addStudent( "1020", new Student( "Santiago", "1020", 33 ) );

        try {
        studentService.enrollStudents( "Math", "1030" );
        studentService.enrollStudents( "Math", "1040" );
        } catch (CourseNotFoundException e){
        	System.out.println(e.getMessage());
        } try { 
        studentService.enrollStudents( "Math", "1030" );
        }catch(StudentNotFoundException e) {
        	System.out.println(e.getMessage());
        }//catch
        
//        Mostrar cursos y estudiantes
        studentService.showAllCourses();
        studentService.showEnrolledStudents("Math");
        
    }//main

} //class Main
