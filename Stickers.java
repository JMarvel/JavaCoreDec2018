public class Stickers extends PaperProducts {

    private enum StickersType { OPAQUE, CLEAR, LAMINATED }

    private StickersType stickersType;

    Stickers(String brand, double price, Color itemColor, PaperSize paperSize, StickersType stickersType,
               double horizontalSize_cm, double verticalSize_cm, int density_gm2) {
        this.brand = brand;
        this.price = price;
        this.itemColor = itemColor;
        this.paperSize = paperSize;
        this.stickersType = stickersType;
        this.horizontalSize_cm = horizontalSize_cm;
        this.verticalSize_cm = verticalSize_cm;
        this.density_gm2 = density_gm2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Stickers)) return false;
        Stickers stickers = (Stickers) o;
        return this.paperSize == stickers.paperSize && this.brand.equals(stickers.brand)
                && this.itemColor == stickers.itemColor && this.horizontalSize_cm == stickers.horizontalSize_cm
                && this.verticalSize_cm == stickers.verticalSize_cm && this.density_gm2 == stickers.density_gm2
                && this.stickersType == stickers.stickersType;
    }

    @Override
    public int hashCode() {
        int result = brand.hashCode();
        result = 31 * result + itemColor.hashCode();
        result = 31 * result + paperSize.hashCode();
        result = 31 * result + stickersType.hashCode();
        result = 31 * result + Double.hashCode(horizontalSize_cm);
        result = 31 * result + Double.hashCode(verticalSize_cm);
        result = 31 * result + Integer.hashCode(density_gm2);
        return result;
    }

    @Override
    public String toString() {
        return "A " + itemColor.toString().toLowerCase() + " " + brand + " "
                + paperSize.toString().toLowerCase() + " " + stickersType.toString().toLowerCase()
                + " stickers, " + horizontalSize_cm + " cm x " + verticalSize_cm + " cm, "
                + density_gm2 + " g / m^2 with a price of $" + price;
    }
}
