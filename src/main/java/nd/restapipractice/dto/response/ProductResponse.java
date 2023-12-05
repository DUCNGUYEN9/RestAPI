package nd.restapipractice.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ProductResponse {
    private String id;
    private String name;
    private float price;
    private Date created;
    private int quantity;
    private boolean status;
    private int catalog;
    private String catalogName;
}
