package uz.pdp.spring2lesson1task2.payload;

import lombok.Data;

@Data
public class SectionDTO {
    private String name;
    private String description;
    private Integer courseId;
}
