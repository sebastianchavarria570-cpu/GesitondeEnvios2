package Modulos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Sentencias {
    public void save(Tipos envioObj) throws Exception {
        String sql = "INSERT INTO ENVIOS (Destinatario, peso, envio, paquete, costo) VALUES (?, ?, ?, ?, ?) Statement.RETURN_GENERATED_KEYS";
        try (
                Connection conn = Conexion.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)
        ) {
            stmt.setString(1, envioObj.Destinatario);
            stmt.setDouble(2, envioObj.peso);
            stmt.setString(3, envioObj.envio);
            stmt.setString(4, envioObj.paquete);
            stmt.setDouble(5, envioObj.costo);
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                envioObj.id = rs.getInt(1);
            }
        }
    }
    public List <Tipos> mostrarTodos() throws Exception {
        String sql = "SELECT * FROM ENVIOS";
        List <Tipos> listaTipos = new ArrayList<>();
        try (
                Connection conn = Conexion.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)
        ) {

            while (rs.next()) {
                Tipos envio = new Tipos(
                        rs.getInt("id"),
                        rs.getString("Destinatario"),
                        rs.getDouble("peso"),
                        rs.getString("envio"),
                        rs.getString("paquete"),
                        rs.getDouble("costo")
                );
                listaTipos.add(envio);
            }
        }
        return listaTipos;
    }


    public void mostrarEnviosMayoresAPeso(double pesoLimite) throws Exception {
        String sql = "SELECT * FROM ENVIOS WHERE peso >= ?";
        try (
                Connection conn = Conexion.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)
        ) {
            stmt.setDouble(1, pesoLimite);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                System.out.println(rs);
            }
        }
    }


    public void delete(int id) throws Exception {
        String sql = "DELETE FROM ENVIOS WHERE id = ?";
        try (
                Connection conn = Conexion.getConnection();
                PreparedStatement statement = conn.prepareStatement(sql)
        ) {
            statement.setInt(1, id);
            int filasAfectadas = statement.executeUpdate();
            if (filasAfectadas > 0) {
                System.out.println("Envio eliminado correctamente.");
            } else {
                System.out.println("No se encontró ningún envío con ese ID.");
            }
        }
    }


    public void actualizar(Tipos envioObj) throws Exception {
        String sql = "UPDATE ENVIOS SET Destinatario = ?, peso = ?, envio = ?, paquete = ?, costo = ? WHERE id = ?";
        try (
                Connection conn = Conexion.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)
        ) {
            stmt.setString(1, envioObj.Destinatario);
            stmt.setDouble(2, envioObj.peso);
            stmt.setString(3, envioObj.envio);
            stmt.setString(4, envioObj.paquete);
            stmt.setDouble(5, envioObj.costo);
            stmt.setInt(6, envioObj.id);

            int filasAfectadas = stmt.executeUpdate();
            if (filasAfectadas > 0) {
                System.out.println("Envío actualizado correctamente.");
            } else {
                System.out.println("No se encontró el envío para actualizar.");
            }
        }
    }


    public void contarPorTipoEnvio() throws Exception {
        String sql = "SELECT envio, COUNT(*) AS total FROM ENVIOS GROUP BY envio";
        try (
                Connection conn = Conexion.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)
        ) {
            System.out.println("\n--- CONTEO POR TIPO DE ENVÍO ---");
            while (rs.next()) {
                String tipoEnvio = rs.getString("envio");
                int total = rs.getInt("total");
                System.out.println("Tipo de envío: " + tipoEnvio + " | Cantidad: " + total);
            }
        }
    }


    public int contarTotalEnvios() throws Exception {
        String sql = "SELECT COUNT(*) FROM ENVIOS";
        try (
                Connection conn = Conexion.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)
        ) {
            if (rs.next()) {
                return rs.getInt(1);
            }
        }
        return 0;
    }
}
