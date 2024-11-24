package pe.redis.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.redis.dto.StudentRequest;
import pe.redis.model.Student;
import pe.redis.service.CategoriesService;
import pe.redis.service.RedisService;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/redis")
public class RedisController {

    private final CategoriesService categoriesService;
    private final RedisService redisService;

    @GetMapping("list")
    ResponseEntity<Object> list(){
        var response1= categoriesService.list();
        return ResponseEntity.ok().body(response1);
    }

    @PostMapping("save")
    ResponseEntity<Object> save(@RequestBody StudentRequest request){
        redisService.save(request);
        return ResponseEntity.ok().body("ok");
    }
}
