import java.util.Arrays;

public class Ramenki {

    public static void modifier(int nb, Appartement a) {
        nb = 999;
        a.setPieces(999);
    }

    public static <T> T choix(T a, T b) {
        return (int)(Math.random() * 2) == 1 ? a : b;
    }

    public static void affichePaire(Paire<?> p) {
        System.out.println(p.getPremier() + " / " + p.getSecond());
    }

    public static void main(String[] args) {

        // PROG1-1 | УРОК 1
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

        // PROG1-2 | УРОК 2 — if
        if (densite < 100) {
            System.out.println("District peu dense");
        } else if (densite >= 100 && densite <= 300) {
            System.out.println("District moyen");
        } else {
            System.out.println("District très dense");
        }

        // PROG1-2 | УРОК 2 — switch
        int ligne = 5;
        switch (ligne) {
            case 1  : System.out.println("Sokolnitcheskaya"); break;
            case 5  : System.out.println("Filyovskaya");      break;
            case 10 : System.out.println("Lyublinskaya");     break;
            default : System.out.println("Autre ligne");
        }

        // PROG1-3 | УРОК 3 — Массивы + for
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

        // PROG1-2 | УРОК 2 — while
        int i     = 0;
        int somme = 0;
        while (i < immeubles.length) {
            somme = somme + immeubles[i];
            i++;
        }
        System.out.println("Total immeubles : " + somme);

        // PROG1-2 | УРОК 2 — do...while
        int j = 0;
        do {
            if ("Vernadski".equals(rues[j])) {
                System.out.println(rues[j] + "... trouvé !");
            } else {
                System.out.println(rues[j] + "... pas encore");
            }
            j++;
        } while (!("Vernadski".equals(rues[j-1])) && j < rues.length);

        // PROG1-2 | УРОК 2 — break, метки
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

        // PROG1-3 | УРОК 3 — Строки
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

        // PROG1-3 | УРОК 3 — Двумерный массив
        for (int a = 0 ; a < apparts.length ; a++) {
            System.out.print(rues[a] + " : ");
            for (int b = 0 ; b < apparts[a].length ; b++) {
                System.out.print(apparts[a][b]);
                switch (b) {
                    case 0 : System.out.print(" studios");      break;
                    case 1 : System.out.print(" deux-pièces");  break;
                    case 2 : System.out.print(" trois-pièces"); break;
                }
                if (b < apparts[a].length - 1) System.out.print(", ");
            }
            System.out.println();
        }

        // PROG1-3 | УРОК 3 — Зубчатый массив
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

        // PROG1-4 | УРОК 4 — Objets et classes
        Appartement apt = new Appartement("Vernadskogo", 3);
        System.out.println(apt);
        Appartement apt2 = new Appartement("Michurinski");
        System.out.println(apt2);
        System.out.println("Nombre d'appartements : " + Appartement.getNombreAppartements());

        // StringBuffer
        StringBuffer sb = new StringBuffer();
        sb.append("Vernadskogo");
        sb.insert(0, "Rue ");
        sb.append(", Moscou");
        System.out.println(sb.toString());

        // Каскадные вызовы StringBuffer
        StringBuffer sbChaine = new StringBuffer();
        sbChaine.append("Ramenki").append(" - ").append("Moscou");
        System.out.println(sbChaine.toString());

        // Все методы StringBuffer
        StringBuffer sb2 = new StringBuffer("Michurinski");
        System.out.println("length : "    + sb2.length());
        System.out.println("capacity : "  + sb2.capacity());
        System.out.println("charAt : "    + sb2.charAt(0));
        System.out.println("substring : " + sb2.substring(0, 4));
        sb2.delete(4, 7);
        System.out.println("delete : "    + sb2);
        sb2.deleteCharAt(0);
        System.out.println("deleteCharAt : " + sb2);
        sb2.replace(0, 2, "Vera");
        System.out.println("replace : "   + sb2);
        sb2.setCharAt(0, 'X');
        System.out.println("setCharAt : " + sb2);

        // Конструкторы StringBuffer
        StringBuffer sb3 = new StringBuffer();
        StringBuffer sb4 = new StringBuffer(50);
        StringBuffer sb5 = new StringBuffer("Vernadskogo");
        System.out.println("sb3 capacity : " + sb3.capacity());
        System.out.println("sb4 capacity : " + sb4.capacity());
        System.out.println("sb5 : "           + sb5.toString());

        // Сеттеры
        apt.setAdresse("Lobachevski");
        apt.setPieces(5);
        System.out.println(apt);

        // Передача параметров по значению
        int nb = 10;
        Appartement a = new Appartement("Udaltcova", 2);
        modifier(nb, a);
        System.out.println("nb = " + nb);
        System.out.println("pieces = " + a.getPieces());

        // Перегрузка методов
        System.out.println(apt.description());
        System.out.println(apt.description("vue sur parc"));

        // return в void методе
        apt.afficherSiGrand();
        apt2.afficherSiGrand();

        // NullPointerException
        Appartement aptNul = null;
        try {
            System.out.println(aptNul.getAdresse());
        } catch (NullPointerException e) {
            System.out.println("NullPointerException : référence nulle!");
        }

        // this в обычном методе
        System.out.println(apt.memeAdresse("Lobachevski")); // true
        System.out.println(apt.memeAdresse("Vernadskogo")); // false

        Appartement aptGC = new Appartement("Ozernaya", 2);
        aptGC = null;           // убираем ссылку
        System.gc();            // просим GC собрать мусор
        System.out.println("GC demandé — finalize() peut être appelé");

        // Метод вызывает другой метод через this
        System.out.println(apt.resume());

        // Атрибуты-омонимы — pieces в AppartementLuxe скрывает pieces в Appartement
        // Плохая практика но не ошибка компиляции!
        AppartementLuxe alOmo = new AppartementLuxe("Ozernaya", 3, "spa");
        System.out.println("pieces via getPieces() : " + alOmo.getPieces()); // из Appartement

        // PROG1-5 | УРОК 5 — Héritage
        AppartementLuxe al = new AppartementLuxe("Vernadskogo", 4, "piscine, concierge");
        System.out.println(al);

        // Полиморфизм
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

        // Polymorphisme ad-hoc — même nom, signatures différentes, sans héritage
        // Le compilateur choisit la méthode selon le TYPE des paramètres!
        System.out.println(apt.description());              // → description()
        System.out.println(apt.description("vue sur parc")); // → description(String)

        // abstract + polymorphisme + final
        BienImmobilier[] biens = new BienImmobilier[2];
        biens[0] = new Studio("Vernadskogo", 50000.0);
        biens[1] = new Immeuble("Michurinski", 10, 120000.0);
        for (int m = 0 ; m < biens.length ; m++) {
            System.out.println(biens[m]);
        }

        // final метод
        System.out.println(apt.typeLogement());
        System.out.println(al.typeLogement());

        // super.метод()
        System.out.println(al.description());

        // Порядок конструкторов
        System.out.println("--- Création AppartementLuxe ---");
        AppartementLuxe al2 = new AppartementLuxe("Ozernaya", 3, "piscine");

        // Объявленный тип vs реальный тип
        Appartement aptPoly = new AppartementLuxe("Lobachevski", 2, "gym");
        System.out.println(aptPoly);  // вызывает toString() AppartementLuxe!
        System.out.println(aptPoly instanceof AppartementLuxe); // true
        System.out.println(aptPoly instanceof Appartement);     // true
        System.out.println(aptPoly instanceof Object);          // true

        // instanceof с Object
        Object obj = new Appartement("Ramenki", 1);
        System.out.println(obj instanceof Object);      // true
        System.out.println(obj instanceof Appartement); // true

        // Parking — конструктор по умолчанию
        Parking p = new Parking("Michurinski", 50);
        System.out.println(p.adresse + " : " + p.places + " places");

        // PROG1-6 | УРОК 6 — Interfaces
        Appartement apt3 = new Appartement("Vernadskogo", 3);
        System.out.println(apt3);
        apt3.louer();
        System.out.println(apt3);
        if (apt3.estLoue()) {
            System.out.println("Appartement déjà loué !");
        }
        apt3.liberer();
        System.out.println(apt3);

        // Exceptions
        try {
            Appartement aptNull = new Appartement(null, 3);
        } catch (IllegalArgumentException e) {
            System.out.println("Erreur : " + e.getMessage());
        } finally {
            System.out.println("Vérification terminée.");
        }

        // throws
        try {
            apt3.verifierPieces(0);
        } catch (IllegalArgumentException e) {
            System.out.println("Erreur pièces : " + e.getMessage());
        }

        // Comparable
        Appartement[] appts = {
                new Appartement("Vernadskogo", 4),
                new Appartement("Michurinski", 1),
                new Appartement("Lobachevski", 3)
        };
        Arrays.sort(appts);
        for (int m = 0; m < appts.length; m++) {
            System.out.println(appts[m]);
        }

        // protected — accès direct à l'attribut du superclasse sans getter
        Immeuble imm = new Immeuble("Vernadskogo", 10, 120000.0);
        System.out.println(imm.description());

        // PROG2-1 | Généricité
        Paire<String> stationsMetro = new Paire<String>("Ramenki", "Michurinski");
        Paire<Integer> prix         = new Paire<Integer>(50000, 120000);
        System.out.println(stationsMetro.getPremier());
        System.out.println(stationsMetro.getSecond());
        System.out.println(prix.getPremier());

        // Обобщённый метод
        String station = choix("Ramenki", "Michurinski");
        System.out.println("Station choisie : " + station);

        // min() с Comparable
        System.out.println("Station min : " + stationsMetro.min());
        System.out.println("Prix min : "    + prix.min());

        // Wildcard <?>
        affichePaire(stationsMetro);
        affichePaire(prix);
    }
}