package ru.kpfu.itis.models;


import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Builder
public class Deputy {
    private Long id;
    private String first_name;
    private String last_name;
    private Integer age;
    private Double vote;
    private String photo;
    private String title;
    private String fraction;
}
