package Modulos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Sentencias {
    public boolean save(Tipos envioObj) throws Exception {
        String sql = "INSERT INTO ENVIOS (Destinatario, peso, envio, paquete, costo) VALUES (?, ?, ?, ?, ?) ";
        try (
                Connection conn = Conexion.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql,  Statement.RETURN_GENERATED_KEYS);
        ) {
            stmt.setString(1, envioObj.Destinatario);
            stmt.setDouble(2, envioObj.peso);
            stmt.setString(3, envioObj.envio);
            stmt.setString(4, envioObj.paquete);
            stmt.setDouble(5, envioObj.costo);
            stmt.executeUpdate();

            int filas = stmt.executeUpdate();

            if (filas > 0) {
                ResultSet rs = stmt.getGeneratedKeys();
                if (rs.next()) {
                    envioObj.id = rs.getInt(1);
                }
                return true;
            }
        }
        return false;
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


    public List<Tipos> mostrarEnviosMayoresAPeso(double pesoLimite) throws Exception {
        String sql = "SELECT * FROM ENVIOS WHERE peso >= ?";
        List<Tipos> lista = new ArrayList<>();
        try (
                Connection conn = Conexion.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)
        ) {
            stmt.setDouble(1, pesoLimite);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Tipos envio = new Tipos(
                        rs.getInt("id"),
                        rs.getString("Destinatario"),
                        rs.getDouble("peso"),
                        rs.getString("envio"),
                        rs.getString("paquete"),
                        rs.getDouble("costo")
                );
                lista.add(envio);
            }
        }
        return lista;
    }


    public boolean delete(int id) throws Exception {
        String sql = "DELETE FROM ENVIOS WHERE id = ?";
        try (
                Connection conn = Conexion.getConnection();
                PreparedStatement statement = conn.prepareStatement(sql)
        ) {
            statement.setInt(1, id);
            int filasAfectadas = statement.executeUpdate();
            return filasAfectadas > 0;
        }
    }


    public boolean actualizar(Tipos envioObj) throws Exception {
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
            return filasAfectadas >0;
        }

    }


    public List<Tipos> contarPorTipoEnvio() throws Exception {
        String sql = "SELECT envio, COUNT(*) AS total FROM ENVIOS GROUP BY envio";
        List<Tipos> resultados = new ArrayList<>();
        try (
                Connection conn = Conexion.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)
        ) {
            while (rs.next()) {
                String tipoEnvio = rs.getString("envio");
                int total = rs.getInt("total");
                Tipos tipo= new Tipos();
                tipo.setEnvio(tipoEnvio);
                tipo.setCosto(total);
                resultados.add(tipo);
            }
        }
        return resultados;
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
