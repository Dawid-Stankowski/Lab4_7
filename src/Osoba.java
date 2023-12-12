public class Osoba implements Cloneable {
    private String imie;
    private int wiek;

    // Konstruktor
    public Osoba(String imie, int wiek) {
        this.imie = imie;
        this.wiek = wiek;
    }

    // Metoda clone()
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    // Metoda equals()
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Osoba osoba = (Osoba) obj;
        return wiek == osoba.wiek && imie.equals(osoba.imie);
    }

    // Metoda finalize()
    @Override
    protected void finalize() throws Throwable {
        System.out.println("Metoda finalize wywołana dla " + this);
        super.finalize();
    }

    // Metoda toString()
    @Override
    public String toString() {
        return "Osoba{imie='" + imie + "', wiek=" + wiek + '}';
    }

    public static void main(String[] args) {
        try {
            // Tworzenie obiektu
            Osoba osoba1 = new Osoba("Jan", 25);

            // Testowanie metody clone()
            Osoba osoba2 = (Osoba) osoba1.clone();
            System.out.println("Test klonowania: " + osoba1.equals(osoba2));

            // Testowanie metody equals()
            Osoba osoba3 = new Osoba("Jan", 25);
            System.out.println("Test equals: " + osoba1.equals(osoba3));

            // Testowanie metody finalize()
            osoba1 = null;
            System.gc();

            // Testowanie metody toString()
            System.out.println("Test toString: " + osoba2.toString());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}