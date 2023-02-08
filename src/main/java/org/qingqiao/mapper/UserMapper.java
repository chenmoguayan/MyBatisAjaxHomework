package org.qingqiao.mapper;

import org.apache.ibatis.annotations.Param;
import org.qingqiao.bean.User;

import java.util.List;

/**
 * @author hj
 * @data 2023/2/7 16:54
 */
public interface UserMapper {
    List<User> query();
    Integer update(@Param("u") User user);
    Integer insert(@Param("i") User user);
    Integer delete(@Param("delete_id") int id);
    User queryById(int id);
}
