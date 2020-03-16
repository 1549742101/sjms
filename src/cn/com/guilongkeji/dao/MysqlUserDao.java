package cn.com.guilongkeji.dao;

import cn.com.guilongkeji.bean.User;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author XGL
 * @date 2020/2/28
 */
public class MysqlUserDao extends UserDao{
    @Override
    public void findUserById() {

    }

    @Override
    public User loginUser(String username, String password) {
        User user = new User();
        String sql = "select * from `user` where username ='"+username+"' and password = '"+password+"';";
        ResultSet rs = dataBaseUtil.executeQuery(sql);
        if (rs!=null){
            try {
                while (rs.next()){
                    user.setId(rs.getInt("id"));
                    user.setSex(rs.getString("sex"));
                    user.setFavorite(rs.getString("favorite"));
                    user.setNote(rs.getString("note"));
                    user.setSno(rs.getString("sno"));
                    user.setWork(rs.getString("work"));
                    user.setUsername(username);
                    user.setPassword(password);
                    return user;
                }
            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }finally {
                if (rs!=null){
                    try {
                        rs.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
                if (dataBaseUtil!=null){
                    dataBaseUtil.close();
                }
            }
        }
        return null;
    }
}
