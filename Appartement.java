// Visibilité de la classe:
// public class Appartement → visible partout
// class Appartement        → visible dans le même paquetage seulement
public class Appartement implements Louable, Comparable {
    private String adresse;
    private int pieces;
    private boolean loue;
    private static int nombreAppartements = 0;

    static {
        System.out.println("Classe Appartement chargée !");
    }

    public Appartement(String adresse, int pieces) {
        if (adresse == null)
            throw new IllegalArgumentException("L'adresse ne peut pas être nulle");
        this.adresse = adresse;
        this.pieces  = pieces;
        this.loue    = false;
        nombreAppartements++;
        System.out.println("Constructeur Appartement : " + adresse);
    }

    public Appartement(String adresse) {
        this(adresse, 1);
    }

    public String getAdresse()  { return this.adresse; }
    public int getPieces()      { return this.pieces; }
    public boolean estLoue()    { return loue; }

    public static int getNombreAppartements() {
        return nombreAppartements;
    }

    public void setAdresse(String adresse) { this.adresse = adresse; }
    public void setPieces(int pieces)      { this.pieces = pieces; }

    // this в обычном методе — различает атрибут и параметр
    public boolean memeAdresse(String adresse) {
        return this.adresse.equals(adresse);
    }

    public void louer()   { this.loue = true; }
    public void liberer() { this.loue = false; }

    public void verifierPieces(int pieces) throws IllegalArgumentException {
        if (pieces <= 0)
            throw new IllegalArgumentException("Le nombre de pièces doit être positif");
        this.pieces = pieces;
    }

    public int compareTo(Object obj) {
        Appartement autre = (Appartement) obj;
        return this.pieces - autre.getPieces();
    }

    // Polymorphisme ad-hoc — même nom, signatures différentes!
    public String description() {
        return "Appartement : " + adresse + " - " + pieces + " pièces";
    }

    public String description(String extra) {
        return "Appartement : " + adresse + " - " + pieces + " pièces - " + extra;
    }

    // return в void методе
    public void afficherSiGrand() {
        if (pieces < 3) {
            System.out.println("Trop petit !");
            return;
        }
        System.out.println(adresse + " est un grand appartement !");
    }

    // final метод — нельзя переопределить в подклассе!
    public final String typeLogement() {
        return "Appartement standard";
    }

    public String toString() {
        return adresse + " - " + pieces + " pièces" +
                (loue ? " [loué]" : " [libre]");
    }

    protected void finalize() {
        System.out.println("Appartement " + adresse + " supprimé de la mémoire");
    }
}