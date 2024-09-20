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
        	//INSCRIPCIÓN
        	studentService.enrollStudents( "Math", "1030" ); //normal
        	studentService.enrollStudents( "Math", "1040" ); //normal
        	studentService.enrollStudents( "FakeCourse", "1040" ); //FakeCourse
        } catch (CourseNotFoundException e) {
        	System.out.println(e.getMessage());
        }//catch

        try {
        	//DESINSCRIPCIÓN 
        	studentService.unEnrollStudents("Math", "1030"); //normal
        	studentService.unEnrollStudents("Math", "9999"); //FakeStudent
        	
        } catch (StudentNotFoundException e) {
            System.out.println(e.getMessage());
        }catch (CourseNotFoundException e) {
        	System.out.println(e.getMessage());
        }
        
        try {
        	//DESINSCRIPCIÓN FALSA
        	studentService.unEnrollStudents("Philosophy", "1030"); //FakeCourse
        } catch (CourseNotFoundException e) {
        	System.out.println(e.getMessage());
        }
        
        
        
//        Mostrar cursos y estudiantes
        studentService.showAllCourses();
        studentService.showEnrolledStudents("Math");
        
    }//main

} //class Main

