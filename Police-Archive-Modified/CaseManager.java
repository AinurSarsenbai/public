
import java.sql.*;
import java.util.*;

public class CaseManager {
    private DatabaseHandler db;

    public CaseManager(DatabaseHandler db) {
        this.db = db;
    }

    public void validateCase(Case c) {
        if (c == null) throw new IllegalArgumentException("Case is null");
    }

    public void getFullCaseDescription(int caseId) throws SQLException {
        String sql = """
        SELECT c.name, c.category, u.name as user_name
        FROM cases c
        JOIN users u ON c.created_by = u.id
        WHERE c.id = ?
        """;

        PreparedStatement ps = db.getConnection().prepareStatement(sql);
        ps.setInt(1, caseId);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            System.out.println("Case: " + rs.getString("name"));
            System.out.println("Category: " + rs.getString("category"));
            System.out.println("Created by: " + rs.getString("user_name"));
        }
    }

    public void lambdaExample(List<Case> cases) {
        cases.stream()
             .filter(c -> c.getCategory().equalsIgnoreCase("Robbery"))
             .forEach(c -> System.out.println("Robbery case"));
    }
}
