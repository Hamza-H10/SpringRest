package com.springrest.springrest.controller;

import com.springrest.springrest.entities.Course;
import com.springrest.springrest.services.CourseService;
import com.springrest.springrest.services.CourseServiceImple;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//TUTORIAL PART-1: https://youtu.be/sdDDuQuX2cg
//PART-2: https://youtu.be/V2p5rVIBT5M?list=PL0zysOflRCekYnhLjQGwpdJYzr38QXdhl
// for a robust api you must also pass the http status
@RestController
@RequestMapping("/api")
public class MyController {

    @Autowired//automatic wiring//this is to make the object of implementation class (courseServiceImpl) and inject in courseService(Identifier) and hence achieve loose coupling. This is we are able to do with the help of spring framework
    private CourseService courseService;

    @GetMapping("/")//this API is for testing only
    public String home(){
        return "Welcome to courses application";
    }
    //get the courses

    @GetMapping("/courses")//API 1
    public List<Course> getCourses() {
       return this.courseService.getCourses();// Now we are able to call the courseService because we have the object of CourseService implementation class
    }

    //API 2
//    @RequestMapping(path="/courses",method = RequestMethod.GET) //same as GetMapping but a little verbose and lengthy
    @GetMapping("/courses/{courseId}")//curly braces allow us to pass value of courseId dynamically
    public Course getCourse(@PathVariable String courseId){//pathVariable annotation is used to receive value in curly braces and store it in courseId(identifier) of String type
        return this.courseService.getCourse(Long.parseLong(courseId));//we are converting into long//now this will go to the (service class).getCourse method will take as argument
    }

    //API 3
//    @PostMapping(path="/courses", consumes = "application/json")//exactly similar like below
    @PostMapping("/courses")//we can also use above line as well as this line for syntax both are same
    public Course addCourse(@RequestBody Course course){
        return this.courseService.addCourse(course);
    }

    //API 4
    //update course using PUT request
    @PutMapping("/courses/{courseId}")
    public Course updateCourse(@RequestBody Course course){
        return this.courseService.updateCourse(course);
    }

    //delete the course
    @DeleteMapping("/courses/{courseId}")
    public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseId)//in Response entity we will send HttpStatus as a generic type
    {try {
        this.courseService.deleteCourse(Long.parseLong(courseId));
        return new ResponseEntity<>(HttpStatus.OK);
    }catch (Exception e){
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
    }

}
