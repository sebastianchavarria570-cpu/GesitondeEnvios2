import java.util.ArrayList;

public class empresaMensajeria {
private ArrayList <Paquete> paquetes;


    public empresaMensajeria() {
        this.paquetes = new ArrayList();
    }



    public void addPaquete(Paquete paquete) {
        this.paquetes.add(paquete);
    }

    public void reporte() {
        double total = 0;
        for (Paquete paquete : this.paquetes) {
            double costo = paquete.calcularCosto();
            total += costo;

            String usuario = paquete.getNombreDestinatario();

            System.out.println("destinatario: " + usuario + " costo: " + costo + " peso: " + paquete.getPeso());
        }
        System.out.println("Total  " + total);


    }



}
