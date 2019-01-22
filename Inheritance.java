import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.TreeSet;

public class Inheritance {

    private static ArrayList<Stationery> starterKit1 = new ArrayList<>();
    private static TreeSet<Stationery> starterKit2 = new TreeSet<>(new Stationery());

    private static Stationery[] items = {
            new Pen("Koh-i-Noor", 2.5, Stationery.Color.RED,
                    Stationery.Color.BLUE, Pen.PenType.INK),
            new Notebook("Sovietskiy", 20, Stationery.Color.GREEN,
            PaperProducts.PaperSize.A6, Notebook.NotebookType.PLAIN,10.5,
            14.8,80),
            new Pencil("Koh-i-Noor", 3, Stationery.Color.ORANGE,
            Stationery.Color.BLACK, Pencil.PencilType.MECHANICAL, Pencil.CoreType.GRAPHITE),
            new Fineliner("Sovietskiy", 12.1, Stationery.Color.BLUE,
                    Stationery.Color.YELLOW, Fineliner.FinelinerType.HIGHLIGHTER)};

    public static void main(String[] args) {

        starterKit1.addAll(Arrays.asList(items));

        System.out.println("Here's our unsorted starter kit # 1 (an ArrayList):\n");
        for (var stationery : starterKit1)
            System.out.println(stationery);

        Collections.sort(starterKit1);

        System.out.println("\n\nHere's our starter kit # 1 sorted thru the Comparable interface by brand\n" +
                "after applying Collections.sort():\n");

        for (var stationery : starterKit1)
            System.out.println(stationery);


        System.out.println("\n\nHere's the insertion order of the items into our starter kit # 2 (a TreeSet),\n" +
                "which implements a custom comparator, first by brand, then by price:\n");
        for (Stationery item : items) {
            starterKit2.add(item);
            System.out.println(item);
        }

        System.out.println("\n\nHere's our starter kit # 2 after inserting all the items:\n");
        for (var stationery : starterKit2)
            System.out.println(stationery);
    }
}
