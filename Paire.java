public class Paire<T extends Comparable> {
    private T premier;
    private T second;

    public Paire(T a, T b) {
        premier = a;
        second  = b;
    }

    public T getPremier() { return premier; }
    public T getSecond()  { return second;  }

    public T min() {
        if (premier.compareTo(second) <= 0)
            return premier;
        else
            return second;
    }
}
