package algotaller1;

// Tracció mecànica marítima (per exemple: llaüt amb motor)
public class TracMecM extends Maritim {
    private Motor motor;

    public TracMecM(int vm, int np, String matricula, String nomP, String nomMedi, Motor motor) {
        super(vm, np, matricula, nomP, nomMedi);
        this.motor = motor;
    }

    public Motor getMotor() { 
        return motor; }

    public String toString() {
        return super.toString() + ", " + motor.toString();
    }

    public int getvelocitatMaxima() {
        return velocitatMaxima; 
    }

    public int getnumPlaces() {
        return numPlaces;
    }

    public String getPropietari() {
        return nomPropietari;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setvelocitatMaxima(int vm) {
        velocitatMaxima=vm;
    }

    public void setnumPlaces(int np) {
        numPlaces=np;
    }
    
    public String getnomMedi() {
        return nomMedi;
    }
}
