
import java.sql.*;

public class UserManager {
    private DatabaseHandler db;

    public UserManager(DatabaseHandler db) {
        this.db = db;
    }

    public User getUserById(int id) throws SQLException {
        String sql = "SELECT * FROM users WHERE id=?";
        PreparedStatement ps = db.getConnection().prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            if ("admin".equalsIgnoreCase(rs.getString("role"))) {
                return new Admin(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("email"),
                    rs.getString("password")
                );
            }
            return new User(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getString("email"),
                rs.getString("password")
            );
        }
        return null;
    }
}
