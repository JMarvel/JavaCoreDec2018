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

/**
 * This class implements a single notebook entry storing the text of the entry
 * in a private <code>String</code> field and the color of the entry in a private
 * <code>color</code> field of the type <code>colorPalette</code>, which is an enum
 * listing six colors.
 */
public class Note {

    enum colorPalette {black, red, green, blue, orange, white}

    private String content = null;
    private int length = 0;
    private colorPalette color = colorPalette.black;


    // Getters

    /**
     * Gets the content of the entry.
     *
     * @return  the content of the note.
     */
    public String getContent() {
        return this.content;
    }

    /**
     * Gets the length of the entry.
     *
     * @return  the length of the entry.
     */
    public int getLength() {
        return this.length;
    }

    /**
     * Gets the color of the entry.
     *
     * @return  the color of the entry.
     */
    public colorPalette getColor() {
        return this.color;
    }


    // Setters

    /**
     * Sets the content of the entry.
     *
     * @param content   the content of the entry.
     */
    public void setContent(String content) {
        this.content = content;
        setLength(content.length());
    }

    /**
     * Sets the length of the entry. Called by the <code>setContent</code> method
     * upon storing the entry.
     *
     * @param length    the length of the entry.
     */
    private void setLength(int length) {
        this.length = length;
    }

    /**
     * Sets the color of the entry.
     *
     * @param color the color of the entry.
     */
    public void setColor(colorPalette color) {
        this.color = color;
    }
}