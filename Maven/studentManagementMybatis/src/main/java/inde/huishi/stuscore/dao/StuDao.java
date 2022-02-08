package inde.huishi.stuscore.dao;

import inde.huishi.stuscore.entity.StuScore;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ***
 * @create 2021-12-23 16:14
 */
@Repository
public interface StuDao {
    @Insert("insert into stu_score(no,name,score,className) values(#{no},#{name},#{score},#{className})")
    void add(StuScore stuScore);
    @Delete("delete from stu_score where no=#{no}")
    void delete(String no);
    @Update("update stu_score set name=#{name},score=#{score},className=#{className} where no=#{no}")
    void update(StuScore stuscore);
    @Select("select * from stu_score where name=#{name}")
    StuScore queryByName(String name);
    @Select("select * from stu_score where no=#{no}")
    StuScore queryByNo(String no);
    @Select("selec * from stu_score order by score")
    List<StuScore> querySort();
    @Select("select count(*) as cnt,max(score) as max_s,min(score) as min_s,round(avg(score),4) as avg_s,className from stu_score group by className order by avg(score) desc")
    List<StuScore> statistics();


}
