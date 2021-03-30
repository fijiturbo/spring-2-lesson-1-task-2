package uz.pdp.spring2lesson1task2.service;

import org.springframework.stereotype.Service;
import uz.pdp.spring2lesson1task2.entity.UserPractise;
import uz.pdp.spring2lesson1task2.payload.Response;
import uz.pdp.spring2lesson1task2.payload.UserPractiseDTO;

import java.util.List;

@Service
public interface UserPractiseService {

    Response save(UserPractiseDTO userPractiseDTO);                      // CREATE

    List<UserPractise> findAll();                                // READ

    UserPractise finOneById(Integer id);

    Response edit(UserPractiseDTO userPractiseDTO, Integer id);           // UPDATE

    Response delete(Integer id);                                          // DELETE

}
