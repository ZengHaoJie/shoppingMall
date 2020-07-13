package zhj.domain;

import java.io.Serializable;

/**
 * 用户实体类
 */
public class User implements Serializable {
    private int uid;
    private String username;
    private String password;
    private int manage;
    private String gender;
    private String phone;
    private String address;

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
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

    public int getManage() {
        return manage;
    }

    public void setManage(int manage) {
        this.manage = manage;
    }
}
