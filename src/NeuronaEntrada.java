
import java.io.Serializable;

public class NeuronaEntrada implements Serializable
{
    private double entrada;
    private static final long serialVersionUID = 6064116028311586287L;
    
    public double normalizarPrecioMercado(double precioMer)
    {
        return (precioMer-15.0)/(45-15);
    }
    
    public double normalizarValorCirculacion(double valorCir)
    {
        return (valorCir-0)/(100-0);
    }
    
    public double normalizarVolumenMercado(double volMer)
    {
        return (volMer-1)/(50-1);
    }

    public double getEntrada() {
        return entrada;
    }

    public void setEntrada(double entrada) {
        this.entrada = entrada;
    }
}
