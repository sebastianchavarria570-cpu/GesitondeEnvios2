package Modulos;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {

        private static String server = "localhost";
        private static String port = "1433";
        private static String database = "ALUMNOS_POO";
        private static String user = "sa";
        private static String password = "1234";

        public static String getCadenaConexion() {
            return String.format("jdbc:sqlserver://%s:" +
                    "%s;databaseName=%s;" +
                    "user=%s;password=%s;" +
                    "encrypt=true;" +
                    "trustServerCertificate=true;", server, port, database,user, password);
        }

        public static Connection getConnection() throws Exception {
            return DriverManager.getConnection(getCadenaConexion());
        }


    }

