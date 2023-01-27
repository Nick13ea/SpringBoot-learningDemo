package co.pragra.learningg.springbootlearningg;

import co.pragra.learningg.springbootlearningg.dao.BlogDAO;
import co.pragra.learningg.springbootlearningg.dao.CategoryDAO;
import co.pragra.learningg.springbootlearningg.domain.Blog;
import co.pragra.learningg.springbootlearningg.domain.Category;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.Instant;

//when we do component scan, it checks components like @Bean, @AutoWired etc.
@SpringBootApplication
public class SpringbootLearninggApplication {

    //    @Autowired
//    private Blog blog;
    private BlogDAO dao;

    public SpringbootLearninggApplication(BlogDAO dao) {
        this.dao = dao;
    }


    public static void main(String[] args) {
        SpringApplication.run(SpringbootLearninggApplication.class, args);
    }

    @Bean
    CommandLineRunner runner() {
        Category category = new Category();
        category.setId(2);
        category.setCategoryName("Programming");
        return args -> {
            //  System.out.println("blog = " + blog);
//            Blog blog = Blog.builder().id(2L)
//                    .title("Learning SpringBoot")
//                    .blogText("Spring makes it easy ot create stand-alone projects")
//                    .category(category)
//                    .createDate(Instant.now())
//                    .updateDate(Instant.now())
//                    .build();
//
//            dao.createBlog(blog);
//
            dao.getWithCustomMapper().forEach(System.out::println);
        };
    }


}
