
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class ConnectDatabase{
        public static Connection myConnection;

        public ConnectDatabase(){
        }

        public static Connection getConnection(){
          if (myConnection == null) {
         try {
                 myConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mensajes_app", "root", "");
        } catch (SQLException e) {
                 System.out.println(e);
        }
          }
                return myConnection;
        }
        }