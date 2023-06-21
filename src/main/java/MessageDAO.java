
import java.sql.*;

public class MessageDAO {

    private static Connection con;
    private static PreparedStatement ps;

    public static void createMessageDB(Message message) {

        ConnectDatabase db_connect = new ConnectDatabase();

        try (Connection conexion = db_connect.getConnection()) {

            try {
                String query = "INSERT INTO mensajes ( mensaje, autor_mensaje) VALUES (?,?)";
                //INSERT INTO `mensajes` (`id_mensaje`, `mensaje`, `autor_mensaje`, `fecha_mensaje`) VALUES (NULL, 'afasfsfasfa', 'aasdfa', current_timestamp());
                ps=conexion.prepareStatement(query);
                ps.setString(1, message.getMessage());
                ps.setString(2, message.getAuthor_message());
                ps.executeUpdate();
                System.out.println("mensaje creado hno");
            } catch (SQLException ex) {

                System.out.println(ex);

            }
        } catch (SQLException e) {
            System.out.println("lelga aca");
            System.out.println(e);
        }/**finally {
         try {
         if (MessageDAO.con != null) {
         MessageDAO.con.close();
         }
         if(ps != null) {
         ps.close();
         }
         } catch (SQLException e) {
         e.printStackTrace();
         }
         }**/


    }

    public static void readMessage() {

        ConnectDatabase db_connect = new ConnectDatabase();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try (Connection conexion = db_connect.getConnection()) {
            String query = "SELECT * FROM mensajes";
            ps = conexion.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {

                System.out.println("ID: " + rs.getInt("id_mensaje"));
                System.out.println("Mensaje: " + rs.getString("mensaje"));
                System.out.println("Autor: " + rs.getString("autor_mensaje"));
                System.out.println("Fecha: " + rs.getString("fecha_mensaje"));
                System.out.println();
            }


        } catch (SQLException e) {
            System.out.println("fallo");
            System.out.println(e);
        }
    }

    public static void deleteMessage(int id_message) {

        ConnectDatabase db_connect = new ConnectDatabase();
        try (Connection conexion = db_connect.getConnection()) {
            PreparedStatement ps = null;

            try {
                String query = "DELETE FROM mensajes WHERE id_mensaje = ?";
                ps = conexion.prepareStatement(query);
                ps.setInt(1, id_message);
                ps.executeUpdate();
                System.out.println("el mensaje se borro perri");

            } catch (SQLException ex) {
                System.out.println(ex);
                System.out.println("no se pudo borrar viejo");
            }


        } catch (SQLException e) {
            System.out.println("fallo");
            System.out.println(e);


        }
    }

    public static void refreshMessageDB(Message message) {

    }
}
