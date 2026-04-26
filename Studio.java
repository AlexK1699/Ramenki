public final class Studio extends BienImmobilier {
    private double loyer;

    public Studio(String adresse, double loyer) {
        super(adresse);
        this.loyer = loyer;
    }

    public double prixTotal() {
        return loyer;
    }

    public double prixTotal() {
        System.out.println("Adresse : " + adresse); // ✅ protected — виден!
        return loyer;
    }
}