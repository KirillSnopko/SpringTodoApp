import com.web.config.database.MySQLConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

public class ConnectionTest {

    @Test
    void testConnection() throws SQLException {
        MySQLConfig db = new MySQLConfig();
        Assertions.assertTrue(db.dataSource().getConnection() != null);
    }
}
