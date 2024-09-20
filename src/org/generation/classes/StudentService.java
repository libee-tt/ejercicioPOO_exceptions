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
        if (!courseList.containsKey(courseName)) {
        	throw new CourseNotFoundException(courseName);
        }//if course null
        if (!students.containsKey(studentID)) {
        	throw new StudentNotFoundException(studentID);
        }//if studentID no
        
        if (coursesEnrolledByStudents.containsKey(studentID)) {
        	List<Course> enrolledCourses = coursesEnrolledByStudents.get(studentID);
        	if (enrolledCourses.contains(course)) {
        		System.out.println("The student with ID ["+studentID+"] is already enrolled in "+courseName);
        		return;
        	}//if enrolledCourses
        }//if coursesEnrolledByStudents
//       
        if ( !coursesEnrolledByStudents.containsKey( studentID ) ){
            coursesEnrolledByStudents.put( studentID, new ArrayList<>() );
        }//if 
        coursesEnrolledByStudents.get( studentID ).add( course );
        System.out.println("The Student with ID ["+studentID+"] was enrolled in course "+courseName);
    	}//enrollStudents

    
    public void unEnrollStudents( String courseName, String studentID ) throws CourseNotFoundException, StudentNotFoundException{
    	//¿el curso existe?
    	if (!courseList.containsKey(courseName)) {
    		throw new CourseNotFoundException(courseName);
    	}//if
    	
    	//¿el estudiante existe?
    	if (!coursesEnrolledByStudents.containsKey(studentID)) {
    		throw new StudentNotFoundException(studentID);
    	}//if
    	
    	Course course = courseList.get( courseName );
        //¿esta inscrito?
    	List<Course> enrolledCourses = coursesEnrolledByStudents.get(studentID);
    	if (enrolledCourses !=null && enrolledCourses.contains(course)){
            enrolledCourses.remove(course);
            System.out.println("The student with ID ["+studentID+"] has been unenrolled from "+ courseName);
        } else {
        	System.out.println("The student with ID ["+studentID+"] was not enrolled in "+courseName);
        }//else
    	
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