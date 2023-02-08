package org.qingqiao.servlet;

import com.alibaba.fastjson.JSON;
import org.qingqiao.bean.User;
import org.qingqiao.service.UserServicelmpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author hj
 * @data 2023/2/7 17:09
 */
@WebServlet("/user")
public class UserServlet extends HttpServlet {
    UserServicelmpl serviceable = UserServicelmpl.GetUserServicelmpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html,charset=utf-8");
        String m = req.getParameter("m");
        if ("query".equals(m)){
            query(req,resp);
        }else if ("queryById".equals(m)){
            queryById(req,resp);
        } else if ("update".equals(m)) {
            update(req,resp);
        } else if ("insert".equals(m)){
            insert(req,resp);
        } else if ("delete".equals(m)){
            delete(req,resp);
        }
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        int i = serviceable.delete(id);
        resp.getWriter().print(i > 0);
    }

    private void insert(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String sex = req.getParameter("sex");
        String birthday = req.getParameter("birthday");
        String address = req.getParameter("address");
        String hobby = req.getParameter("hobby");
        User user = new User(null, username, password, sex, birthday, address, hobby);
        int i = serviceable.insert(user);
        resp.getWriter().print(i > 0);
    }

    private void update(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String sex = req.getParameter("sex");
        String birthday = req.getParameter("birthday");
        String address = req.getParameter("address");
        String hobby = req.getParameter("hobby");
        User user = new User(id, username, password, sex, birthday, address, hobby);
        int i = serviceable.update(user);
        resp.getWriter().print(i > 0);
    }

    private void queryById(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        User user = serviceable.queryById(id);
        String s = JSON.toJSONString(user);
        resp.getWriter().print(s);
    }

    private void query(HttpServletRequest req, HttpServletResponse resp) throws IOException{
        List<User> list = serviceable.query();
        String s = JSON.toJSONString(list);
        resp.getWriter().print(s);
    }
}
