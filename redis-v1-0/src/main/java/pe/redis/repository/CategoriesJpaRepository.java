package pe.redis.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import pe.redis.entity.CategoriesEntity;

@Repository
public interface CategoriesJpaRepository extends JpaRepository<CategoriesEntity,Integer> {
}
