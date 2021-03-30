package uz.pdp.spring2lesson1task2.payload;

import lombok.Data;

@Data
public class ProblemTestDTO {

    private String arguments;
    private String result;
    private Integer problemId;
}
