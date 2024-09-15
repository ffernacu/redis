package pe.redis.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.redis.service.CategoriesService;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/redis")
public class RedisController {

    private final CategoriesService categoriesService;

    @GetMapping("list")
    ResponseEntity<Object> list(){
        var response1= categoriesService.list();
        return ResponseEntity.ok().body(response1);
    }
}
