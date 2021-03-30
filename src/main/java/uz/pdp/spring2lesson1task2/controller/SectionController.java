package uz.pdp.spring2lesson1task2.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.spring2lesson1task2.constants.Linklar;
import uz.pdp.spring2lesson1task2.entity.Section;
import uz.pdp.spring2lesson1task2.payload.Response;
import uz.pdp.spring2lesson1task2.payload.SectionDTO;
import uz.pdp.spring2lesson1task2.service.SectionService;

import java.util.List;

@RestController
@RequestMapping(Linklar.SECTION)
public class SectionController {

    final SectionService sectionService;

    public SectionController(SectionService sectionService) {
        this.sectionService = sectionService;
    }

    @PostMapping
    public HttpEntity<Response> save(@RequestBody SectionDTO sectionDTO) {
        Response response = sectionService.save(sectionDTO);
        return ResponseEntity.status(response.isStatus() ? HttpStatus.OK : HttpStatus.CONFLICT).body(response);
    }

    @GetMapping
    public HttpEntity<?> findAll(){
        List<Section> sectionList = sectionService.findAll();
        return ResponseEntity.ok(sectionList);
    }

    @GetMapping("/{id}")
    public HttpEntity<?> findOneById(@PathVariable Integer id){
        Section section = sectionService.finOneById(id);
        if(section == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Response("Section id not found", false));
        return ResponseEntity.ok(section);
    }

    @PutMapping("/{id}")
    public HttpEntity<Response> edit(@RequestBody SectionDTO sectionDTO, @PathVariable Integer id) {
        Response response = sectionService.edit(sectionDTO, id);
        return ResponseEntity.status(response.isStatus() ? HttpStatus.ACCEPTED : HttpStatus.NOT_FOUND).body(response);
    }

    @DeleteMapping("/{id}")
    public HttpEntity<Response> delete(@PathVariable Integer id) {
        Response response = sectionService.delete(id);
        return ResponseEntity.status(response.isStatus() ? HttpStatus.ACCEPTED : HttpStatus.NOT_FOUND).body(response);
    }
}
