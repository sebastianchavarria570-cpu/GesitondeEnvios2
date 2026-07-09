public class paqueteInternacional extends Paquete {
    public paqueteInternacional(String nombreDestinatario, double peso) {
        super(nombreDestinatario, peso, new EnvioInternacional());
    }
}

