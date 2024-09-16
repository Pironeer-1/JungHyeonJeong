package pironeer.crud.dto.reqeust;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class MemberFormDTO {
    private String loginId;
    private String password;
    private String name;
}
