package Modulos;

import org.w3c.dom.ls.LSOutput;

import java.util.List;

public class Imprimir {

    public void imprimirPedido (Tipos envio){
        System.out.println("ID "+ envio.getId());
        System.out.printf("Destinatario "+ envio.getDestinatario());
        System.out.println(" Peso "+ envio.getPeso());
        System.out.println(" Envio "+ envio.getEnvio());
        System.out.println(" Paquete "+ envio.getPaquete());
        System.out.println(" costo " + envio.getCosto());
    }

    public void imprimirLista (List<Tipos> Lista){
        if (Lista.isEmpty()){
            System.out.println("no se encontro");
        }else{
            for (Tipos tipo : Lista){
                imprimirPedido(tipo);
            }
        }
    }

    public void imprimirConteo (List<Tipos> Lista){
        for (Tipos tipo : Lista){
            System.out.println(" tipo_envio "+tipo.getEnvio() + " total" + tipo.getCosto());
        }
    }



}
