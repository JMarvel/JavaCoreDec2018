public class Pen extends WritingInstruments {

    protected enum PenType { GEL, INK, FEATHER}

    protected PenType penType;

    Pen (String brand, double price, Color itemColor, Color coreInkColor, PenType penType) {
        this.brand = brand;
        this.price = price;
        this.itemColor = itemColor;
        this.coreInkColor = coreInkColor;
        this.penType = penType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pen)) return false;
        Pen pen = (Pen) o;
        return this.penType == pen.penType && this.brand.equals(pen.brand)
               && this.itemColor == pen.itemColor && this.coreInkColor == pen.coreInkColor;
    }

    @Override
    public int hashCode() {
        int result = brand.hashCode();
        result = 31 * result + itemColor.hashCode();
        result = 31 * result + coreInkColor.hashCode();
        result = 31 * result + penType.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "A " + itemColor.toString().toLowerCase() + " " + brand
                + " " + penType.toString().toLowerCase() + " pen with "
                + coreInkColor.toString().toLowerCase() + " ink color with a price of $"
                + price;
    }
}
