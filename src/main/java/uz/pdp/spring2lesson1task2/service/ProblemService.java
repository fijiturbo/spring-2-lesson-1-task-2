package uz.pdp.spring2lesson1task2.service;

import org.springframework.stereotype.Service;
import uz.pdp.spring2lesson1task2.entity.Problem;
import uz.pdp.spring2lesson1task2.payload.ProblemDTO;
import uz.pdp.spring2lesson1task2.payload.Response;
import java.util.List;

@Service
public interface ProblemService {

    Response save(ProblemDTO problemDTO);                      // CREATE

    List<Problem> findAll();                                // READ

    Problem finOneById(Integer id);

    Response edit(ProblemDTO problemDTO, Integer id);        // UPDATE

    Response delete(Integer id);                             // DELETE

}
