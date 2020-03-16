package cn.com.guilongkeji.dao;

import cn.com.guilongkeji.bean.User;
import cn.com.guilongkeji.util.DataBaseUtil;

/**
 * @author XGL
 * @date 2020/2/27
 */
public abstract class UserDao {
    public String type;
    public DataBaseUtil dataBaseUtil = new DataBaseUtil();
    /**
     * 根据编号查询用户
     */
    public abstract void findUserById();

    public abstract User loginUser(String username,String password);
}
