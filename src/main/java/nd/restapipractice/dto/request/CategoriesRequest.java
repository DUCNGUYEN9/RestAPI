package nd.restapipractice.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

public class CategoriesRequest {
    private int id;
    private String name;
    private String description;
    private boolean status;
    private int priority;
}
