package com.springrest.springrest.dao;

import com.springrest.springrest.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseDao extends JpaRepository<Course,Long> {//by default this needs all the methods for applying CRUD on database and then make its implementation class, but if you are using jpa repository then all that can be avoided
//JpaRepository<Course,Long>. "the Course is the entity type on which the action is being performed and the "Long" is type of field of primary key

}
