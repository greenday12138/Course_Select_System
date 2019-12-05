package lib.Dao;

import lib.Model.Course;
import lib.Model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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

}
