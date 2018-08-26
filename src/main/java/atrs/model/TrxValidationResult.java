package atrs.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class TrxValidationResult {
    public String trxId;
    public boolean valid;
    public String reason;
}