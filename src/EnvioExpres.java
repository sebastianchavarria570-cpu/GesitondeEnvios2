public class EnvioExpres implements EstrategiaEnvio {
    @Override
    public double calcularCosto (double pesoKg) {
        return (pesoKg*4.5)+3;
    }
}
