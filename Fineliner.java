public class Fineliner extends WritingInstruments {

    protected enum FinelinerType { PERMANENT, WATERPROOF, WHITEBOARD, HIGHLIGHTER }

    private FinelinerType finelinerType;

    Fineliner(String brand, double price, Color itemColor, Color coreInkColor, FinelinerType finelinerType) {
        this.brand = brand;
        this.price = price;
        this.itemColor = itemColor;
        this.coreInkColor = coreInkColor;
        this.finelinerType = finelinerType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Fineliner)) return false;
        Fineliner fineliner = (Fineliner) o;
        return this.finelinerType == fineliner.finelinerType && this.brand.equals(fineliner.brand)
                && this.itemColor == fineliner.itemColor && this.coreInkColor == fineliner.coreInkColor;
    }

    @Override
    public int hashCode() {
        int result = brand.hashCode();
        result = 31 * result + itemColor.hashCode();
        result = 31 * result + coreInkColor.hashCode();
        result = 31 * result + finelinerType.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "A " + itemColor.toString().toLowerCase() + " " + brand + " "
                + finelinerType.toString().toLowerCase() + " fineliner with "
                + coreInkColor.toString().toLowerCase() + " ink color with a price of $"
                + price;
    }
}
