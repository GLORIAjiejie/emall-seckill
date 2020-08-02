/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: User
 * Author:   min
 * Date:     2020-07-30 22:55
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cwu.emallseckill.entity;

import java.util.Date;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author min
 * @create 2020-07-30
 * @since 1.0.0
 */
public class User {
    private int id;
    private String userName;
    private String phone;
    private String password;
    private String salt;
    private String head;
    private int loginCount;
    private Date registerDate;
    private Date lastLoginDate;

    public User() {
    }

    public User(int id, String userName, String phone) {
        this.id = id;
        this.userName = userName;
        this.phone = phone;
    }

    public User(int id, String userName, String phone, String password, String salt, String head, int loginCount, Date registerDate, Date lastLoginDate) {
        this.id = id;
        this.userName = userName;
        this.phone = phone;
        this.password = password;
        this.salt = salt;
        this.head = head;
        this.loginCount = loginCount;
        this.registerDate = registerDate;
        this.lastLoginDate = lastLoginDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public int getLoginCount() {
        return loginCount;
    }

    public void setLoginCount(int loginCount) {
        this.loginCount = loginCount;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public Date getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(Date lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", head='" + head + '\'' +
                ", loginCount=" + loginCount +
                ", registerDate=" + registerDate +
                ", lastLoginDate=" + lastLoginDate +
                '}';
    }
}
