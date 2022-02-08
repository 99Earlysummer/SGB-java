package pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ***
 * @create 2021-12-20 16:41
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Exam {
    private Integer userId;
    private String userName;
    private Double userPwd;
    private Integer email;
}
