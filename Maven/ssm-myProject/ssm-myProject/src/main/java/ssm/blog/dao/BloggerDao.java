package ssm.blog.dao;

import org.springframework.stereotype.Repository;
import ssm.blog.entity.Blogger;

/**
 * @author 沈功波
 * 博主dao接口
 */
@Repository
public interface BloggerDao {
    /**
     *查询博主信息
     * @return
     * @throws Exception
     */
    Blogger getBloggerData() throws Exception;

}
