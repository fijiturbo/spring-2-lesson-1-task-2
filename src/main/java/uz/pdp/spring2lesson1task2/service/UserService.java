package uz.pdp.spring2lesson1task2.service;

import org.springframework.stereotype.Service;
import uz.pdp.spring2lesson1task2.entity.User;
import uz.pdp.spring2lesson1task2.payload.Response;

import java.util.List;

@Service
public interface UserService {

    Response save(User user);                      // CREATE

    List<User> findAll();                                // READ

    User finOneById(Integer id);

    Response edit(User user, Integer id);           // UPDATE

    Response delete(Integer id);                  // DELETE

}
