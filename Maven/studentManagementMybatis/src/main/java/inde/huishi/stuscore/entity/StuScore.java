package inde.huishi.stuscore.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ***
 * @create 2021-12-23 16:15
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StuScore {
    private String no;
    private String name;
    private float score;
    private String className;
}
