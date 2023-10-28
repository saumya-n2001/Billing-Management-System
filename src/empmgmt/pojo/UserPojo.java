/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empmgmt.pojo;

/**
 *
 * @author saumy
 */
public class UserPojo {

    public UserPojo() {
        this.useid = useid;
        this.empid = empid;
        this.password = password;
        this.usertype = usertype;
        this.username = username;
    }

    @Override
    public String toString() {
        return "UserPojo{" + "useid=" + useid + ", empid=" + empid + ", password=" + password + ", usertype=" + usertype + ", username=" + username + '}';
    }

    public String getUseid() {
        return useid;
    }

    public void setUserid(String useid) {
        this.useid = useid;
    }

    public String getEmpid() {
        return empid;
    }

    public void setEmpid(String empid) {
        this.empid = empid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    private String useid;
    private String empid;
    private String password;
    private String usertype;
    private String username;
}
