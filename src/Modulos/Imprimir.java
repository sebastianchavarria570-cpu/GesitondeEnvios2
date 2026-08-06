package Modulos;

import org.w3c.dom.ls.LSOutput;

public class Imprimir {

    public void imprimirEnvio (Tipos envio){
        System.out.println("ID "+ envio.getId());
        System.out.printf("Destinatario "+ envio.getDestinatario());
        System.out.println(" Peso "+ envio.getPeso());
        System.out.println(" Envio "+ envio.getEnvio());
        System.out.println(" Paquete "+ envio.getPaquete());
        System.out.println(" costo " + envio.getCosto());
    }



}
