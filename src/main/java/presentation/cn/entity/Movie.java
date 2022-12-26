package presentation.cn.entity;



public class Movie {
    private String UserId;
    private String UserName;
    private String UserPwd;
    private String UserPhone;
    private String Sex;
    public String getUserId() {
        return UserId;
    }
    public void setUserId(String userId) {
        UserId = userId;
    }
    public String getUserName() {
        return UserName;
    }
    public void setUserName(String userName) {
        UserName = userName;
    }
    public String getUserPwd() {
        return UserPwd;
    }
    public void setUserPwd(String userPwd) {
        UserPwd = userPwd;
    }
    public String getUserPhone() {
        return UserPhone;
    }
    public void setUserPhone(String userPhone) {
        UserPhone = userPhone;
    }
    public String getSex() {
        return Sex;
    }
    public void setSex(String sex) {
        Sex = sex;
    }


    public Movie(String userId, String userName, String userPwd,
                 String userPhone, String sex) {
        super();
        UserId = userId;
        UserName = userName;
        UserPwd = userPwd;
        UserPhone = userPhone;
        Sex = sex;
    }

}

