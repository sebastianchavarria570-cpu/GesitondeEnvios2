import java.util.ArrayList;

public class empresaMensajeria {
private ArrayList <Paquete> paquetes;
    public empresaMensajeria() {
        this.paquetes = new ArrayList();
    }

    public void addPaquete(Paquete paquete) {
        this.paquetes.add(paquete);
    }



}
