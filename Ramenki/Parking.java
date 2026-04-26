public class Parking {
    String adresse;
    int places;

    public Parking(String adresse, int places) {
        this.adresse = adresse;
        this.places  = places;
    }
    // конструктор по умолчанию больше НЕ существует!
    // Garage() → super() → Parking() → ОШИБКА КОМПИЛЯЦИИ!
}
