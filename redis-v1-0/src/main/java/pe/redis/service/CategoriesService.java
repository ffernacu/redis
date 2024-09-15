package pe.redis.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import pe.redis.entity.CategoriesEntity;
import pe.redis.model.Categories;
import pe.redis.repository.CategoriesRepository;

import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class CategoriesService {
    private final CategoriesRepository categoriesRepository;

    @Cacheable(cacheNames = "cache_names")
    public List<Categories> list(){
        List<CategoriesEntity> entities = categoriesRepository.findAll();
        log.info("size: {}", entities.size());
        return entities.stream().map(this::map).toList();
    }

    private Categories map(CategoriesEntity entity){
        return Categories.builder()
                .id(entity.getId())
                .name(entity.getName()).build();
    }

}
