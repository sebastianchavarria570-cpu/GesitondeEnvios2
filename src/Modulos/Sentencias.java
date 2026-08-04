package Modulos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
public class Sentencias {
    public void save (Tipos env) throws Exception{
        String sql= "INSERT INTO ENVIOS (Destinatario, peso, envio, paquete, costo) VALUES (?,?,?,?,?)";
        try(
                    Connection conn = Conexion.getConnection()
                    PreparedStatment stmt= conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)
                )
    }
}
