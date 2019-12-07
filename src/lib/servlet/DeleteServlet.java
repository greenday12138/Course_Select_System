package lib.servlet;

import lib.Dao.Dbutil;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.Map;

@WebServlet(urlPatterns = "/delete", name = "delete")
public class DeleteServlet extends HttpServlet {
    Dbutil dbutil = new Dbutil();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fromdata = req.getParameter("fromdata");
        System.out.println(fromdata);
        JSONObject jo = JSONObject.fromObject(fromdata);
        Map<String, String> map = jo;

        Connection con=null;
        try{
            con=dbutil.getCon();

           /* System.out.println(jsa.toString());
            resp.setContentType("text/javascript;charset=utf-8");
            resp.getWriter().write(jsa.toString());*/
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            try {
                dbutil.closeCon(con);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
