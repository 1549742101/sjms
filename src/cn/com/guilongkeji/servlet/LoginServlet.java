package cn.com.guilongkeji.servlet;

import cn.com.guilongkeji.bean.User;
import cn.com.guilongkeji.dao.UserDao;
import cn.com.guilongkeji.dao.UserDaoFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author XGL
 * @date 2020/2/24
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDao userDao = UserDaoFactory.getUserDao("mysql");
        String username =  req.getParameter("username");
        String password =  req.getParameter("password");
        System.out.println(username+password);
        User userLogin=userDao.loginUser(username,password);
        HttpSession session = req.getSession();
        if (userLogin!=null){
            session.setAttribute("user",userLogin);
            resp.sendRedirect("index.jsp");
        }else {
            session.setAttribute("error","登录失败");
            resp.sendRedirect("jsp/login.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
