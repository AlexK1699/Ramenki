import java.util.Arrays;

public class Ramenki {

    public static void modifier(int nb, Appartement a) {
        nb = 999;
        a.setPieces(999);
    }

    public static void main(String[] args) {

        // PROG1-1
        String nom    = "Ramenki";
        String ville  = "Moscou";
        int    annee  = 2016;
        final int POPULATION = 95000;
        double superficie = 1130.0;
        int    habitants  = 95000;
        double densite = habitants / superficie;
        String typePopulation = (habitants > 80000) ? "district peuplé" : "district peu peuplé";
        System.out.println("Le district " + nom + " est dans " + ville + ", fondé en " + annee + ", population: " + POPULATION);
        System.out.println("Densité : " + densite + " habitants par hectare");
        System.out.println("Population : " + typePopulation);

        // PROG1-2 — if
        if (densite < 100) {
            System.out.println("District peu dense");
        } else if (densite >= 100 && densite <= 300) {
            System.out.println("District moyen");
        } else {
            System.out.println("District très dense");
        }

        // PROG1-2 — switch
        int ligne = 5;
        switch (ligne) {
            case 1  : System.out.println("Sokolnitcheskaya"); break;
            case 5  : System.out.println("Filyovskaya");      break;
            case 10 : System.out.println("Lyublinskaya");     break;
            default : System.out.println("Autre ligne");
        }

        // PROG1-3 — Массивы + for
        String[] rues      = {"Michurinski", "Lobachevski", "Vernadski", "Udaltcova"};
        int[]    immeubles = {12, 8, 15, 6};
        int    maxImmeubles = 0;
        String rueMax       = "";
        for (int i = 0 ; i < rues.length ; i++) {
            System.out.println("Rue " + (i+1) + " : " + rues[i] + " - " + immeubles[i] + " immeubles");
            if (immeubles[i] > maxImmeubles) {
                maxImmeubles = immeubles[i];
                rueMax       = rues[i];
            }
        }
        System.out.println("Rue la plus construite : " + rueMax + " (" + maxImmeubles + " immeubles)");

        // PROG1-2 — while
        int i     = 0;
        int somme = 0;
        while (i < immeubles.length) {
            somme = somme + immeubles[i];
            i++;
        }
        System.out.println("Total immeubles : " + somme);

        // PROG1-2 — do...while
        int j = 0;
        do {
            if ("Vernadski".equals(rues[j])) {
                System.out.println(rues[j] + "... trouvé !");
            } else {
                System.out.println(rues[j] + "... pas encore");
            }
            j++;
        } while (!("Vernadski".equals(rues[j-1])) && j < rues.length);

        // PROG1-2 — break, метки
        int[][] apparts = {
                {10, 15,  8},
                {12, 18,  6},
                {8,  20,  4},
                {5,  10,  3}
        };
        externe:
        for (int a = 0 ; a < apparts.length ; a++) {
            for (int b = 0 ; b < apparts[a].length ; b++) {
                if (apparts[a][b] > 14 && b == 1) {
                    System.out.println("Trouvé : " + rues[a] + " - " + apparts[a][b] + " deux-pièces");
                    break externe;
                }
            }
        }

        // PROG1-3 — Строки
        System.out.println("Longueur de nom : " + nom.length());
        System.out.println("Premier caractère : " + nom.charAt(0));
        System.out.println("Dernier caractère : " + nom.charAt(nom.length()-1));
        for (int k = 0 ; k < nom.length() ; k++) {
            System.out.print(nom.charAt(k) + "-");
        }
        System.out.println();
        String rue = "Michurinski";
        System.out.println("Début : " + rue.substring(0, 4));
        System.out.println("Fin : "   + rue.substring(4));
        for (int k = 0 ; k < rues.length ; k++) {
            if ("Vernadski".equals(rues[k])) {
                System.out.println(rues[k] + " trouvée dans le district !");
                break;
            }
        }
        String saisie = "vernadski";
        System.out.println("Vernadski".equalsIgnoreCase(saisie));

        // PROG1-3 — Двумерный массив
        for (int a = 0 ; a < apparts.length ; a++) {
            System.out.print(rues[a] + " : ");
            for (int b = 0 ; b < apparts[a].length ; b++) {
                System.out.print(apparts[a][b]);
                switch (b) {
                    case 0 : System.out.print(" studios");      break;
                    case 1 : System.out.print(" deux-pièces");  break;
                    case 2 : System.out.print(" trois-pièces"); break;
                }
                if (b < apparts[a].length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println();
        }

        // PROG1-3 — Зубчатый массив
        int[][] sorties = new int[5][];
        sorties[0] = new int[3];
        sorties[1] = new int[2];
        sorties[2] = new int[1];
        sorties[3] = new int[2];
        sorties[4] = new int[1];
        String[] stations = {"Ramenki", "Michurinski", "Michurinski pr", "Ozernaya", "Govorovo"};
        for (int k = 0 ; k < sorties.length ; k++) {
            System.out.println(stations[k] + " : " + sorties[k].length + " sorties");
        }

        // PROG1-4 — Objets et classes
        Appartement apt = new Appartement("Vernadskogo", 3);
        System.out.println(apt);
        Appartement apt2 = new Appartement("Michurinski");
        System.out.println(apt2);
        System.out.println("Nombre d'appartements : " + Appartement.getNombreAppartements());
        StringBuffer sb = new StringBuffer();
        sb.append("Vernadskogo");
        sb.insert(0, "Rue ");
        sb.append(", Moscou");
        System.out.println(sb.toString());
        apt.setAdresse("Lobachevski");
        apt.setPieces(5);
        System.out.println(apt);

        // PROG1-4 — Передача параметров
        int nb = 10;
        Appartement a = new Appartement("Udaltcova", 2);
        modifier(nb, a);
        System.out.println("nb = " + nb);
        System.out.println("pieces = " + a.getPieces());

        // PROG1-5 — Héritage
        AppartementLuxe al = new AppartementLuxe("Vernadskogo", 4, "piscine, concierge");
        System.out.println(al);
        Appartement[] liste = new Appartement[3];
        liste[0] = apt;
        liste[1] = apt2;
        liste[2] = al;
        for (int m = 0 ; m < liste.length ; m++) {
            System.out.println(liste[m]);
            if (liste[m] instanceof AppartementLuxe) {
                System.out.println("  → c'est un appartement luxe!");
            }
        }
        BienImmobilier[] biens = new BienImmobilier[2];
        biens[0] = new Studio("Vernadskogo", 50000.0);
        biens[1] = new Immeuble("Michurinski", 10, 120000.0);
        for (int m = 0 ; m < biens.length ; m++) {
            System.out.println(biens[m]);
        }

        // PROG1-6 — Interfaces
        Appartement apt3 = new Appartement("Vernadskogo", 3);
        System.out.println(apt3);
        apt3.louer();
        System.out.println(apt3);
        if (apt3.estLoue()) {
            System.out.println("Appartement déjà loué !");
        }
        apt3.liberer();
        System.out.println(apt3);

        // PROG1-6 | УРОК 6 — Exceptions
        try {
            Appartement aptNull = new Appartement(null, 3);
        } catch (IllegalArgumentException e) {
            System.out.println("Erreur : " + e.getMessage());
        } finally {
            System.out.println("Vérification terminée.");
        }

        try {
            apt3.verifierPieces(0);
        } catch (IllegalArgumentException e) {
            System.out.println("Erreur pièces : " + e.getMessage());
        }

        // Comparable — tri par nombre de pièces
        Appartement[] appts = {
                new Appartement("Vernadskogo", 4),
                new Appartement("Michurinski", 1),
                new Appartement("Lobachevski", 3)
        };
        Arrays.sort(appts);
        for (int m = 0; m < appts.length; m++) {
            System.out.println(appts[m]);
        }
    }
}