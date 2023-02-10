package by.a1qa.models.api;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    private Integer userId;
    private Integer id;
    private String title;
    private String body;
}
