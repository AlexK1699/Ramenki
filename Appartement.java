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

    public void verifierPieces(int pieces) throws IllegalArgumentException {
        if (pieces <= 0)
            throw new IllegalArgumentException("Le nombre de pièces doit être positif");
        this.pieces = pieces;
    }

    public void louer()   { this.loue = true; }
    public void liberer() { this.loue = false; }

    public int compareTo(Object obj) {
        Appartement autre = (Appartement) obj;
        return this.pieces - autre.getPieces();
    }

    public String toString() {
        return adresse + " - " + pieces + " pièces" +
                (loue ? " [loué]" : " [libre]");
    }
}