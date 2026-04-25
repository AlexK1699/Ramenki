public abstract class BienImmobilier {
    private String adresse;

    public BienImmobilier(String adresse) {
        this.adresse = adresse;
    }

    public String getAdresse() {
        return adresse;
    }

    public abstract double prixTotal();

    public String toString() {
        return adresse + " : " + prixTotal() + " €";
    }
}