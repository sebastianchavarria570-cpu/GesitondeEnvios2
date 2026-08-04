package Modulos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
public class Sentencias {
    public void save(Tipos envioObj) throws Exception {
        String sql = "INSERT INTO ENVIOS (Destinatario, peso, envio, paquete, costo) VALUES (?, ?, ?, ?, ?)";
        try (
                Connection conn = Conexion.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)
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
}
