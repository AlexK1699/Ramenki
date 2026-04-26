public class PaireHetero<T, U> {
    private T premier;
    private U second;

    public PaireHetero(T a, U b) {
        premier = a;
        second  = b;
    }

    public T getPremier() { return premier; }
    public U getSecond()  { return second;  }
}