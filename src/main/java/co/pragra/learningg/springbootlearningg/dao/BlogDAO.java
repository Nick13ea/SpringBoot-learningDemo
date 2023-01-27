package co.pragra.learningg.springbootlearningg.dao;

import co.pragra.learningg.springbootlearningg.domain.Blog;
import co.pragra.learningg.springbootlearningg.mapper.BlogRowMapper;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BlogDAO //database class is represented with @repository
{
    private JdbcTemplate jdbcTemplate;

    public BlogDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public boolean createBlog(Blog blog) {
        String sql = "INSERT INTO BLOG VALUES(?,?,?,?,?,?)";
        int update = jdbcTemplate.update(sql,
                blog.getId(),
                blog.getTitle(),
                blog.getBlogText(),
                blog.getCategory().getId(),
                blog.getCreateDate(),
                blog.getUpdateDate()
        );

        return update == 1 ? true : false;
    }

    public List<Blog> getAllBlog() {

        String sql = "SELECT * FROM BLOG"; //query
        return this.jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Blog.class));
    }
    public List<Blog>getWithCustomMapper(){
        String sql = "SELECT * FROM BLOG"; //query
        return this.jdbcTemplate.query(sql, new BlogRowMapper());
    }
}
