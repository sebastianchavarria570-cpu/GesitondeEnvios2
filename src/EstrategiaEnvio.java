public interface EstrategiaEnvio {
double calcularCosto (double pesoKg);

default boolean esRecargoUnico(){
    return false;
}
}
