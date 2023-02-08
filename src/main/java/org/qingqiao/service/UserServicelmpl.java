package org.qingqiao.service;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.qingqiao.bean.User;
import org.qingqiao.mapper.UserMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author hj
 * @data 2023/2/7 17:09
 */
public class UserServicelmpl implements UserService {
    private  static UserServicelmpl userServicelmpl = new UserServicelmpl();

    private UserServicelmpl() {
    }
    public static UserServicelmpl GetUserServicelmpl(){
        return userServicelmpl;
    }


    @Override
    public List<User> query() {
        List<User> list = new ArrayList<>();
        try {
            SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
            SqlSession session = sessionFactory.openSession();
            UserMapper mapper = session.getMapper(UserMapper.class);
            list = mapper.query();
            for (User u:list){
                System.out.println(u);
            }
            session.commit();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public User queryById(int id) {
        User user;
        try {
            SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
            SqlSession session = sessionFactory.openSession();
            UserMapper mapper = session.getMapper(UserMapper.class);
            user = mapper.queryById(id);
            session.commit();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return user;
    }

    @Override
    public int update(User user) {
        int i;
        try {
            SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
            SqlSession session = sessionFactory.openSession();
            UserMapper mapper = session.getMapper(UserMapper.class);
            i = mapper.update(user);
            session.commit();
            session.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return i;
    }

    @Override
    public int insert(User user) {
        int i;
        try {
            SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
            SqlSession session = sessionFactory.openSession();
            UserMapper mapper = session.getMapper(UserMapper.class);
            i = mapper.insert(user);
            session.commit();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return i;
    }

    @Override
    public int delete(int id) {
        int i;
        try {
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
            SqlSession session = sqlSessionFactory.openSession();
            UserMapper mapper = session.getMapper(UserMapper.class);
            i = mapper.delete(id);
            session.commit();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return i;
    }
}
