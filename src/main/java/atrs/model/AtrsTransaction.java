package atrs.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class AtrsTransaction {
    private String id;
    private String market;
    private Integer dttRate;
}
