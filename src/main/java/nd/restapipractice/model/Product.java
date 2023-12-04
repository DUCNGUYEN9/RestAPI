package nd.restapipractice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Table(name = "product")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Product {
    @Id
    @Column(name = "product_id",columnDefinition = "char(5)")
    private String id;
    @Column(name = "product_name",columnDefinition = "varchar(100)",nullable = false,unique = true)
    private String name;
    @Column(nullable = false)
    private float price;
    @CreationTimestamp
    private Date created;
    @Column(columnDefinition = "int default 0")
    private int quantity;
    @Column(columnDefinition = "bit default true")
    private boolean status;
    @ManyToOne
    @JoinColumn(name = "catalog_id",referencedColumnName = "catalog_id")
    private Categories catalog;

}
