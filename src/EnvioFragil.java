public class EnvioFragil implements EstrategiaEnvio{
    @Override
    public double calcularCosto(double pesoKg){
        return (pesoKg*5)+7;
    }
    @Override
    public boolean esRecargoUnico(){
        return  true;
    }
}
