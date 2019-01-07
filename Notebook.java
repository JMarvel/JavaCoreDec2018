/**
 * ¯\_(ツ)_/¯
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.
 * <p>
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 * <p>
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * @author      John Marvel also known as Evgeny Aleksanov ¯\_(ツ)_/¯
 * @version     1.0
 *
 */

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This class implements a simple console notebook without any save features
 * (trollface). The user can add new notebook entries (implemented via an
 * array of length 10 of items of a separate <code>Note</code> class),
 * edit entries, display a list of all notebook entries, and remove entries.
 *
 */
public class Notebook {

    private Scanner sc = new Scanner(System.in);

    private Note[] entries = null;

    private int numberOfEntries = 0;

    private Notebook() {
        this.entries = new Note[10];
    }

    /**
     * Displays the menu of options for the user.
     */
    private void displayMenu() {

        System.out.println("1. Create new entry\n"
                        + "2. Show a list of all entries\n"
                        + "3. Remove an entry\n"
                        + "4. Edit an entry\n"
                        + "5. Exit the application\n\n"
                        + "Press the corresponding number and hit Enter.");
    }

    /**
     * Reads the menu option entered by the user and calls the corresponding
     * method. Implements an infinite <code>while</code> loop which breaks
     * when the user chooses to exit the application from the menu.
     */
    private void readSelection() throws IOException {
        char choice = '\u0000';
        char ignore = '\u0000';

        do {
            choice = (char) System.in.read();
            do {
                ignore = (char) System.in.read();
            } while (ignore != '\n');

            if (choice == '5') break;

            switch (choice) {
                case '1':
                    addEntry();
                    break;
                case '2':
                    showAllEntries();
                    break;
                case '3':
                    removeEntry();
                    break;
                case '4':
                    editEntry();
                    break;
                default:
                    System.out.println("Your selection is invalid. Please enter a number, from 1 to 5:");
                    break;
            }
            displayMenu();
        } while (true);
    }

    /**
     * Adds a new entry to the notebook, checking beforehand whether the notebook
     * is full.
     */
    private void addEntry() {
        if (this.numberOfEntries == 10) {
            System.out.println("The notebook is full. Remove an entry first");
        } else {
            char colorChoice;
            Note temp = new Note();

            System.out.println("Enter your note:");
            temp.setContent(sc.nextLine());
            System.out.println("Which color do you want the note to be written in?\n"
                            + "1. Black\n2. Red\n3. Green\n4. Blue\n5. Orange\n6. White");

            while (true) {
                colorChoice = sc.nextLine().charAt(0);
                if (colorChoice < '1' || colorChoice > '6') {
                    System.out.println("Your selection is invalid. Please enter a number, from 1 to 6:");
                } else {
                    break;
                }
            }

            switch(colorChoice) {
                case '1':
                    temp.setColor(Note.colorPalette.black);
                    break;
                case '2':
                    temp.setColor(Note.colorPalette.red);
                    break;
                case '3':
                    temp.setColor(Note.colorPalette.green);
                    break;
                case '4':
                    temp.setColor(Note.colorPalette.blue);
                    break;
                case '5':
                    temp.setColor(Note.colorPalette.orange);
                    break;
                case '6':
                    temp.setColor(Note.colorPalette.white);
                    break;
            }
            this.entries[numberOfEntries++] = temp;
            temp = null;
            System.out.println("Entry created.\n");
        }
    }

    /**
     * Displays a listing of all entries in the notebook.
     */
    private void showAllEntries() {
        if (numberOfEntries == 0)
            System.out.println("The notebook is empty, nothing to show.\n");
        else {
            System.out.println("Here's a list of all entries in the notebook:\n\n");
            for (int i = 0; i < this.numberOfEntries; i++) {
                System.out.println("Note #" + (i + 1) + ":");
                System.out.println(this.entries[i].getContent());
                System.out.println("Written in " + this.entries[i].getColor() + "\n");
            }
        }
    }

    /**
     * Removes an entry specified by the user from the notebook shifting all further
     * entries to the left so that there are no holes in the array of <code>Note</code> items.
     */
    private void removeEntry() {
        if (this.numberOfEntries == 0) {
            System.out.println("The notebook is empty, nothing to remove.\n");
        } else {
            int entryToBeRemoved = 0;
            System.out.println("Enter the number of the entry you wish to remove " +
                    "from 1 to " + numberOfEntries + ":");
            while (true) {
                try {
                    entryToBeRemoved = sc.nextInt();
                    if (entryToBeRemoved < 1 || entryToBeRemoved > numberOfEntries) {
                        System.out.println("Your input is invalid. Please enter a number from 1 to "
                                + numberOfEntries + ":");
                        sc.nextLine();
                    } else
                        break;
                } catch (InputMismatchException exc) {
                    System.out.println("Your input is invalid. Please enter a number from 1 to "
                            + numberOfEntries + ":");
                    sc.nextLine();
                }
            }
            while (entryToBeRemoved != numberOfEntries) {
                entries[entryToBeRemoved - 1] = entries[++entryToBeRemoved - 1];
            }

            entries[entryToBeRemoved - 1] = null;
            numberOfEntries--;
            System.out.println("Entry removed.\n");
        }
    }

    /**
     * Enables the user to edit a specified entry - only the content though,
     * not the color.
     */
    private void editEntry() {
        if (this.numberOfEntries == 0) {
            System.out.println("The notebook is empty, nothing to remove.\n");
        } else {
            int entryToBeEdited = 0;
            System.out.println("Enter the number of the entry you wish to edit " +
                    "from 1 to " + numberOfEntries + ":");
            while (true) {
                try {
                    entryToBeEdited = sc.nextInt();
                    if (entryToBeEdited < 1 || entryToBeEdited > numberOfEntries) {
                        System.out.println("Your input is invalid. Please enter a number from 1 to "
                                + numberOfEntries + ":");
                        sc.nextLine();
                    } else
                        break;
                } catch (InputMismatchException exc) {
                    System.out.println("Your input is invalid. Please enter a number from 1 to "
                            + numberOfEntries + ":");
                    sc.nextLine();
                }
            }

            System.out.println("The entry currently reads:\n" + entries[entryToBeEdited - 1].getContent()
                            + "\nEnter the new content:");
            sc.nextLine();
            entries[entryToBeEdited - 1].setContent(sc.nextLine());
            System.out.println("Entry saved.\n");
        }
    }

    public static void main(String[] args) throws java.io.IOException {

        Notebook nb = new Notebook();

        System.out.println("Hey there. I'm a simple notebook application.\n\n"
                            + "Currently there are " + nb.numberOfEntries + " entries in the notebook, which is no wonder, \n"
                            + "since my creator doesn't know yet how to save information to disk \n"
                            + "(which pretty much defies the whole purpose of the application, "
                            + "but who cares anyway, right?)\n\n"
                            + "So tell me, what is it that you want to do now?");

        nb.displayMenu();
        nb.readSelection();
    }
}