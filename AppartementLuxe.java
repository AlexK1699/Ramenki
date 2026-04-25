public class AppartementLuxe extends Appartement {
    private String services;

    public AppartementLuxe(String adresse, int pieces, String services) {
        super(adresse, pieces);
        this.services = services;
    }

    public String toString() {
        return super.toString() + " - services: " + services;
    }
}