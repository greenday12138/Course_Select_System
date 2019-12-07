package lib.Dao;

import lib.Model.Course;
import lib.Model.Student;
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
            //System.out.println(user.getId());
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
            int credit=random.nextInt(5);
            int capacity=50+random.nextInt(50);
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
                    "Ctime,Cweek,Csection,Cschool,Cfoor,Croom,Dnumber,Mnumber)" +
                    "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            pstmt = con.prepareStatement(sql2course);
            pstmt.setString(1, id);
            pstmt.setString(2,course.getCourse_name());
            pstmt.setInt(3, Integer.parseInt(seq));
            pstmt.setInt(4,credit);
            pstmt.setString(5,course.getAttribute());
            pstmt.setInt(6,capacity);
            pstmt.setString(7,course.getWeek_start()+"-"+course.getWeek_end()+"周");
            pstmt.setString(8,course.getWeekday());
            pstmt.setInt(9,Integer.parseInt(course.getDuration()));
            pstmt.setString(10,"江安");
            pstmt.setString(11,"一教A");
            pstmt.setString(12,"304");
            pstmt.setString(13,"2016000001");
            pstmt.setString(14,"3040000001");
            int rs2course = pstmt.executeUpdate();

            String sql2tc="insert into tc(tcnumber,Tnumber,Cnumber,Corder) values (?,?,?,?)";
            pstmt = con.prepareStatement(sql2tc);
            pstmt.setString(1,count+"");
            pstmt.setString(2,course.getTeacher_id());
            pstmt.setString(3,id);
            pstmt.setInt(4,Integer.parseInt(seq));
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
    public boolean t_Course_Delete(Connection con,Course course) throws SQLException{
        boolean judge=false;
        PreparedStatement pstmt=null;
        try{
            System.out.println(course.getCourse_id()+"\n"+course.getCourse_seq());
            String sql2="delete from tc where Cnumber=? and Corder=?";
            pstmt = con.prepareStatement(sql2);
            pstmt.setString(1, course.getCourse_id());
            pstmt.setString(2,course.getCourse_seq());
            int rs2 = pstmt.executeUpdate();
            String sql1="delete from course where Cnumber=? and Corder=?";
            pstmt = con.prepareStatement(sql1);
            pstmt.setString(1, course.getCourse_id());
            pstmt.setString(2,course.getCourse_seq());
            int rs1 = pstmt.executeUpdate();

            if(rs1>0&&rs2>0){
                judge=true;
            }
            pstmt.close();
            return judge;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return judge;

    }
    public boolean t_Course_Edit(Connection con,Course course) throws SQLException{
        boolean judge=false;
        PreparedStatement pstmt=null;
        try {
            String sql2course="update course set Cname=?,Cproperty=?," +
                    "                      Ctime=?,Cweek=?,Csection=?" +
                    "                        where Cnumber=? and Corder=?";
            pstmt = con.prepareStatement(sql2course);
            pstmt.setString(1, course.getCourse_name());
            pstmt.setString(2,course.getAttribute());
            pstmt.setString(3,course.getWeek_start()+"-"+course.getWeek_end()+"周");
            pstmt.setString(4,course.getWeekday());
            pstmt.setString(5,course.getDuration());
            pstmt.setString(6,course.getCourse_id());
            pstmt.setString(7,course.getCourse_seq());
            int rs2course = pstmt.executeUpdate();

            /*String sql2tc="update tc set ,Tnumber,Cnumber,Corder) values (?,?,?,?)";
            pstmt = con.prepareStatement(sql2tc);
            pstmt.setString(1,count+"");
            pstmt.setString(2,course.getTeacher_id());
            pstmt.setString(3,id);
            pstmt.setString(4,seq);
            int rs2tc=pstmt.executeUpdate();*/
            if(rs2course>0){
                judge=true;
            }
            pstmt.close();

            return judge;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return judge;
    }
    public ArrayList<Student> t_Course_Detail(Connection con, Course course) throws SQLException{
        PreparedStatement pstmt=null;
        ArrayList<Student> allStudent=new ArrayList<Student>();
        try{
            String sql="select student.Snumber,student.Sname,department.Dname from student,sc,department where sc.Snumber=student.Snumber and sc.Cnumber=? and student.Dnumber=department.Dnumber";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1,course.getCourse_id());
            //pstmt.setString(2,course.getCourse_seq());
            ResultSet rs=pstmt.executeQuery();
            while(rs.next()){
                Student student=new Student();
                student.setId(rs.getString("Snumber"));
                student.setName(rs.getString("Sname"));
                student.setDepartment(rs.getString("Dname"));
                allStudent.add(student);
            }


            rs.close();
            pstmt.close();
            return allStudent;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return allStudent;

    }

}
