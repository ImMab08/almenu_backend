package conection_db;
import java.sql.*;

public class conect {
    private String url = "jdbc:mysql://localhost:3306/";
    private String user = "root";
    private String password = "";
    private String db = "almenu_db";
    private String driver = "com.mysql.cj.jdbc.Driver";

    private Connection con;
    private Statement st;
    private ResultSet rs;

    public conect () {
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url + db, user, password);
            st = con.createStatement();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void consultar () {
        try {
            String query = "SELECT * FROM producto";
            rs = st.executeQuery(query);
            while(rs.next()) {
                int id_producto = rs.getInt("id_producto");
                String nombre = rs.getString("nombre");
                String descripcion = rs.getString("descripcion");
                double precio = rs.getDouble("precio");
                System.out.println("ID: " + id_producto + "\n Nombre: " + nombre + "\n Descripción: " + descripcion + "\n Precio: " + precio);
            } rs.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void insertar () {
        try {
            String query = "INSERT INTO producto (nombre, descripcion, precio) VALUES ('Salchipapa', 'Papa criolla, salchicha ranchera con queso y tocineta, personal', 12000)";
            st.executeUpdate(query);
            System.out.println("Producto ingresado correctamente.");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void actualizar () {
        try {
            String query = "UPDATE producto SET descripcion = 'Salchipapa familiar' WHERE nombre = 'Salchipapa'";
            st.executeUpdate(query);
            System.out.println("Producto actualizado correctamente.");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void eliminar () {
        try {
            String query = "DELETE FROM producto WHERE nombre = 'Salchipapa'";
            st.executeUpdate(query);
            System.out.println("Producto eliminado correctamente.");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
