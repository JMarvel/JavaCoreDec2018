public class OOP {

    public static void main(String[] args) {
        Pen pen1 = new Pen("Parker", 100, Pen.Color.blue);
        Pen pen2 = new Pen("Parker", 50, Pen.Color.green, 20);
        Pen pen3 = pen2;
        System.out.println(pen1);
        System.out.println(pen1.equals(pen2));
        System.out.println(pen1.hashCode());
        System.out.println(pen3.hashCode());
    }
}

/**
 * Encapsulates a {@code Pen} class. An instance of {@code Pen} features
 * a {@code brand}, {@code inkLevel} set by default to 100, {@code inkColor}
 * (black by default) and {@code price}.
 */
class Pen {

    enum Color {blue, black, red, green}

    private String brand = "Parker";
    private int inkLevel = 100;
    private Color inkColor = Color.black;
    private int price = 10;

    /**
     * Initializes a newly created pen with a brand, level of ink and dolor of ink.
     *
     * @param brand     a pen's brand.
     */
    Pen(String brand) {
        this.brand = brand;
    }

    /**
     * Initializes a newly created pen with a brand, level of ink and dolor of ink.
     *
     * @param brand     a pen's brand.
     * @param inkLevel  a pen's level of ink (from 0 to 100).
     */
    Pen(String brand, int inkLevel) {
        this.brand = brand;

        if (inkLevel >= 0 && inkLevel <= 100)
            this.inkLevel = inkLevel;
    }

    /**
     * Initializes a newly created pen with a brand, level of ink and dolor of ink.
     *
     * @param brand     a pen's brand.
     * @param inkLevel  a pen's level of ink (from 0 to 100).
     * @param inkColor  a pen's color of ink (either blue, black, red or green).
     */
    Pen(String brand, int inkLevel, Color inkColor) {
        this.brand = brand;

        if (inkLevel >= 0 && inkLevel <= 100)
            this.inkLevel = inkLevel;

        this.inkColor = inkColor;
    }

    /**
     * Initializes a newly created pen with a brand, level of ink and dolor of ink.
     *
     * @param brand     a pen's brand.
     * @param inkLevel  a pen's level of ink (from 0 to 100).
     * @param inkColor  a pen's color of ink (either blue, black, red or green).
     * @param price     a pen's price.
     */
    Pen(String brand, int inkLevel, Color inkColor, int price) {
        this.brand = brand;

        if (inkLevel >= 0 && inkLevel <= 100)
            this.inkLevel = inkLevel;

        this.inkColor = inkColor;
        this.price = price;
    }

    /**
     * Compares this {@code Pen} to the specified object.  The result is {@code
     * true} if and only if the argument is not {@code null} and is a {@code
     * Pen} object that features the same brand, ink level and ink color
     * <b>but not the price</b>.
     *
     * @param  obj
     *         The object to compare this {@code Pen} against
     *
     * @return  {@code true} if the given object represents a {@code Pen}
     *          equivalent to this pen, {@code false} otherwise
     */
    @Override public boolean equals(Object obj) {

        if (this == obj)
            return true;

        if (!(obj instanceof Pen))
            return false;

        Pen pen = (Pen) obj;

        return this.inkLevel == pen.inkLevel && this.inkColor.equals(pen.inkColor)
            && this.brand.equals(pen.brand);
    }

    /**
     * Returns a hash code for this pen.
     *
     * @return  a hash code value for this object.
     */
    @Override public int hashCode() {
       int result = (brand.hashCode());
       result = 31 * result + inkColor.hashCode();
       result = 31 * result + Integer.hashCode(inkLevel);
       return result;
    }

    /**
     * Returns a string representation of this {@code Pen}.
     *
     * @return  a string representation of the object.
     */
    @Override public String toString() {
        return "A " + inkColor.toString() + " " + brand + ", filled at " + inkLevel
                + " with a cost of $" + price;
    }
}
