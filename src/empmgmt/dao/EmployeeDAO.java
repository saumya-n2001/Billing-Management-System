/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empmgmt.dao;

import empmgmt.dbutil.DBConnection;
import empmgmt.pojo.EmployeePojo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import static javax.swing.UIManager.getString;

/**
 *
 * @author saumy
 */
public class EmployeeDAO {
    public static String getNextEmpID()throws SQLException
    {
    Connection conn= DBConnection.getConnection();
    Statement st=conn.createStatement();
    ResultSet rs=st.executeQuery("select max(empid)from employees");
    rs.next();
    String empid=getString(1);
    int empno=Integer.parseInt(empid.substring(1));
    empno=empno+1;
    return "E"+empno ;
    
    }
    public static boolean addEmployee(EmployeePojo emp)throws SQLException
    {
        Connection Conn=DBConnection.getConnection();
        PreparedStatement ps=Conn.prepareStatement("Insert into employees value(????)");
        ps.setString(1,emp.getEmpid());
        ps.setString(2,emp.getEmpname());
        ps.setString(3,emp.getJob());
        ps.setString(4,emp.getSalary());
        int result=ps.executeUpdate();
        return result==1;
    }
    
    public static List<EmployeePojo>getAllEmployee()throws SQLException
    {
    Connection conn= DBConnection.getConnection();
    Statement st=conn.createStatement();
    ResultSet rs=st.executeQuery("select*from employees ordered by empid");
    ArrayList<EmployeePojo>empList=new  ArrayList();
    while(rs.next())
    {
        EmployeePojo emp=new  EmployeePojo();
        emp.setEmpid(rs.getString(1));
        emp.setEmpname(rs.getString(2));
        emp.setJob(rs.getString(3));
        emp.setSalary(rs.getString(4));
        empList.add(emp);
        
    }
    return empList;
    }
    
    public static List<String>gatAllEmployee()throws SQLException{
        Connection conn= DBConnection.getConnection();
    Statement st=conn.createStatement();
    ResultSet rs=st.executeQuery("select empid from employees ordered by empid");
    ArrayList<String>allId=new  ArrayList<String>();
    while(rs.next())
    {
        allId.add(rs.getString(1));
        
    }
    return allId;
    }
    
    public static EmployeePojo findEmpById(String empid)throws SQLException{
         Connection conn= DBConnection.getConnection();
    PreparedStatement ps=conn.prepareStatement("select * from employees ehere empid=?");
    ps.setString(1, empid);
     ResultSet rs=ps.executeQuery();
     rs.next();
     EmployeePojo e=new EmployeePojo();
     e.setEmpid(rs.getString(1));
     e.setEmpname(rs.getString(2));
     e.setJob(rs.getString(3));
     e.setSalary(rs.getString(4));
     return e;
    }
        public static boolean updateEmployee(EmployeePojo e)throws SQLException{
         Connection conn= DBConnection.getConnection();
    PreparedStatement ps=conn.prepareStatement("update employees set empname=?,job=?,salary=?, where empid=?"); 
    ps.setString(1,e.getEmpname());
    ps.setString(2, e.getJob());
    ps.setString(3,e.getSalary());
    ps.setString(4,e.getEmpid());
    int x =ps.executeUpdate();
    if(x==0)
        return false;
    else{
        boolean result=UserDAO.isUserPresent(e.getEmpid());
        if(result==false)
            return true;
    }
     ps=conn.prepareStatement("update employees set empname=?,job=?,salary=?, where empid=?"); 
        ps.setString(1,e.getEmpname());
    ps.setString(2, e.getJob());
    ps.setString(3,e.getSalary());
    int y=ps.executeUpdate();
            return y==1;
        }
   public  static boolean deleteEmployee(String empid)throws SQLException{
       Connection conn= DBConnection.getConnection(); 
       PreparedStatement ps=conn.prepareStatement("delete from employees where empid=?");
       ps.setString(1, empid);
       int x =ps.executeUpdate();
       
   }
}
