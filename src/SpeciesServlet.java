import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebServlet(name = "SpeciesServlet", urlPatterns = "/SpeciesSearch")
public class
SpeciesServlet extends HttpServlet {
    private final String PATH = "/WEB-INF/lib/birdnerd";
    private final String USER = "jbehrend4";
    private final String PW = "000535440";
    private final String DRIVER = "jdbc:derby:";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection conn = null;
        ResultSet rset = null;
        Statement stmt = null;

        try {
            String searchTerm = request.getParameter("speciesName");

            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");

            String path = getServletContext().getRealPath(PATH);

            StringBuilder sql = new StringBuilder("SELECT * FROM species");

            StringBuilder output = new StringBuilder();

            output.append("<html><body><ul>");

            while (rset.next()) {
                int speciesID = rset.getInt(1);
                String speciesName = rset.getString(2);
                String speciesType = rset.getString(3);
                output.append("<li>").append(speciesID + " : " + speciesName + " : " + speciesType).append("</li>");
            }

            output.append("</ul></body></html>");

            response.getWriter().print(output.toString());
        }
        catch (SQLException | ClassNotFoundException e) {
            response.getWriter().print(e.getMessage());
            e.printStackTrace();
        }
        finally {
            try {
                if (rset != null) {
                    rset.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
