package cn.com.guilongkeji.bean;

/**
 * @author XGL
 * @date 2020/2/28
 */
public class User {
    private Integer id;
    private String username;
    private String password;
    private String sno;
    private String sex;
    private String favorite;
    private String work;
    private String note;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getFavorite() {
        return favorite;
    }

    public void setFavorite(String favorite) {
        this.favorite = favorite;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
    public User() {
    }

    public User(Integer id, String username, String password, String sno, String sex, String favorite, String work, String note) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.sno = sno;
        this.sex = sex;
        this.favorite = favorite;
        this.work = work;
        this.note = note;
    }
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(String username, String password, String sno, String sex, String favorite, String work, String note) {
        this.username = username;
        this.password = password;
        this.sno = sno;
        this.sex = sex;
        this.favorite = favorite;
        this.work = work;
        this.note = note;
    }

    @Override
    public String toString() {
        return  "'"+username +
                "','" + password +
                "','" + sno +
                "','" + sex +
                "','" + favorite +
                "','" + work +
                "','" + note+"'";
    }
}
