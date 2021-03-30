package uz.pdp.spring2lesson1task2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.pdp.spring2lesson1task2.entity.Section;


@Repository
public interface SectionRepository extends JpaRepository<Section, Integer> {

    boolean existsByName(String name);
}
