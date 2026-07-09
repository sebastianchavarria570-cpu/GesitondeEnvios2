abstract  class Paquete {
    private String nombreDestinatario;
    private double peso;
    private EstrategiaEnvio estrategiaEnvio;

    public Paquete(String nombreDestinatario, double peso, EstrategiaEnvio estrategiaEnvio) {
        this.nombreDestinatario = nombreDestinatario;
        this.peso = peso;
        this.estrategiaEnvio = estrategiaEnvio;
    }

    public double calcularCosto () {
        return estrategiaEnvio.calcularCosto(peso);
    }

    public String getNombreDestinatario() {
        return nombreDestinatario;
    }

    public void setNombreDestinatario(String nombreDestinatario) {
        this.nombreDestinatario = nombreDestinatario;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public EstrategiaEnvio getEstrategiaEnvio() {
        return estrategiaEnvio;
    }

    public void setEstrategiaEnvio(EstrategiaEnvio estrategiaEnvio) {
        this.estrategiaEnvio = estrategiaEnvio;
    }
}
