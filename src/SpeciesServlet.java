import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebServlet(name = "SpeciesServlet", urlPatterns = "/AnimalSearch")
public class
SpeciesServlet extends HttpServlet {
    private final String PATH = "/WEB-INF/lib/birdnerd2";
    private final String USER = "BIRDNERD";
    private final String PW = "000535440";
    private final String DRIVER = "jdbc:derby:";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection conn = null;
        ResultSet rset = null;
        PreparedStatement pstmt = null;

        try {
            String searchTerm = request.getParameter("animalType");

            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");

            String path = getServletContext().getRealPath(PATH);

            StringBuilder sql = new StringBuilder("SELECT species_name FROM species");
            sql.append(" WHERE animaltype = ?");
            conn = DriverManager.getConnection(DRIVER + path, USER, PW);

            pstmt = conn.prepareStatement(sql.toString());
            pstmt.setString(1, searchTerm);

            rset = pstmt.executeQuery();

            StringBuilder html = new StringBuilder("<html><body>");

            while (rset.next()) {
                String speciesName = rset.getString(1);
                html.append("<li>").append(speciesName).append("</li>");
            }

            html.append("</ul></body></html>");

            response.getWriter().print(html.toString());
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

            if (pstmt != null) {
                try {
                    pstmt.close();
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
