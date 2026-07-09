public class paqueteEstandard extends Paquete {
    public paqueteEstandard(String nombreDestinatario, double peso) {
        super(nombreDestinatario, peso, new EnvioEstandar());
    }
}
