package co.pragra.learningg.springbootlearningg.domain;

import lombok.*;

import java.time.Instant;
import java.util.List;

@Data
@Builder //no need to call constructor
//@AllArgsConstructor //builder needs all arg
@NoArgsConstructor
@ToString
//@Component //generates bean - have to autowire

public class Blog {
    private Long id; //primitive is short first letter
    private String title;
    private String blogText;
    private Category category;
    private List<String> tags;
    private Instant createDate;
    private Instant updateDate;

    public Blog(Long id, String title, String blogText, Category category, List<String> tags, Instant createDate, Instant updateDate)
    {
        this.id = id;
        this.title = title;
        this.blogText = blogText;
        this.category = category;
        this.tags = tags;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }
}
