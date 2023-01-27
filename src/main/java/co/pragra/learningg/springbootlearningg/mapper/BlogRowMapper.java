package co.pragra.learningg.springbootlearningg.mapper;

import co.pragra.learningg.springbootlearningg.domain.Blog;
import co.pragra.learningg.springbootlearningg.domain.Category;
import org.springframework.data.relational.core.sql.In;
import org.springframework.jdbc.core.RowMapper;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Optional;

public class BlogRowMapper implements RowMapper<Blog> {
    @Override
    public Blog mapRow(ResultSet rs, int rowNum) throws SQLException {
        Blog blog = new Blog();
        blog.setId(rs.getLong("ID"));
        blog.setTitle(rs.getString("TITLE"));
        blog.setBlogText(rs.getString("BLOG_TEXT"));
        Category category = new Category();
        category.setId(rs.getInt("CATEGORY_ID"));
        blog.setCategory(category);
//        Optional<Date> createDate = Optional.ofNullable(rs.getDate("CREATE_DATE"));
//        Optional<Date> updateDate = Optional.ofNullable(rs.getDate("UPDATE_DATE"));
//        blog.setCreateDate(createDate.orElse(new Date(1)).toInstant());
//        blog.setUpdateDate(updateDate.orElse(new Date(1)).toInstant());
        blog.setCreateDate(Instant.now());
        blog.setUpdateDate(Instant.now());
        blog.setTags(new ArrayList<>());
        return blog;
    }
}
