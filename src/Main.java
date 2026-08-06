import Modulos.Imprimir;
import Modulos.Sentencias;
import Modulos.Tipos;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static  Scanner sc = new Scanner(System.in);
    public static int opc;
    public static void main(String[] args) {

        Sentencias sentencias = new Sentencias();
        Imprimir imprimir = new Imprimir();
        boolean continuar = true;
        try{
            while(continuar){
                menu();
                switch (opc){
                    case 1:
                        System.out.println("ingreasa el nombre del destinatario");
                        String nombre = sc.nextLine();
                        System.out.println("ingresa el peso del envio");
                        double peso = sc.nextDouble();
                        sc.nextLine();
                        System.out.println("ingresa el tipo de envio");
                        String envio = sc.nextLine();
                        System.out.println("ingresa el tipo de paquete");
                        String paquete = sc.nextLine();
                        System.out.printf("ingresa el costo del envio");
                        double costo = sc.nextDouble();

                        Tipos nuevoEnvio = new Tipos(nombre, peso, envio, paquete, costo);
                        boolean save =sentencias.save(nuevoEnvio);
                        if(save == true){
                            System.out.println("Se ha guardado el envio");
                        }else {
                            System.out.println("No se ha guardado el envio");
                        }
                        break;
                        case 2:
                            System.out.println(" todos los envios");
                            var todo = sentencias.mostrarTodos();
                            imprimir.imprimirLista(todo);
                            break;
                    case 3:
                        System.out.println("ingresa el peso");
                        double peso2 = sc.nextDouble();
                        var mayorpeso = sentencias.mostrarEnviosMayoresAPeso(peso2);
                                imprimir.imprimirLista(mayorpeso);
                                break;
                    case 4:
                        System.out.println("ingresa el id a actualizar");
                        int id = sc.nextInt();
                        System.out.println("ingreasa el nombre del destinatario");
                        String nombre2 = sc.nextLine();
                        System.out.println("ingresa el peso del envio");
                        double peso3 = sc.nextDouble();
                        sc.nextLine();
                        System.out.println("ingresa el tipo de envio");
                        String envio2 = sc.nextLine();
                        System.out.println("ingresa el tipo de paquete");
                        String paquete2 = sc.nextLine();
                        System.out.println("ingresa el costo del envio");
                        double costo2 = sc.nextDouble();

                        Tipos envioact = new Tipos(nombre2, peso3, envio2, paquete2, costo2);
                        boolean actualizado = sentencias.actualizar(envioact);
                        if(actualizado == true){
                            System.out.println("Se ha actualizado el envio");
                        }else  {
                            System.out.println("No se ha actualizado el envio");
                        }
                        break;
                        case 5:
                            System.out.println(" ingresa el id a eliminar");
                            int idDelete = sc.nextInt();
                            boolean eliminado = sentencias.delete(idDelete);
                            if(eliminado == true){
                                System.out.println("Se ha eliminado el envio");
                            }else  {
                                System.out.println("No se ha eliminado el envio");
                            }
                            break;
                    case 6:
                        var conteo = sentencias.contarPorTipoEnvio();
                        imprimir.imprimirLista(conteo);
                        break;
                    case 7:
                       int total = sentencias.contarTotalEnvios();
                        System.out.println(" el numero de envios es " + total);
                        break;
                    case 0:
                        System.out.println("saliendo");
                        continuar = false;
                        break;
                        default:
                            System.out.println("seleccion opcion valida");
                            break;
                }


            }

        }catch(Exception e){
            System.out.println("Error");
        }


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
        opc = sc.nextInt();
        sc.nextLine();

    }
}