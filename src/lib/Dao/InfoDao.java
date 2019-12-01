package lib.Dao;

import lib.Model.Student;
import lib.Model.Teacher;
import lib.Model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InfoDao {
    public Student getStudentInfo (Connection con, User user) throws SQLException {
        Student resultStudent = null;
        PreparedStatement pstmt = null;
        try {
            String sql=null;
            sql = "select * from student,department,major where student.Snumber=? and student.Dnumber=department.Dnumber and student.Mnumber=major.Mnumber";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, user.getId());
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()){

                    resultStudent = new Student();
                    resultStudent.setName(rs.getString("Sname"));
                    resultStudent.setId(rs.getString("Snumber"));
                    resultStudent.setRole(0);
                    resultStudent.setSex(rs.getString("Ssex"));
                    resultStudent.setDepartment(rs.getString("Dname"));
                    resultStudent.setMajor(rs.getString("Mname"));
                    resultStudent.setHighschool(rs.getString("Shighschool"));
                    resultStudent.setOrigo(rs.getString("Sorigo"));
                    resultStudent.setTellphone(rs.getString("Sphone"));
                    resultStudent.setEmail(rs.getString("Semail"));
                    resultStudent.setHobby(rs.getString("Shobby"));

                    // restltUser.setEmail(rs.getString());
            }

            return resultStudent;
        }catch (Exception e){
            e.printStackTrace();
        }
        return resultStudent;
    }
    public Teacher getTeacherInfo (Connection con, User user) throws SQLException {
        Teacher resultTeacher = null;
        PreparedStatement pstmt = null;
        try {
            String sql=null;
            sql = "select * from teacher,department where teacher.Tnumber=? and T.Dnumber=department.Dnumber";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, user.getId());
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()){

                resultTeacher = new Teacher();
                resultTeacher.setName(rs.getString("Sname"));
                resultTeacher.setId(rs.getString("Snumber"));
                resultTeacher.setRole(1);
               /* resultTeacher.setSex(rs.getString("Ssex"));
                resultTeacher.setDepartment(rs.getString("Dname"));
                resultTeacher.setMajor(rs.getString("Mname"));
                resultTeacher.setHighschool(rs.getString("Shighschool"));
                resultTeacher.setOrigo(rs.getString("Sorigo"));
                resultTeacher.setTellphone(rs.getString("Sphone"));
                resultTeacher.setEmail(rs.getString("Semail"));
                resultTeacher.setHobby(rs.getString("Shobby"));*/

                // restltUser.setEmail(rs.getString());
            }

            return resultTeacher;
        }catch (Exception e){
            e.printStackTrace();
        }
        return resultTeacher;
    }
}
