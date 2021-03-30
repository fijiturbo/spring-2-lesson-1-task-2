package uz.pdp.spring2lesson1task2.service;

import org.springframework.stereotype.Service;
import uz.pdp.spring2lesson1task2.entity.Course;
import uz.pdp.spring2lesson1task2.entity.Section;
import uz.pdp.spring2lesson1task2.payload.Response;
import uz.pdp.spring2lesson1task2.payload.SectionDTO;
import uz.pdp.spring2lesson1task2.repository.CourseRepository;
import uz.pdp.spring2lesson1task2.repository.SectionRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SectionServiceImpl implements SectionService {

    final SectionRepository sectionRepository;
    final CourseRepository courseRepository;

    public SectionServiceImpl(SectionRepository sectionRepository, CourseRepository courseRepository) {
        this.sectionRepository = sectionRepository;
        this.courseRepository = courseRepository;
    }

    @Override
    public Response save(SectionDTO sectionDTO) {
        Section section = new Section();
        section.setName(sectionDTO.getName());
        section.setDescription(sectionDTO.getDescription());

        Optional<Course> optionalCourse = courseRepository.findById(sectionDTO.getCourseId());
        if (!optionalCourse.isPresent()) {
            return new Response("Course id not found!", false);
        }
        section.setCourse(optionalCourse.get());

        sectionRepository.save(section);
        return new Response("Section saved!", true);
    }

    @Override
    public List<Section> findAll() {
        return sectionRepository.findAll();
    }

    @Override
    public Section finOneById(Integer id) {
        Optional<Section> optionalSection = sectionRepository.findById(id);
        return optionalSection.orElse(null);
    }

    @Override
    public Response edit(SectionDTO sectionDTO, Integer id) {
        Optional<Section> optionalSection = sectionRepository.findById(id);
        if (optionalSection.isPresent()) {
            optionalSection.get().setName(sectionDTO.getName());
            optionalSection.get().setDescription(sectionDTO.getDescription());

            Optional<Course> optionalCourse = courseRepository.findById(sectionDTO.getCourseId());
            if (!optionalCourse.isPresent()) {
                return new Response("Course id not found!", false);
            }

            sectionRepository.save(optionalSection.get());
            return new Response("Section updated!", true);

        }
        return new Response("Section id not found!", false);
    }

    @Override
    public Response delete(Integer id) {
        Optional<Section> optionalSection = sectionRepository.findById(id);
        if (optionalSection.isPresent()) {
            sectionRepository.deleteById(id);
            return new Response("Section deleted!", true);
        }
        return new Response("Section id not found!", false);
    }
}
