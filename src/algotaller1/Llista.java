package algotaller1;

import java.util.ArrayList;
import java.util.List;

public class Llista implements Interface_llista {
    private static class Node {
        Transport data;
        Node next;
        Node(Transport t) { data = t; next = null; }
    }

    private Node head;

    public Llista() { head = null; }

    @Override
    public void afegir(Transport t) {
        Node node = new Node(t);
        node.next = head;
        head = node;
    }

    @Override
    public boolean eliminarPerPropietariIMatricula(String propietari, String matricula) {
        Node prev = null;
        Node curr = head;
        while (curr != null) {
            if (curr.data.getPropietari().equals(propietari) && curr.data.getMatricula().equals(matricula)) {
                if (prev == null) head = curr.next;
                else prev.next = curr.next;
                return true;
            }
            prev = curr;
            curr = curr.next;
        }
        return false;
    }

   @Override
    public List<String> matriculesPerNomMedi(String nomMedi) {
        List<String> res = new ArrayList<>();
        Node curr = head;
        while (curr != null) {
            if (curr.data.getnomMedi().equalsIgnoreCase(nomMedi)) {
                res.add(curr.data.getMatricula());
            }
            curr = curr.next;
        }
        return res;
    }

    @Override
    public List<Transport> transportsPerPropietari(String propietari) {
        List<Transport> res = new ArrayList<>();
        Node curr = head;
        while (curr != null) {
            if (curr.data.getPropietari().equals(propietari)) {
                res.add(curr.data);
            }
            curr = curr.next;
        }
        return res;
    }

    @Override
    public List<Transport> totsElsTransports() {
        List<Transport> res = new ArrayList<>();
        Node curr = head;
        while (curr != null) {
            res.add(curr.data);
            curr = curr.next;
        }
        return res;
    }
}
