import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        empresaMensajeria empresa = new empresaMensajeria();
        paqueteFragil paqueteFragild = new paqueteFragil("SEBAS",20);
        empresa.addPaquete(paqueteFragild);

        boolean continuar = true;

        do {

                System.out.println("----Menu----");
                System.out.println("1 Ingresar nuevo pedido ");
                System.out.println("2 ver reporte ");
                System.out.println("0 Salir ");
                int opc = sc.nextInt();
                switch (opc) {
                case 1:
                    System.out.println("Selecciona tipo de pedido");
                    System.out.println("1. Estandar");
                    System.out.println("2. Express");
                    System.out.println("3. Internacional");
                    System.out.println("4. Fragil");
                    int opcion = sc.nextInt();
                    switch (opcion) {
                        case 1:
                            System.out.println("ingresa el nombre del destinatario");
                            String nombreDestinatario = sc.next();

                            System.out.println("ingresa el peso del pedido");
                            double peso = sc.nextDouble();
                            if (peso <=0){
                                System.out.println("No se puede");
                            }

                            paqueteEstandard paqueteEstandard = new paqueteEstandard(nombreDestinatario, peso);
                            empresa.addPaquete(paqueteEstandard);
                            break;
                            case 2:
                                System.out.println("ingresa el nombre del destinatario");
                                String nombreDestinatario2 = sc.next();
                                System.out.println("ingresa el peso del pedido");
                                double peso2 = sc.nextDouble();

                                paqueteExpress paqueteExpress = new paqueteExpress(nombreDestinatario2, peso2);
                                empresa.addPaquete(paqueteExpress);
                                break;
                                case 3:
                                    System.out.println("ingresa el nombre del destinatario");
                                    String nombreDestinatario3 = sc.next();
                                    System.out.println("ingresa el peso del pedido");
                                    double peso3 = sc.nextDouble();
                                    paqueteInternacional paqueteInternacional= new paqueteInternacional(nombreDestinatario3, peso3);
                                    empresa.addPaquete(paqueteInternacional);
                                    break;
                                    case 4:
                                        System.out.println("ingresa el nombre del destinatario");
                                        String nombreDestinatario4 = sc.next();
                                        System.out.println("ingresa el peso del pedido");
                                        double peso4 = sc.nextDouble();

                                        paqueteFragil paqueteFragil = new paqueteFragil(nombreDestinatario4, peso4);
                                        empresa.addPaquete(paqueteFragil);
                                        break;

                    }
                    break;
                case 2:
                    System.out.println("-------REPORTE--------");
                    empresa.reporte();
                    break;
                    case 0:
                        continuar = false;
                        break;
            }

        }while (continuar);
    }
}