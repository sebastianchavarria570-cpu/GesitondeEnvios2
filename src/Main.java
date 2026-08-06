import Modulos.Imprimir;
import Modulos.Sentencias;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static  Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        Sentencias sentencias = new Sentencias();
        Imprimir imprimir = new Imprimir();





    }
    public static void menu(){
        System.out.println("---- GESTIÓN DE ENVIOS ----");
        System.out.println("1. Registrar nuevo envio");
        System.out.println("2. Mostrar todos los envios");
        System.out.println("3. Mostrar envíos mayores a un peso");
        System.out.println("4. Actualizar envio");
        System.out.println("5. Eliminar envio por ID");
        System.out.println("6. Ver conteo por tipo de envio");
        System.out.println("7. Ver total de envios");
        System.out.println("0. Salir");
        System.out.print("Selecciona una opcion: ");
        int opc = sc.nextInt();
        sc.nextLine();

    }
}