package pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用来展示的结果对象
 * result view object
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultVO<T> {

    private boolean flag;
    private String msg ;//提示
    private T data;

}
