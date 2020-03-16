package cn.com.guilongkeji.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @author XGL
 * @date 2020/2/24
 */
public class DataBaseUtil {
    private Connection conn = null;
    private Statement st = null;
    private ResultSet rs = null;
    private String MysqlName=null;
    private String MysqlPassword=null;
    private String MysqlDatabase=null;
    public void mySet(){
        this.setMysqlDatabase("study");
        this.setMysqlName("root");
        this.setMysqlPassword("xgl020331");
    }
    /**
     * 构造方法，调用此方法需要设置MySQL用户名（setMysqlName），密码（setMysqlPassword）以及数据库名（setMysqlDatabase）。
     */
    public DataBaseUtil() {
        super();
        mySet();
    }
    /**
     * 设置MySQL用户名
     * @param mysqlName
     */
    public void setMysqlName(String mysqlName) {
        MysqlName = mysqlName;
        if (MysqlName!=null&&MysqlPassword!=null&&MysqlDatabase!=null) {
            if (!this.getConnectionLow()) {
                this.getConnectionHigh();
            }
        }
    }
    /**
     * 设置MySQL密码
     * @param mysqlPassword
     */
    public void setMysqlPassword(String mysqlPassword) {
        MysqlPassword = mysqlPassword;
        if (MysqlName!=null&&MysqlPassword!=null&&MysqlDatabase!=null) {
            if (!this.getConnectionLow()) {
                this.getConnectionHigh();
            }
        }
    }
    /**
     * 设置MySQL数据库名
     * @param mysqlDatabase
     */
    public void setMysqlDatabase(String mysqlDatabase) {
        MysqlDatabase = mysqlDatabase;
        if (MysqlName!=null&&MysqlPassword!=null&&MysqlDatabase!=null) {
            if (!this.getConnectionLow()) {
                this.getConnectionHigh();
            }
        }
    }
    /**
     * 构造方法
     * @param mysqlName Mysql数据库名
     * @param mysqlPassword Mysql密码
     * @param mysqlDatabase Mysql数据库名
     */
    public DataBaseUtil(String mysqlName, String mysqlPassword, String mysqlDatabase) {
        MysqlName = mysqlName;
        MysqlPassword = mysqlPassword;
        MysqlDatabase = mysqlDatabase;
        if (MysqlName!=null&&MysqlPassword!=null&&MysqlDatabase!=null) {
            if (!getConnectionLow()) {
                getConnectionHigh();
            }
        }else {
            System.out.println("数据库连接失败");
        }

    }
    /**
     * Mysql8.0以下链接方法
     */
    private boolean getConnectionLow() {
        final String driverName = "com.mysql.jdbc.Driver";
        final String URL =
                "jdbc:mysql://cdb-1lmq810s.cd.tencentcdb.com:10055/"+MysqlDatabase+"?characterEncoding=UTF-8";
        final String login = MysqlName;
        final String PASSWORD = MysqlPassword;
        try {
            Class.forName(driverName);
            conn = DriverManager.getConnection(URL, login, PASSWORD);
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            return false;
        }
    }
    /**
     * Mysql8.0以上链接方法
     */
    private boolean getConnectionHigh() {
        final String DRIVERNAME = "com.mysql.cj.jdbc.Driver";
        final String URL =
                "jdbc:mysql://cdb-1lmq810s.cd.tencentcdb.com:10055/"+MysqlDatabase+"?useUnicode=true&characterEncoding=UTF-8"
                        + "&useSSL=false&serverTimezone=Asia/Shanghai&zeroDateTimeBehavior=CONVERT_TO_NULL";
        final String login = MysqlName;
        final String PASSWORD = MysqlPassword;
        try {
            Class.forName(DRIVERNAME);
            conn=DriverManager.getConnection(URL, login, PASSWORD);
            return true;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            return false;
        }

    }
    /**
     * 数据库查询
     * @param sql
     * @return
     */
    public ResultSet executeQuery(String sql) {
        try {
            if (conn == null) {
                if (!(getConnectionHigh()||getConnectionLow())){
                    return null;
                }
            }
            if (st == null) {
                st = conn.createStatement();
            }
            rs = st.executeQuery(sql);
        }catch (Exception e) {
            // TODO Auto-generated catch block
            return null;
        }
        return rs;
    }
    /**
     * 数据库增加/删除/修改
     * @param sql
     * @return >0 执行成功
     */
    public int executeUpdate(String sql) {
        int ret;
        try {
            if (conn == null) {
                System.out.println("调用构造方法错误");
            }
            if (st == null) {
                st = conn.createStatement();
            }
            ret = st.executeUpdate(sql);
        }catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            ret = -1;
        }
        return ret;
    }

    /**
     * 数据库关闭
     */
    public void close() {

        try {
            if (rs!=null) {
                rs.close();
            }
            if (st!=null) {
                st.close();
            }
            if (conn!=null) {
                conn.close();
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            System.out.println("关闭数据库发生错误:"+e.getMessage());
        }
    }
}
