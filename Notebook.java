public class Notebook extends PaperProducts {

    protected enum NotebookType { LINED, DOTTED, PLAIN }

    protected NotebookType notebookType;

    Notebook(String brand, double price, Color itemColor, PaperSize paperSize, NotebookType notebookType,
               double horizontalSize_cm, double verticalSize_cm, int density_gm2) {
        this.brand = brand;
        this.price = price;
        this.itemColor = itemColor;
        this.paperSize = paperSize;
        this.notebookType = notebookType;
        this.horizontalSize_cm = horizontalSize_cm;
        this.verticalSize_cm = verticalSize_cm;
        this.density_gm2 = density_gm2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Notebook)) return false;
        Notebook notebook = (Notebook) o;
        return this.paperSize == notebook.paperSize && this.brand.equals(notebook.brand)
                && this.itemColor == notebook.itemColor && this.horizontalSize_cm == notebook.horizontalSize_cm
                && this.verticalSize_cm == notebook.verticalSize_cm && this.density_gm2 == notebook.density_gm2
                && this.notebookType == notebook.notebookType;
    }

    @Override
    public int hashCode() {
        int result = brand.hashCode();
        result = 31 * result + itemColor.hashCode();
        result = 31 * result + paperSize.hashCode();
        result = 31 * result + notebookType.hashCode();
        result = 31 * result + Double.hashCode(horizontalSize_cm);
        result = 31 * result + Double.hashCode(verticalSize_cm);
        result = 31 * result + Integer.hashCode(density_gm2);
        return result;
    }

    @Override
    public String toString() {
        return "A " + itemColor.toString().toLowerCase() + " " + brand + " "
                + paperSize + " " + notebookType.toString().toLowerCase() + " notebook, "
                + horizontalSize_cm + " cm x " + verticalSize_cm + " cm, " + density_gm2
                + " g / m^2 + with a price of $" + price;
    }
}
