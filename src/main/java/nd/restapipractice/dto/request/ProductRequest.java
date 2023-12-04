package nd.restapipractice.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ProductRequest {
    private String id;
    private String name;
    private float price;
    private Date created;
    private int quantity;
    private boolean status;
    private int catalog;
}
