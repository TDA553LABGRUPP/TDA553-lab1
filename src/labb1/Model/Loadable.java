package labb1.Model;

import java.util.ArrayList;

/**
 * Class for Loadable
 */
public class Loadable {
    private int max_amount;
    private double x;
    private double y;
    private ArrayList<Movable> loaded;

    /**
     * Constructor of Loadable
     * 
     * @param max_amount the max amount that a object can load
     * @param x          is the x coordinate of the object
     * @param y          is the y coordinate of the object
     */
    public Loadable(int max_amount, double x, double y) {
        this.x = x;
        this.y = y;
        this.max_amount = max_amount;
        this.loaded = new ArrayList<Movable>();
    }

    /**
     * Load a Movable object if it is in the close proximity of the Loadable object
     * 
     * @param item as a Movable
     */
    public void load(Movable item) {
        double deltaX = item.getX() - this.x;
        double deltaY = item.getY() - this.y;
        if (Helpers.inBounds(1, -1, deltaX) == 0 && Helpers.inBounds(1, -1, deltaY) == 0) {
            addItemInList(item);
        } else {
            throw new IllegalArgumentException("too far away from the loadable");
        }
    }

    /**
     * If an item is to be loaded, first check if it is less than max amount and if
     * not, add it to the loaded list
     * 
     * @param item as a Movable
     */
    private void addItemInList(Movable item) {
        if (loaded.size() < max_amount) {
            loaded.add(item);
            System.out.println("added item");
        } else {
            throw new IllegalStateException("Loadable is full");
        }
    }

    /**
     * If an item is to be unloaded, first check if it is in the loaded list and if
     * it is, remove it from the list
     * 
     * @param item as a Movable
     * @return item as a Movable
     */
    public Movable unload(Movable item) {
        if (loaded.contains(item)) {
            loaded.remove(item);
            return item;
        } else {
            throw new IllegalStateException("Item not loaded");
        }
    }
}
