package es.cursogetafe.springdata.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories("es.cursogetafe.springdata.persistencia")
public class Config {

}
