package uz.pdp.spring2lesson1task2.service;

import org.springframework.stereotype.Service;
import uz.pdp.spring2lesson1task2.entity.Section;
import uz.pdp.spring2lesson1task2.payload.Response;
import uz.pdp.spring2lesson1task2.payload.SectionDTO;

import java.util.List;

@Service
public interface SectionService {

    Response save(SectionDTO sectionDTO);                      // CREATE

    List<Section> findAll();                                // READ

    Section finOneById(Integer id);

    Response edit(SectionDTO sectionDTO, Integer id);           // UPDATE

    Response delete(Integer id);                  // DELETE

}
