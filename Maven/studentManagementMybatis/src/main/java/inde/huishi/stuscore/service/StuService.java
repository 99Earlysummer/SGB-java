package inde.huishi.stuscore.service;

import inde.huishi.stuscore.dao.StuDao;
import inde.huishi.stuscore.entity.StuScore;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLOutput;
import java.util.*;

/**
 * @author ***
 * @create 2021-12-23 16:15
 */
@Service
public class StuService {
    @Autowired
    private GetStuDao getStuDao;
    private StuDao stuDao;
    private static Scanner s;
    private StuScore stuScore;
    public void menu()throws Exception{
        stuDao=getStuDao.init();
        //菜单
        int choose,choose2;
        List<Integer> chos=new ArrayList<>();
        for (int i = 1; i < 8; i++) {
            chos.add(i);
        }
        Set<Integer> chooseSet=new HashSet<>(chos);
        do {
            System.out.println("=======欢迎进入学生成绩管理系统=======");
            System.out.println("1.新增学生记录");
            System.out.println("2.修改学生记录");
            System.out.println("3.删除学生记录");
            System.out.println("4.按姓名或学号查询学生记录");
            System.out.println("5.按成绩排序");
            System.out.println("6.分班级统计");
            System.out.println("7.退出");
            System.out.println("请选择（1-7）：");

            Scanner scanner = new Scanner(System.in);
            choose = scanner.nextInt();
            while (!chooseSet.contains(choose)){
                System.out.println("请输入(1-7) : ");
                choose = scanner.nextInt();
            }
            System.out.println("----------------------------");
            switch (choose) {
                case 1:
                    myAdd(); //菜单选择1，是新增学生
                    break;
                case 2:
                    myUpdate();  //菜单选择2，是修改学生
                    break;
                case 3:
                    myDel();  //菜单选择3，是删除学生
                    break;
                case 4:
                    //按姓名或学号查询学生记录
                    System.out.println("请输入按姓名或者学号查询");
                    choose2 = scanner.nextInt();
                    myListBy();//到方法中去判断按照什么查询
                    break;
                case 5:
                    mySort();
                    break;
                case 6:
                    myStatistic();
                    break;
                case 7:
                    System.out.println("您确定退出吗?(y/n)");
                    String next = scanner.next();
                    if (next.equals("y")){
                        System.exit(-1);
                        System.out.println("您已退出");
                        getStuDao.destroy();
                        }
                    break;
                default:break;
            }

        }while (true);
    }
}

@Component
class GetStuDao{
    private SqlSession session;
    private InputStream in;
    private StuDao stuDao;

    /**
     * 加载配置文件并初始化开启资源
     * @return
     * @throws IOException
     */
    public StuDao init() throws IOException {
        //读取mybatis的大配置文件
        /*session=new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("SqlMapConfig.xml"));*/
        in=Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        session = factory.openSession(true);
        //获取dao接口
        stuDao = session.getMapper(StuDao.class);
        System.out.println("stuDao初始化成功 = " + stuDao);
        return stuDao;
    }

    /**
     * 关闭资源
     * @throws IOException
     */
    public void destroy() throws IOException{
        session.close();
        in.close();
    }

}