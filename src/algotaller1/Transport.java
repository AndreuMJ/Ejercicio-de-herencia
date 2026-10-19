package algotaller1;

abstract class Transport {
int velocitatMaxima;
int numPlaces;
String matricula;
String nomPropietari;
public Transport (int vm, int np, String matricula, String nomP){
velocitatMaxima = vm;
numPlaces = np;
this.matricula = matricula;
nomPropietari = nomP;
}
abstract public String getnomMedi(); 
abstract public int getvelocitatMaxima ();
abstract public int getnumPlaces ();
abstract public String getPropietari ();
abstract public String getMatricula ();
abstract public void setvelocitatMaxima (int vm);
abstract public void setnumPlaces (int np);
}
