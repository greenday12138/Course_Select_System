package lib.Dao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by ttop5 on 16-4-18.
 */
public class Dbutil {

    String url = "jdbc:mysql://localhost:3306/dblab?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";

    private String jdbcName="com.mysql.jdbc.Driver";

    public Connection getCon() throws Exception{
        Class.forName(jdbcName);
        Connection con = DriverManager.getConnection(url,"root","981108wyq");
        return con;
    }

    public void closeCon(Connection con) throws Exception{
        if(con!=null){
            con.close();
        }
    }

    public static void main(String[] args){
        Dbutil dbutil = new Dbutil();

        try {
            dbutil.getCon();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}