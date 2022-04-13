package com.springrest.springrest.services;

//import java.util.ArrayList;
import java.util.List;
//import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springrest.springrest.dao.CourseDao;
import com.springrest.springrest.entities.Course;

@Service
public class CourseServiceImpl implements CourseService {

	//List<Course> list;
	
	@Autowired
	private CourseDao courseDao;
	
	public CourseServiceImpl() {
		
		 //list = new ArrayList<>();
		 //list.add(new Course(145, "Java Core", "learn basic of Java programming Language"));
		 //list.add(new Course(146, "React JS", "learn basic of React JS library"));
		 			 

	}
	
	@Override
	public List<Course> getCourses() {
		
	 //return list;
	 
	return courseDao.findAll();
	
	}

	@Override
	public Course getCourse(long courseId) {
		
		//Course c=null;
		//for(Course course : list)
		//{
			//if (course.getId() == courseId)
			//{ 
			  //c = course;
			 // break;
			//}
		//}
		//return c;
		
		return courseDao.getOne(courseId);  //need to check
		
       }

	@Override
	public Course addCourse(Course course) {
		//list.add(course);
		//return course;
		
		courseDao.save(course);
		return course;
	 }

	@Override
	public Course updateCourse(Course course) {
		/* list.forEach(e -> { 
			if (e.getId() == course.getId()) {
				e.setTitle(course.getTitle());
				e.setDescription(course.getDescription());
				
			}
		});
		return course; */
		
		courseDao.save(course);
		return course;
		
	  }

	@Override
	public void deleteCourse(long parseLong) {
       	   	
	     //list=this.list.stream().filter(e-> e.getId()!=parseLong).collect(Collectors.toList());
		
		 Course entity = courseDao.getOne(parseLong);  //need to check
         courseDao.delete(entity);

	  }
	
	
	
}
