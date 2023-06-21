
import java.sql.*;

public class MessageDAO {



    public static void createMessageDB(Message message) {
        ConnectDatabase db_connect = new ConnectDatabase();
        Connection connection = null;

        try {
            connection = db_connect.getConnection();
            String query = "INSERT INTO mensajes (mensaje, autor_mensaje) VALUES (?,?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, message.getMessage());
            ps.setString(2, message.getAuthor_message());
            ps.executeUpdate();
            System.out.println("Mensaje creado correctamente");
        } catch (SQLException ex) {
            System.out.println("Error al crear el mensaje: " + ex.getMessage());
        } finally {
            db_connect.closeConnection(connection);
        }
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

    public static void refreshMessageDB(Message message, int id_message) {

        ConnectDatabase db_connect = new ConnectDatabase();
        try (Connection conexion = db_connect.getConnection()){
            PreparedStatement ps = null;

            try {
                String query ="UPDATE mensajes SET mensaje = ? WHERE id_mensaje = ?";
                ps = conexion.prepareStatement(query);
                ps.setString(1, message.getMessage());
                ps.setInt(2, id_message);
                ps.executeUpdate();
                System.out.println("el mensaje se edito papa");
            } catch (SQLException e){
                System.out.println(e);
                System.out.println("f el editar");
            }

        }catch (SQLException ex){
            System.out.println(ex);
        }

    }
}
