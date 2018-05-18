
import java.io.Serializable;

public class NeuronaEntrada implements Serializable
{
    private double entrada;
    private static final long serialVersionUID = 6064116028311586287L;

    
    public double normalizarPrecioMercado(double precioMer)
    {
        return (precioMer-0)/(22300-0);
    }
    
    public double normalizarValorCirculacion(double valorCir)
    {
        return (valorCir-0)/(323071829482L-0);
    }
    
    public double normalizarVolumenMercado(double volMer)
    {
        return (volMer-0)/(1422424551L-0);
    }

    public double getEntrada() {
        return entrada;
    }

    public void setEntrada(double entrada) {
        this.entrada = entrada;
    }
}
