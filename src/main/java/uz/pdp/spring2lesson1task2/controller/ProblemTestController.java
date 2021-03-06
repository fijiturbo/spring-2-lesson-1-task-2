package uz.pdp.spring2lesson1task2.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.spring2lesson1task2.constants.Linklar;
import uz.pdp.spring2lesson1task2.entity.ProblemTest;
import uz.pdp.spring2lesson1task2.payload.ProblemTestDTO;
import uz.pdp.spring2lesson1task2.payload.Response;
import uz.pdp.spring2lesson1task2.service.ProblemTestService;
import java.util.List;

@RestController
@RequestMapping(Linklar.PROBLEM_TEST)
public class ProblemTestController {

    final ProblemTestService problemTestService;

    public ProblemTestController(ProblemTestService problemTestService) {
        this.problemTestService = problemTestService;
    }

    @PostMapping
    public HttpEntity<Response> save(@RequestBody ProblemTestDTO problemTestDTO) {
        Response response = problemTestService.save(problemTestDTO);
        return ResponseEntity.status(response.isStatus() ? HttpStatus.OK : HttpStatus.CONFLICT).body(response);
    }

    @GetMapping
    public HttpEntity<?> findAll() {
        List<ProblemTest> problemList = problemTestService.findAll();
        return ResponseEntity.ok(problemList);
    }

    @GetMapping("/{id}")
    public HttpEntity<?> findOneById(@PathVariable Integer id) {
        ProblemTest problemTest = problemTestService.finOneById(id);
        if (problemTest == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Response("Problem Test id not found", false));
        }
        return ResponseEntity.ok(problemTest);
    }

    @PutMapping("/{id}")
    public HttpEntity<Response> edit(@RequestBody ProblemTestDTO problemTestDTO, @PathVariable Integer id) {
        Response response = problemTestService.edit(problemTestDTO, id);
        return ResponseEntity.status(response.isStatus() ? HttpStatus.ACCEPTED : HttpStatus.NOT_FOUND).body(response);
    }

    @DeleteMapping("/{id}")
    public HttpEntity<Response> delete(@PathVariable Integer id) {
        Response response = problemTestService.delete(id);
        return ResponseEntity.status(response.isStatus() ? HttpStatus.ACCEPTED : HttpStatus.NOT_FOUND).body(response);
    }
}
