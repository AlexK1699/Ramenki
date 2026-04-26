public abstract class BienImmobilier {
    protected String adresse;  // protected — виден в подклассах!

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