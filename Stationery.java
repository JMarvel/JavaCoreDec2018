import java.util.Comparator;

/**
 * @author Marvel aka Evgeny Aleksanov
 *
 * Note: This class has a natural ordering that is inconsistent with <code>equals</code>,
 * that is, <code>x.compareTo(y) == 0</code> does not assert that <code>x.equals(y)</code>
 * is true, since comparison is performed on the basis of one significant field only,
 * whereas all stationery objects have at least three significant fields.
 */
public class Stationery implements Comparable<Stationery>, Comparator<Stationery>{

    protected enum Color { BLACK, RED, ORANGE, YELLOW, GREEN, BLUE, WHITE }

    protected String brand;
    protected double price;
    protected Color itemColor;

    @Override
    public int compareTo(Stationery otherStationery) {
        return this.brand.compareTo(otherStationery.brand);
    }

    @Override
    public int compare(Stationery o1, Stationery o2) {
        int result = o1.brand.compareTo(o2.brand);
        return result == 0 ? Double.compare(o1.price, o2.price) : result;
    }
}