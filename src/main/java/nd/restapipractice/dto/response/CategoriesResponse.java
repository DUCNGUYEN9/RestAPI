package nd.restapipractice.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CategoriesResponse {
    private int id;
    private String name;
    private String description;
    private boolean status;
    private int priority;
}
