package algotaller1;

abstract class Aeri extends Transport {
    protected String nomMedi;

    public Aeri(int vm, int np, String matricula, String nomP, String nomMedi) {
        super(vm, np, matricula, nomP);
        this.nomMedi = nomMedi;
    }

    public String getNomMedi() { 
        return nomMedi; }

    public String getTipusGeneral() { 
        return "Aeri"; }
}
