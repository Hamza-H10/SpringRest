package com.springrest.springrest.services;

import com.springrest.springrest.dao.CourseDao;
import com.springrest.springrest.entities.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImple implements CourseService{

    @Autowired
    private CourseDao courseDao;
//    List<Course> list;
//    public CourseServiceImple(){
//        list = new ArrayList<>();
//        list.add(new Course(145,"New Java Course","This course contains basics of Java"));
//        list.add(new Course(4343, "Spring Boot Course", "Creating RestAPI using Spring Boot"));
//    }

    @Override
    public List<Course> getCourses() {
//        return list;
        return courseDao.findAll();

    }

    @Override
    public Course getCourse(long courseId) {
//        Course c = null;// by default
//        for(Course course: list){// traversing the "list" with for each loop(means one by one each member of list will come in) (course identifier)
//            if (course.getId() == courseId){
//                c = course;// updating the value on incidence
//                break;// stopping the loop when we have a match of input courseId and
//            }
//        }
//        return c;
        return courseDao.getOne(courseId);
    }

    @Override
    public Course addCourse(Course course) {
//        list.add(course);
        courseDao.save(course);
        return course;
    }

    @Override
    public Course updateCourse(Course course) {
//        list.forEach(e -> {//traversing the list with foreach method using lambda function then - e will have one course and course.getId() equate one by one if its equal then we will add Title and description of that course and same course will be returned
//            if (e.getId()== course.getId()){
//                e.setTitle(course.getTitle());
//                e.setDescription(course.getDescription());
//            }
//        });
//        return course;
        courseDao.save(course);
        return course;
    }

    @Override
    public void deleteCourse(long parseLong) {//we are taking a stream from list and filtering if id != to its id and in that case it gets collected as a list and after that that course will be removed of which id user has given
//        list=this.list.stream().filter(e->e.getId()!=parseLong).collect(Collectors.toList());
        Course entity = courseDao.getOne(parseLong);
        courseDao.delete(entity);

    }
}
