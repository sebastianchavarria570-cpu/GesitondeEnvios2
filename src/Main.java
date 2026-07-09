public class Main {
    public static void main(String[] args) {
        EstrategiaEnvio estandar = new EnvioEstandar();
        EstrategiaEnvio expres = new EnvioExpres();
        EstrategiaEnvio internacional = new EnvioInternacional();

        double peso = 5;

        System.out.println("Prueba");
        System.out.println("Peso: "+peso+" kg");
        System.out.println("Envio estandar: $"+estandar.calcularCosto(peso));
        System.out.println("Envio expres: $"+expres.calcularCosto(peso));
        System.out.println("Envio internacional: $"+internacional.calcularCosto(peso));

        System.out.println("Internacional tiene recargo unico? "+internacional.esRecargoUnico());
        System.out.println("Estandar tiene recargo unico? "+estandar.esRecargoUnico());
    }
}