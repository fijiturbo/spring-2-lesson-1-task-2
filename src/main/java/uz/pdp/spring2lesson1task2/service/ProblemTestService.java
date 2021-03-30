package uz.pdp.spring2lesson1task2.service;

import org.springframework.stereotype.Service;
import uz.pdp.spring2lesson1task2.entity.ProblemTest;
import uz.pdp.spring2lesson1task2.payload.ProblemTestDTO;
import uz.pdp.spring2lesson1task2.payload.Response;

import java.util.List;

@Service
public interface ProblemTestService {

    Response save(ProblemTestDTO problemTestDTO);                      // CREATE

    List<ProblemTest> findAll();                                // READ

    ProblemTest finOneById(Integer id);

    Response edit(ProblemTestDTO problemTestDTO, Integer id);           // UPDATE

    Response delete(Integer id);                  // DELETE

}
