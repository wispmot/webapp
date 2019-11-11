package web.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import web.entity.User;
import web.mapper.UserMapper;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    public final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDaoImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<User> findAll() {

        String sql = "SELECT * FROM user";
        return jdbcTemplate.query(sql, new UserMapper());

    }

    public void save(User user) {
        String sql = "INSERT INTO user (name, email, age) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, user.getName(), user.getEmail(), user.getAge());
    }

    public void delete(int id) {
        String sql = "DELETE FROM user WHERE id=?";
        jdbcTemplate.update(sql, id);
    }

    public void update(User user) {
        String sql = "UPDATE user SET name=?, email=?, age=? WHERE id =?";
        jdbcTemplate.update(sql, user.getName(),user.getEmail(), user.getAge(), user.getId());
    }

    public User getById(int id) {
        String sql = "SELECT * FROM user WHERE id =?";
        return jdbcTemplate.queryForObject(sql, new UserMapper(), id);
    }
}
