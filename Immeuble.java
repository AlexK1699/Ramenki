public class Immeuble extends BienImmobilier {
    private int nbAppartements;
    private double prixParAppart;

    public Immeuble(String adresse, int nbAppartements, double prixParAppart) {
        super(adresse);
        this.nbAppartements = nbAppartements;
        this.prixParAppart  = prixParAppart;
    }

    public double prixTotal() {
        return nbAppartements * prixParAppart;
    }

    // protected — доступ к атрибуту суперкласса напрямую!
    public String description() {
        return "Immeuble à " + adresse + " - " + nbAppartements + " appartements";
        //                      ↑ без геттера! adresse protected в BienImmobilier
    }
}