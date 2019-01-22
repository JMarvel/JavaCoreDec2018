public class PlainPaper extends PaperProducts {

    PlainPaper(String brand, double price, Color itemColor, PaperSize paperSize,
               double horizontalSize_cm, double verticalSize_cm, int density_gm2) {
        this.brand = brand;
        this.price = price;
        this.itemColor = itemColor;
        this.paperSize = paperSize;
        this.horizontalSize_cm = horizontalSize_cm;
        this.verticalSize_cm = verticalSize_cm;
        this.density_gm2 = density_gm2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PlainPaper)) return false;
        PlainPaper paper = (PlainPaper) o;
        return this.paperSize == paper.paperSize && this.brand.equals(paper.brand)
                && this.itemColor == paper.itemColor && this.horizontalSize_cm == paper.horizontalSize_cm
                && this.verticalSize_cm == paper.verticalSize_cm && this.density_gm2 == paper.density_gm2;
    }

    @Override
    public int hashCode() {
        int result = brand.hashCode();
        result = 31 * result + itemColor.hashCode();
        result = 31 * result + paperSize.hashCode();
        result = 31 * result + Double.hashCode(horizontalSize_cm);
        result = 31 * result + Double.hashCode(verticalSize_cm);
        result = 31 * result + Integer.hashCode(density_gm2);
        return result;
    }

    @Override
    public String toString() {
        return "A " + itemColor.toString().toLowerCase() + " " + brand + " "
                + paperSize + " plain paper, " + horizontalSize_cm + " cm x "
                + verticalSize_cm + " cm, " + density_gm2 + " g / m^2 with a price of $ "
                + price;
    }
}
