package pe.redis.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.redis.dto.StudentRequest;
import pe.redis.model.Student;
import pe.redis.repository.StudentCrudRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RedisService {
    private final StudentCrudRepository studentCrudRepository;

    public void save(StudentRequest request){
        studentCrudRepository.saveAll(List.of(toModel(request),toModel(request)));
    }

    public Student toModel(StudentRequest request){
        return Student.builder()
                .id(request.getId())
                .name(request.getName())
                .surName(request.getSurName())
               .build();
    }
}
