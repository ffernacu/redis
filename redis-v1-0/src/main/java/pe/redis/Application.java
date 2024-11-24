package pe.redis;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import pe.redis.model.Student;
import pe.redis.repository.StudentCrudRepository;

import java.util.List;

@Slf4j
@Configuration
@SpringBootApplication
public class Application implements CommandLineRunner {

    private final StudentCrudRepository studentCrudRepository;

    public Application(StudentCrudRepository studentCrudRepository) {
        this.studentCrudRepository = studentCrudRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("Start");
        studentCrudRepository.save(Student.builder().name("key").surName("value1").build());
        List<Student> result = studentCrudRepository.findByName("key");
        List<Student> result2 = studentCrudRepository.findByNameAndSurName("key", "value1");
        log.info("result: {}", result);
        log.info("result2: {}", result2);
        log.info("End");
    }
}
