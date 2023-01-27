package co.pragra.learningg.springbootlearningg.dao;

import co.pragra.learningg.springbootlearningg.domain.Blog;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryDAO {
    private JdbcTemplate jdbcTemplate2;

    public CategoryDAO(JdbcTemplate jdbcTemplate2) {
        this.jdbcTemplate2 = jdbcTemplate2;
    }
    public boolean createCategory(Blog blog) {
        String sql1 = "INSERT INTO CATEGORY VALUES(?,?)";
        int update1 = jdbcTemplate2.update(sql1,
                blog.getCategory().getId(),
                blog.getCategory().getCategoryName()
        );
        return update1 == 1 ? true : false;

    }
}
