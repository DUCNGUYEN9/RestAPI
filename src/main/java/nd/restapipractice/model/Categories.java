package nd.restapipractice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "categories")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Categories {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "catalog_id")
    private int id;
    @Column(name = "catalog_name",unique = true,columnDefinition = "varchar(100)",nullable = false)
    private String name;
    @Column(columnDefinition = "text")
    private String description;
    @Column(name = "catalog_status",columnDefinition = "bit default true")
    private boolean status;
    private int priority;
    @OneToMany(mappedBy = "catalog")
    private List<Product> listProduct;

    public Categories(int id) {
        this.id = id;
    }
}
