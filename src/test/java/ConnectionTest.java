import com.web.config.database.H2Config;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

public class ConnectionTest {

    @Test
    void testConnection() throws SQLException {
        H2Config db = new H2Config();
        Assertions.assertTrue(db.dataSource().getConnection() != null);
    }
}
