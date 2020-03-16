package cn.com.guilongkeji.dao;

/**
 * @author XGL
 * @date 2020/2/28
 */
public class UserDaoFactory {
    public static UserDao getUserDao(String type){
        UserDao userDao = null;
        if ("mysql".equals(type)){
            userDao = new MysqlUserDao();
        }
        if ("oracle".equals(type)){
            userDao = new OracleUserDao();
        }
        return userDao;
    }
}
