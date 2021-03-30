package uz.pdp.spring2lesson1task2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.pdp.appcodingbat.entity.Course;


@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {

    boolean existsByName(String name);
}
