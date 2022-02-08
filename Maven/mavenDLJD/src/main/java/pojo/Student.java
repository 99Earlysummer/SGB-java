package pojo;

import com.oracle.webservices.internal.api.databinding.DatabindingMode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ***
 * @create 2021-12-21 0:27
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private int id;
    private String name;
    private String email;
    private int age;
}
