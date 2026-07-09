public class paqueteExpress extends Paquete {
    public paqueteExpress(String nombreDestinatario, double peso) {
        super(nombreDestinatario, peso, new EnvioExpres());
    }
}
