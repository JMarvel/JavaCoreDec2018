public class Pencil extends WritingInstruments {

    protected enum PencilType { WOODEN, MECHANICAL }
    protected enum CoreType { GRAPHITE, CRAYON }

    private PencilType pencilType;
    private CoreType coreType;

    Pencil (String brand, double price, Color itemColor, Color coreInkColor, PencilType pencilType,
            CoreType coreType) {
        this.brand = brand;
        this.price = price;
        this.itemColor = itemColor;
        this.coreInkColor = coreInkColor;
        this.pencilType = pencilType;
        this.coreType = coreType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pencil)) return false;
        Pencil pencil = (Pencil) o;
        return this.pencilType == pencil.pencilType && this.brand.equals(pencil.brand)
                && this.itemColor == pencil.itemColor && this.coreInkColor == pencil.coreInkColor
                && this.coreType == pencil.coreType;
    }

    @Override
    public int hashCode() {
        int result = brand.hashCode();
        result = 31 * result + itemColor.hashCode();
        result = 31 * result + coreInkColor.hashCode();
        result = 31 * result + pencilType.hashCode();
        result = 31 * result + coreType.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "A " + itemColor.toString().toLowerCase() + " " + brand + " "
                + pencilType.toString().toLowerCase() + " pencil with a "
                + coreType.toString().toLowerCase() + " " + coreInkColor.toString().toLowerCase()
                + " core with a price of $" + price;
    }
}
