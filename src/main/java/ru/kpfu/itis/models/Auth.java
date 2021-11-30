package ru.kpfu.itis.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Auth {
    private Long id;
    private User user;
    private String cookieValue;
}
