package lib.Dao;

import lib.Model.Course;
import lib.Model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

//import java.sql.Array;

public class CourseDao {

    public ArrayList<Course> getCourseInfo(Connection con, User user) throws SQLException{
        ArrayList<Course> allCourse=new ArrayList<Course>();
        PreparedStatement pstmt = null;
        try{
            String sql=null;
            sql="select course.Cname,course.Cnumber,course.Corder,course.Cproperty,course.Ccredit from course,tc where tc.Tnumber=? and tc.Cnumber=course.Cnumber";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, user.getId());
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                Course course=new Course();
                course.setCourse_name(rs.getString("Cname"));
                course.setCourse_id(rs.getString("Cnumber"));
                course.setOrder(rs.getInt("Corder"));
                course.setAttribute(rs.getString("Cproperty"));
                course.setCredit(rs.getInt("Ccredit"));
                allCourse.add(course);
            }
            rs.close();
            pstmt.close();
            return allCourse;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return allCourse;
    }
    public Course course_add(Connection con,Course course) throws SQLException{
        PreparedStatement pstmt=null;
        Course resultCourse=null;
        try{
            String id="";
            String seq="";
            Random random=new Random();
            while(id.length()<9){
                id=id+random.nextInt(10);
            }
            while(seq.length()<2){
                seq=seq+random.nextInt(10);
            }
            //int seq=Integer.parseInt(temp);
            String tempsql="select count(*) from tc";
            pstmt = con.prepareStatement(tempsql);
           // pstmt.setString(1,course.getTeacher_id());
            ResultSet rs = pstmt.executeQuery();
            int count=0;
            while(rs.next()){
                count=rs.getInt(1);
            }
            count++;




            String sql2course="insert into course(Cnumber,Cname,Corder,Ccredit,Cproperty,Ccapacity," +
                    "                      Ctime,Cweek,Csection,Cschool,Cfoor,Croom,Dnumber,Mnumber)" +
                    "                       values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            pstmt = con.prepareStatement(sql2course);
            pstmt.setString(1, id);
            pstmt.setString(2,course.getCourse_name());
            pstmt.setString(3,seq);
            pstmt.setString(4,null);
            pstmt.setString(5,course.getAttribute());
            pstmt.setString(6,course.getCapacity());
            pstmt.setString(7,course.getWeek_start()+"-"+course.getWeek_end()+"周");
            pstmt.setString(8,course.getWeekday());
            pstmt.setString(9,course.getDuration());
            pstmt.setString(10,null);
            pstmt.setString(11,null);
            pstmt.setString(12,null);
            pstmt.setString(13,null);
            pstmt.setString(14,null);
            int rs2course = pstmt.executeUpdate();

            String sql2tc="insert into tc(tcnumber,Tnumber,Cnumber) values (?,?,?)";
            pstmt = con.prepareStatement(sql2tc);
            pstmt.setString(1,count+"");
            pstmt.setString(2,course.getTeacher_id());
            pstmt.setString(3,id);
            int rs2tc=pstmt.executeUpdate();
            if(rs2course>0&&rs2tc>0){
                resultCourse=new Course();
                resultCourse.setCourse_id(id);
                resultCourse.setCourse_seq(seq);
            }


            rs.close();
            pstmt.close();
            return resultCourse;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return resultCourse;
    }

}
