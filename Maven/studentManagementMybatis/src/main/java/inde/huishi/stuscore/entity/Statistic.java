package inde.huishi.stuscore.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ***
 * @create 2021-12-23 16:14
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Statistic {
    private Integer cnt;
    private double max_s;
    private double min_s;
    private double avg_s;
    private String className;
}
