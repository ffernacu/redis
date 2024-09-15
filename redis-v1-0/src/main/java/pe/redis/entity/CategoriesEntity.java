package pe.redis.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "categories")
@Entity(name = "categories")
public class CategoriesEntity {
    @Id
    @Column(name = "CategoryId")
    private Integer id;
    @Column(name = "CategoryName")
    private String name;
    @Column(name = "Description")
    private String description;
}
