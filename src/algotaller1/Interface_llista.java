package algotaller1;

import java.util.List;

public interface Interface_llista {

    void afegir(Transport t);

    boolean eliminarPerPropietariIMatricula(String propietari, String matricula);

    List<String> matriculesPerNomMedi(String nomMedi);

    List<Transport> transportsPerPropietari(String propietari);

    List<Transport> totsElsTransports();
}
