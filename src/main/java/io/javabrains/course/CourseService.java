package io.javabrains.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getAllCourses(String topicId) {
        List<Course> courses = new ArrayList<>();
        Iterable<Course> iterable = courseRepository.findByTopicId(topicId);
        for (Course t: iterable) {
            courses.add(t);
        }
        return courses;
    }

    public Course getCourse(String id) {
//        return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
        return courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found for " + id));
    }

    public void addCourse(Course course) {
        courseRepository.save(course);
    }

    public void updateCourse(Course course) {
        courseRepository.save(course);
    }

    public void deleteCourse(String id) {
        courseRepository.deleteById(id);
    }
}
