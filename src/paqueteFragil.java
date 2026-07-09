public class paqueteFragil extends Paquete {
    public paqueteFragil(String nombreDestinatario, double peso) {
        super(nombreDestinatario, peso, new EnvioFragil());
    }
}
