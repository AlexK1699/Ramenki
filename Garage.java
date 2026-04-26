//public class Garage extends Parking {
//    private int etages;

//    public Garage(int etages) {
        // super() вызывается автоматически — но Parking() не существует!
        // → ОШИБКА КОМПИЛЯЦИИ!
//        this.etages = etages;
//    }
//}

public class Garage extends Parking {
    private int etages;

    public Garage(String adresse, int places, int etages) {
        super(adresse, places); // ✅ явно вызываем super с параметрами!
        this.etages = etages;
    }

    public String toString() {
        return adresse + " - " + places + " places - " + etages + " étages";
    }
}
