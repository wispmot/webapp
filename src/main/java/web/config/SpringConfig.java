package web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import web.service.TestBean;

@Configuration
public class SpringConfig {

    @Bean
    public TestBean getTestBean()
    {
        return new TestBean("hello");
    }
}
