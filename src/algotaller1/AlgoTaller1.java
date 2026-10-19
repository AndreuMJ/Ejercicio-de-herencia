package algotaller1;

import java.util.List;
import java.util.Scanner;

public class AlgoTaller1 {
    private static final Scanner sc = new Scanner(System.in);
    private static final Llista llista = new Llista();

    public static void main(String[] args) {
        boolean exit = false;
        while (!exit) {
            System.out.println("\n--- Gestio de Transports ---");
            System.out.println("1. Donar d'alta un medi de transport");
            System.out.println("2. Donar de baixa (propietari + matricula)");
            System.out.println("3. Cercar matricules per nomMedi");
            System.out.println("4. Llistar transports d'un propietari");
            System.out.println("5. Llistar tots els transports");
            System.out.println("0. Sortir");
            System.out.print("Tria opcio: ");
            String opt = sc.nextLine().trim();
            switch (opt) {
                case "1": alta(); break;
                case "2": baixa(); break;
                case "3": cercarPerNomMedi(); break;
                case "4": llistarPerPropietari(); break;
                case "5": llistarTots(); break;
                case "0": exit = true; break;
                default: System.out.println("Opció invàlida."); break;
            }
        }
        System.out.println("Fins aviat!");
    }

    private static void alta() {
        System.out.print("Tipus medi (terrestre/maritim/aeri): ");
        String tipus = sc.nextLine().trim().toLowerCase();
        if (!tipus.equals("terrestre")&&!tipus.equals("maritim")&&!tipus.equals("aeri")) {
            System.out.println("Tipus de medi desconegut.");
            return;
        }
        System.out.print("Es mecanic? (s/n): ");
        String mec = sc.nextLine().trim().toLowerCase();
        System.out.print("Nom medi (ex: Opel Corsa, Boeing 747): ");
        String nomMedi = sc.nextLine().trim();
        System.out.print("Matricula: ");
        String matricula = sc.nextLine().trim();
        System.out.print("Propietari: ");
        String propietari = sc.nextLine().trim();
        System.out.print("Num places: ");
        int np = readInt();
        System.out.print("Velocitat maxima: ");
        int vm = readInt();

        Transport t = null;
        if (tipus.equals("terrestre")) {
            if (mec.equals("s")) {
                Motor m = llegirMotor();
                t = new TracMecT(vm, np, matricula, propietari, nomMedi, m);
            } else {
                System.out.print("Tipus traccio (animal/humana/etc): ");
                String tr = sc.nextLine().trim();
                t = new TracNoMecT(vm, np, matricula, propietari, nomMedi, tr);
            }
        } else if (tipus.equals("maritim")) {
            if (mec.equals("s")) {
                Motor m = llegirMotor();
                t = new TracMecM(vm, np, matricula, propietari, nomMedi, m);
            } else {
                System.out.print("Tipus traccio (vela, rems,...): ");
                String tr = sc.nextLine().trim();
                t = new TracNoMecM(vm, np, matricula, propietari, nomMedi, tr);
            }
        } else if (tipus.equals("aeri")) {
            if (mec.equals("s")) {
                Motor m = llegirMotor();
                t = new TracMecA(vm, np, matricula, propietari, nomMedi, m);
            } else {
                System.out.print("Tipus traccio (planador, ala delta,...): ");
                String tr = sc.nextLine().trim();
                t = new TracNoMecA(vm, np, matricula, propietari, nomMedi, tr);
            }
        } else {
            System.out.println("Tipus de medi desconegut.");
            return;
        }

        llista.afegir(t);
        System.out.println("Medi afegit: " + descriureTransportDetall(t));
    }

    private static void baixa() {
        System.out.print("Propietari: ");
        String prop = sc.nextLine().trim();
        System.out.print("Matricula a eliminar: ");
        String mat = sc.nextLine().trim();
        boolean ok = llista.eliminarPerPropietariIMatricula(prop, mat);
        if (ok) System.out.println("Transport eliminat.");
        else System.out.println("No s'ha trobat cap transport amb propietari i matricula indicats.");
    }

    private static void cercarPerNomMedi() {
        System.out.print("Nom medi a cercar: ");
        String nom = sc.nextLine().trim();
        List<String> mats = llista.matriculesPerNomMedi(nom);
        if (mats.isEmpty()) System.out.println("No s'han trobat matricules per a aquest nomMedi.");
        else {
            System.out.println("Matricules trobades:");
            for (String m : mats) System.out.println("  " + m);
        }
    }

    private static void llistarPerPropietari() {
        System.out.print("Propietari: ");
        String prop = sc.nextLine().trim();
        List<Transport> ts = llista.transportsPerPropietari(prop);
        if (ts.isEmpty()) {
            System.out.println("Aquest propietari no te transports.");
            return;
        }
        System.out.println("Transports de " + prop + ":");
        for (Transport t : ts) {
            System.out.println(descriureTransportDetall(t));
        }
    }

    private static void llistarTots() {
        List<Transport> ts = llista.totsElsTransports();
        if (ts.isEmpty()) {
            System.out.println("No hi ha transports registrats.");
            return;
        }
        System.out.println("Tots els transports:");
        for (Transport t : ts) {
            System.out.println(descriureTransportDetall(t));
        }
    }

    private static String descriureTransportDetall(Transport t) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Tipus=%s, nomMedi=%s, matricula=%s, propietari=%s, places=%d, vmax=%d",
                t.getnomMedi(), t.getnomMedi(), t.getMatricula(), t.getPropietari(), t.getnumPlaces(), t.getvelocitatMaxima()));
        // Atributs específics
        if (t instanceof TracMecT) {
            Motor m = ((TracMecT)t).getMotor();
            sb.append(String.format(", combustible=%s, cilindrada=%dcc", m.getTipusCombustible(), m.getCilindrada()));
        } else if (t instanceof TracMecM) {
            Motor m = ((TracMecM)t).getMotor();
            sb.append(String.format(", combustible=%s, cilindrada=%dcc", m.getTipusCombustible(), m.getCilindrada()));
        } else if (t instanceof TracMecA) {
            Motor m = ((TracMecA)t).getMotor();
            sb.append(String.format(", combustible=%s, cilindrada=%dcc", m.getTipusCombustible(), m.getCilindrada()));
        } else if (t instanceof TracNoMecT) {
            sb.append(", traccio=" + ((TracNoMecT)t).getTipusTraccio());
        } else if (t instanceof TracNoMecM) {
            sb.append(", traccio=" + ((TracNoMecM)t).getTipusTraccio());
        } else if (t instanceof TracNoMecA) {
            sb.append(", traccio=" + ((TracNoMecA)t).getTipusTraccio());
        }
        return sb.toString();
    }

    private static Motor llegirMotor() {
        System.out.print("Tipus combustible: ");
        String comb = sc.nextLine().trim();
        System.out.print("Cilindrada (cc): ");
        int cil = readInt();
        return new Motor(cil, comb);
    }

    private static int readInt() {
        while (true) {
            String s = sc.nextLine().trim();
            try {
                return Integer.parseInt(s);
            } catch (NumberFormatException e) {
                System.out.print("Introdueix un numero valid: ");
            }
        }
    }
}
