package algotaller1;

// Tracció no mecànica terrestre (per exemple: carro de mules)
public class TracNoMecT extends Terrestre {
    private String tipusTraccio; // ex: "animal", "humana"

    public TracNoMecT(int vm, int np, String matricula, String nomP, String nomMedi, String tipusTraccio) {
        super(vm, np, matricula, nomP, nomMedi);
        this.tipusTraccio = tipusTraccio;
    }

    public String getTipusTraccio() { 
        return tipusTraccio; }

    public String toString() {
        return super.toString() + ", " + tipusTraccio.toString();
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
