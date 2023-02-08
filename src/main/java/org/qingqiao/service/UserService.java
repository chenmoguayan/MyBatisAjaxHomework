package org.qingqiao.service;

import org.qingqiao.bean.User;

import java.util.List;

/**
 * @author hj
 * @data 2023/2/7 17:08
 */
public interface UserService {
    List<User> query();

    User queryById(int id);

    int update(User user);

    int insert(User user);

    int delete(int id);
}
