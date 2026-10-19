package algotaller1;

public class Motor {
    private int cilindrada;
    private String tipusCombustible;

    public Motor(int cilindrada, String tipusCombustible) {
        this.cilindrada = cilindrada;
        this.tipusCombustible = tipusCombustible;
    }

    public int getCilindrada() { 
        return cilindrada; }
    
    public String getTipusCombustible() { 
        return tipusCombustible; }

    public String toString() {
        return String.format("Motor[cilindrada=%dcc, combustible=%s]", cilindrada, tipusCombustible);
    }
}
