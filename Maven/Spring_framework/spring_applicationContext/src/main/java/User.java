import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ***
 * @create 2021-12-24 9:49
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer userId;
    private String userName;
    private String userPwd;
    private Student student;

    public User(String userName, Integer userId, String userPwd, Student student) {
        this.userName=userName;
        this.userId=userId;
        this.userPwd=userPwd;
        this.student=student;
        /*student = new Student("沈功波", 21);*/
    }
    public void init(){
        System.out.println("①user init");
    }
}
