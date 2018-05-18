
import java.io.IOException;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class Red implements Serializable
{
    //transient Scanner sc = new Scanner(System.in);
    NeuronaEntrada capaEntrada[] = new NeuronaEntrada[9];
    NeuronaOculta capaOculta[] = new NeuronaOculta[4];
    NeuronaSalida capaSalida = new NeuronaSalida();
    private double pesosOcultos[];
    private double bias = 2.73; //El número de DIOS Math.E
    private double factorAprendizaje = 11;
    private double valorReal;
    private boolean primeraVez = false;
    ArchivoObjetos guardar = new ArchivoObjetos();
    private static final long serialVersionUID = 7049116601584915981L;
    
    public Red() throws IOException, Exception
    {
        this.inicializarCapaEntrada();
        this.inicializarCapaOculta();
        this.capaSalida.inicializarPesosSalida();
        //guardar.crearArchivo(this);
    }
    
    public void inicioPredecir(double[][] valores,JLabel exc, JLabel temp)
    {
        this.capaEntrada[0].setEntrada(this.capaEntrada[0].normalizarPrecioMercado(valores[0][0]));
        this.capaEntrada[1].setEntrada(this.capaEntrada[1].normalizarPrecioMercado(valores[0][1]));
        this.capaEntrada[2].setEntrada(this.capaEntrada[2].normalizarPrecioMercado(valores[0][2]));
        this.capaEntrada[1].setEntrada(this.capaEntrada[1].normalizarValorCirculacion(valores[1][0]));
        this.capaEntrada[4].setEntrada(this.capaEntrada[4].normalizarValorCirculacion(valores[1][1]));
        this.capaEntrada[5].setEntrada(this.capaEntrada[5].normalizarValorCirculacion(valores[1][2]));
        this.capaEntrada[2].setEntrada(this.capaEntrada[2].normalizarVolumenMercado(valores[2][0]));
        this.capaEntrada[7].setEntrada(this.capaEntrada[7].normalizarVolumenMercado(valores[2][1]));
        this.capaEntrada[8].setEntrada(this.capaEntrada[8].normalizarVolumenMercado(valores[2][2]));

        this.imprimirCapaEntrada();
        this.procesarInputs();
        this.imprimirCapaOculta();
        this.procesarOutputs();
        this.imprimirCapaSalida();
        DecimalFormat df = new DecimalFormat("#.#");
        temp.setText(df.format(this.capaSalida.getValorOutput()));
        exc.setVisible(true);
        temp.setVisible(true);
    }
    
    public void inicioEntrenar(double[][] valores, double valorPredecir, JTextArea noticias)
    {
        boolean aux = false;
        this.capaEntrada[0].setEntrada(this.capaEntrada[0].normalizarPrecioMercado(valores[0][0]));
        this.capaEntrada[1].setEntrada(this.capaEntrada[1].normalizarPrecioMercado(valores[0][1]));
        this.capaEntrada[2].setEntrada(this.capaEntrada[2].normalizarPrecioMercado(valores[0][2]));
        this.capaEntrada[1].setEntrada(this.capaEntrada[1].normalizarValorCirculacion(valores[1][0]));
        this.capaEntrada[4].setEntrada(this.capaEntrada[4].normalizarValorCirculacion(valores[1][1]));
        this.capaEntrada[5].setEntrada(this.capaEntrada[5].normalizarValorCirculacion(valores[1][2]));
        this.capaEntrada[2].setEntrada(this.capaEntrada[2].normalizarVolumenMercado(valores[2][0]));
        this.capaEntrada[7].setEntrada(this.capaEntrada[7].normalizarVolumenMercado(valores[2][1]));
        this.capaEntrada[8].setEntrada(this.capaEntrada[8].normalizarVolumenMercado(valores[2][2]));
        
        this.setValorReal(this.normalizarPrecioMercadoReal(valorPredecir));
        this.imprimirCapaEntrada();
        do
        {
            System.out.println("\n============================PROCESANDO VALORES============================");
            this.procesarInputs();
            this.imprimirCapaOculta();
            this.procesarOutputs();
            this.imprimirCapaSalida();
            noticias.setText("=====================");
            noticias.setText("Error: "+Double.toString(this.toleranciaError()));
            System.out.println("\n\nEL ERROR DESNORMALIZADO ES: "+this.toleranciaError());
            if((this.toleranciaError() < -200) || (this.toleranciaError() > 200))
            {
                System.out.println("\n============================ENTRENANDO LA RED============================");
                this.entrenarRed();
            }
            else if((this.toleranciaError() >= -200) && (this.toleranciaError() <= 200))
            {
                aux = true;
            }
        }
        while(aux == false);
    }
    
    public void imprimirCapaEntrada()
    {
        System.out.println("\n====CAPA DE ENTRADA====");
        for(int i=0;i<this.capaEntrada.length;i++)
        {
            System.out.print("["+this.capaEntrada[i].getEntrada()+"]");
        }
    }
    
    public void imprimirCapaOculta()
    {
        System.out.println("\n====CAPA OCULTA====");
        for(int i=0;i<this.capaOculta.length;i++)
        {
            System.out.print("["+this.capaOculta[i].getValorProcesado()+"]");
        }
    }
    
    public void imprimirCapaSalida()
    {
        System.out.println("\n====CAPA DE SALIDA====");
        System.out.print("["+this.capaSalida.getValorOutput()+"]");
    }
    
    public void inicializarCapaEntrada(/*NeuronaEntrada[] entradas*/)
    {
        //this.setCapaEntrada(entradas);
        for(int i=0;i<this.capaEntrada.length;i++)
        {
            this.capaEntrada[i] = new NeuronaEntrada();
        }
    }
    
    public void inicializarCapaOculta(/*NeuronaOculta[] ocultas*/)
    {
        //this.setCapaOculta(ocultas);
        System.out.println("EL BIAS EN ESTA RONDA ES: "+this.bias);
        for(int i=0;i<this.capaOculta.length;i++)
        {
            this.capaOculta[i] = new NeuronaOculta();
            this.capaOculta[i].inicializarPesosEntrada();
        }
    }
    
    public void imprimirPesosEntrada()
    {
        for(int i=0;i<this.capaOculta.length;i++)
        {
            for(int j=0;j<this.capaOculta[i].getPesosEntrada().length;j++)
            {
                System.out.println("["+this.capaOculta[i].getPesosEntrada()[j]+"]");
            }
        }
    }
    
    public void procesarInputs()
    {
        for(int i=0;i<this.capaOculta.length;i++)
        {
            this.capaOculta[i].setValorProcesado(this.capaOculta[i].sigmoide(this.capaOculta[i].sumaPonderada(capaEntrada,this.bias)));
        }
    }
    
    public void procesarOutputs()
    {
        this.capaSalida.setValorOutput(this.capaSalida.desnormalizarSalida(this.capaSalida.sigmoide(this.capaSalida.sumaPonderada(capaOculta,this.bias))));
    }
    
    public double normalizarPrecioMercadoReal(double precioMerReal)
    {
        return (precioMerReal-0)/(22300-0);
    }
    
    public double toleranciaError()
    {
        //return (this.capaSalida.getValorOutput() - (((45-15)*this.getValorReal()) + 15))/(((45-15)*this.getValorReal()) + 15);
        //return Math.pow((((45-15)*this.getValorReal()) + 15) - this.capaSalida.getValorOutput(), 2)/2
        return this.capaSalida.getValorOutput() - (((22300-0)*this.getValorReal()) + 0);
    }
    
    public void entrenarRed()
    {
        double error = this.getValorReal() - this.normalizarPrecioMercadoReal(this.capaSalida.getValorOutput());
        System.out.println("EL ERROR ES: "+error);
        this.cambiarPesosSalida(error);
        this.cambiarPesosOcultos(error);
        //double deltaSumaSalida = this.derivadaSigmoide(this.capaSalida.sumaPonderada(this.capaOculta, this.bias)) * error;
        //double pesosSalida[] = this.capaSalida.getPesosSalida();
        //this.calcularPesosDelta(deltaSumaSalida);
        //this.calcularPesosOcultos(deltaSumaSalida, pesosSalida);
    }
    
    public void cambiarPesosSalida(double error)
    {
        double cambio = 0;
        double pesosSalidaCalculados[] = new double[this.capaOculta.length];
        for(int i=0;i<this.capaOculta.length;i++)
        {
            pesosSalidaCalculados[i] = this.capaSalida.getPesosSalida()[i] + (this.factorAprendizaje*error*(this.normalizarPrecioMercadoReal(this.capaSalida.getValorOutput())*(1-this.normalizarPrecioMercadoReal(this.capaSalida.getValorOutput())))*this.capaOculta[i].sumaPonderada(this.capaEntrada, this.bias));
        }
        System.out.println("\n====PESOS DE SALIDA ANTERIORES====");
        this.capaSalida.imprimirPesosSalida();
        this.capaSalida.setPesosSalida(pesosSalidaCalculados);
        System.out.println("\n====PESOS DE SALIDA MODIFICADOS====");
        this.capaSalida.imprimirPesosSalida();
        //double cambio = error*(this.capaSalida.getValorOutput()*(1-this.capaSalida.getValorOutput()));
    }
    
    public void cambiarPesosOcultos(double error)
    {
        double cambioSalidaSumaSalida = error*(this.normalizarPrecioMercadoReal(this.capaSalida.getValorOutput())*(1-this.normalizarPrecioMercadoReal(this.capaSalida.getValorOutput()))); 
        System.out.println("\n=========PESOS ANTERIORES=========");
        this.imprimirPesosEntrada();
        for(int i=0;i<this.capaOculta.length;i++)
        {
            for(int j=0;j<this.capaOculta[i].getPesosEntrada().length;j++)
            {
                double cambioSumaSalidaValorOculta = this.capaOculta[i].getPesosEntrada()[j];
                double cambioSalidaValorOculta = cambioSalidaSumaSalida*cambioSumaSalidaValorOculta;
                double cambioValorOcultaSumaOculta = this.capaOculta[i].getValorProcesado()*(1-this.capaOculta[i].getValorProcesado());
                double cambioSumaOcultaPesoEntrada = this.capaEntrada[j].getEntrada();
                double cambioSalidaPesoEntrada = cambioSalidaValorOculta*cambioValorOcultaSumaOculta*cambioSumaOcultaPesoEntrada;
                this.capaOculta[i].getPesosEntrada()[j] = this.capaOculta[i].getPesosEntrada()[j] + (this.factorAprendizaje*cambioSalidaPesoEntrada);
            }
        }
        System.out.println("\n=========PESOS MODIFICADOS=========");
        this.imprimirPesosEntrada();
    }

    public double getValorReal() {
        return valorReal;
    }

    public void setValorReal(double valorReal) {
        this.valorReal = valorReal;
    }

    public boolean isPrimeraVez() {
        return primeraVez;
    }

    public void setPrimeraVez(boolean primeraVez) {
        this.primeraVez = primeraVez;
    }

    public double getBias() {
        return bias;
    }

    public void setBias(double bias) {
        this.bias = bias;
    }

    public NeuronaEntrada[] getCapaEntrada() {
        return capaEntrada;
    }

    public void setCapaEntrada(NeuronaEntrada[] capaEntrada) {
        this.capaEntrada = capaEntrada;
    }

    public NeuronaOculta[] getCapaOculta() {
        return capaOculta;
    }

    public void setCapaOculta(NeuronaOculta[] capaOculta) {
        this.capaOculta = capaOculta;
    }

    public NeuronaSalida getCapaSalida() {
        return capaSalida;
    }

    public void setCapaSalida(NeuronaSalida capaSalida) {
        this.capaSalida = capaSalida;
    }
}
