package pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ***
 * @create 2021-12-15 20:56
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
private Integer employeeId;
private String employeeName;
private Integer age;
private Double salary;
}
