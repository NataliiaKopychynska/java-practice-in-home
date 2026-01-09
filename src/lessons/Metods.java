package lessons;

import java.util.Objects;

public class Metods {
    private String name;
    private double price;
    private String id;

    public Metods(String name, double price, String id) {
        this.name = name;
        this.price = price;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Metods{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Metods metods = (Metods) o;
        return Double.compare(price, metods.price) == 0 && Objects.equals(name, metods.name) && Objects.equals(id, metods.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, id);
    }
}
