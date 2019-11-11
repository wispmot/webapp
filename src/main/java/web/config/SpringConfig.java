package web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import web.dao.UserDao;
import web.dao.UserDaoImpl;
import web.service.UserService;
import web.service.UserServiceImpl;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = {"web.service", "web.dao"})
public class SpringConfig {

    @Bean
    public JdbcTemplate getJdbcTemplate(){
        return new JdbcTemplate(getDataSource());
    }

    @Bean
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/web?useSll=false");
        dataSource.setUsername("root");
        dataSource.setPassword("Sql1234.");
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        return dataSource;
    }

}
