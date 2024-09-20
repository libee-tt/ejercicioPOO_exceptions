package org.generation.classes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.generation.exceptions.CourseNotFoundException;
import org.generation.exceptions.StudentNotFoundException;

public class StudentService{
    private HashMap<String, Course> courseList = new HashMap<>();
    private HashMap<String, Student> students = new HashMap<>();
    private HashMap<String, List<Course>> coursesEnrolledByStudents = new HashMap<>();


    public StudentService(){
        courseList.put( "Math", new Course( "Math", 10, "Aurelio Baldor" ) );
        courseList.put( "Physics", new Course( "Physics", 10, "Albert Einstein" ) );
        courseList.put( "Art", new Course( "Art", 10, "Pablo Picasso" ) );
        courseList.put( "History", new Course( "History", 10, "Sima Qian" ) );
        courseList.put( "Biology", new Course( "Biology", 10, "Charles Darwin" ) );
    } //StudentService

//   Método para agregar estudiantes
    public void addStudent(String id, Student student) {
    	students.put(id, student);
    }//addStudent
    
    
    public void enrollStudents( String courseName, String studentID ) throws StudentNotFoundException, CourseNotFoundException{
        Course course = courseList.get( courseName );
        
//        Excepciones enrollStudents
        if (course==null) {
        	throw new CourseNotFoundException();
        }//if course null
        if (!students.containsKey(studentID)) {
        	throw new StudentNotFoundException();
        }//if studentID no
        
//       
        if ( !coursesEnrolledByStudents.containsKey( studentID ) ){
            coursesEnrolledByStudents.put( studentID, new ArrayList<>() );
        }//if 
        coursesEnrolledByStudents.get( studentID ).add( course );
    	}//enrollStudents

    
    public void unEnrollStudents( String courseName, String studentID ){
        Course course = courseList.get( courseName );
        if ( coursesEnrolledByStudents.containsKey( studentID ) ){
            coursesEnrolledByStudents.get( studentID ).remove( course );
        }//if
    } //unEnrollStudents

  
//    	ver cursos
    public void showAllCourses(){
    	System.out.println("__________________________________________________________________");
    	System.out.println("===== AVAILABLE COURSES ====");
    	for (String courseName:courseList.keySet()) {
    		Course course = courseList.get(courseName);
    		System.out.println("• Course: "+course.getName()+" | Credits: "+course.getCredits()
    						   + " | Professor: "+course.getProfessorName());
    	}//for
    }//showAllCourses
    
    
//    Mostrar estudiantes
    public void showEnrolledStudents(String courseId){
    	Course course = courseList.get(courseId);
    	
    	if (course==null) {
    		System.out.println("Course not found!");
    		return;
    	}//if course null
    	System.out.println("__________________________________________________________________");
    	System.out.println("==== STUDENTS ENROLLED IN COURSE: "+courseId+" ====");
    	
    	///VEr estudiantes inscritos
    	for (String studentId: coursesEnrolledByStudents.keySet()) {
    		List<Course> enrolledCourses = coursesEnrolledByStudents.get(studentId);
    		
    		if (enrolledCourses.contains(course)) {
    			Student student = students.get(studentId);
    			System.out.println("• Student ID: "+student.getId()+" | Name: "+student.getName());
    		}//if
    	}//for
    }//showEnrolledStudents

    
}//class StudentService