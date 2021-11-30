package ru.kpfu.itis.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class News {
    private Long id;
    private String title;
    private String description;
    private String photo;
}
