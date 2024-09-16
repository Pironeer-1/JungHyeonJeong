package pironeer.crud.dto.reqeust;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
public class PostWriteRequestDTO {
    private String title;
    private String content;
}
