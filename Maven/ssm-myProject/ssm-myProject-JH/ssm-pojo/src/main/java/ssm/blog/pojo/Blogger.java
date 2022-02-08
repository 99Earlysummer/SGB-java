package ssm.blog.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author 沈功波
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Blogger implements Serializable {
    private Integer id;
    //用户名
    private String userName;
    //密码
    private String password;
    //博主信息
    private String profile;
    //昵称
    private String nickName;
    //博主签名
    private String sign;
    //图片路径
    private String imageName;
}
