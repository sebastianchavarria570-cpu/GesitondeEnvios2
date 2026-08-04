package Modulos;

public class Tipos {
    public int id;
    public String Destinatario;
    public double peso;
    public String envio;
    public String paquete;
    public double costo;

    public Tipos(String destinatario, double peso, String envio, String paquete, double costo) {
        Destinatario = destinatario;
        this.peso = peso;
        this.envio = envio;
        this.paquete = paquete;
        this.costo = costo;
    }

    public Tipos(int id, String destinatario, double peso, String envio, String paquete, double costo) {
        this.id = id;
        Destinatario = destinatario;
        this.peso = peso;
        this.envio = envio;
        this.paquete = paquete;
        this.costo = costo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDestinatario() {
        return Destinatario;
    }

    public void setDestinatario(String destinatario) {
        Destinatario = destinatario;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getEnvio() {
        return envio;
    }

    public void setEnvio(String envio) {
        this.envio = envio;
    }

    public String getPaquete() {
        return paquete;
    }

    public void setPaquete(String paquete) {
        this.paquete = paquete;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }
}
