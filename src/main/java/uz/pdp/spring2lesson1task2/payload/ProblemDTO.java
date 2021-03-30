package uz.pdp.spring2lesson1task2.payload;

import lombok.Data;

@Data
public class ProblemDTO {

    private String title;
    private String body;
    private String problem;
    private String solution;
    private Integer sectionId;

}
