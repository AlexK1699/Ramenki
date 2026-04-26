public class AppartementLuxe extends Appartement {
    private String services;
    private int pieces;  // омоним — плохая практика! но не ошибка компиляции

    public AppartementLuxe(String adresse, int pieces, String services) {
        super(adresse, pieces);
        this.services = services;
        System.out.println("Constructeur AppartementLuxe : " + adresse);
    }

    // super.метод() — вызов метода суперкласса
    public String description() {
        return super.description() + " [LUXE] services: " + services;
    }

    // Попытка переопределить final метод → ОШИБКА КОМПИЛЯЦИИ!
    // public String typeLogement() {
    //     return "Appartement luxe";
    // }

    public String toString() {
        return super.toString() + " - services: " + services;
    }
}