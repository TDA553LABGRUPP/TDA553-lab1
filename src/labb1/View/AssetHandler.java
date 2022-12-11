package labb1.View;

import java.util.HashMap;

import javax.imageio.ImageIO;

import java.awt.*;
import java.awt.image.BufferedImage;

import java.io.IOException;

/*
 * this class keeps track of the various images and binds them to their names for better performance and then binds the loaded images to input points
 * the assetNameMap names have to always correspond to the image name (case sensistive)
 */
public class AssetHandler {
    private HashMap<Point, BufferedImage> assetPointMap = new HashMap<Point, BufferedImage>(); // A HashMap that keeps
                                                                                               // track of what images
                                                                                               // are at which points
    private HashMap<String, BufferedImage> assetNameMap = new HashMap<String, BufferedImage>(); // A HashMap that keeps
                                                                                                // track of what names
                                                                                                // are connected to what
                                                                                                // images(for cpu
                                                                                                // offloading)

    /**
     * addNamedImageToDict
     * 
     * This function maps string to particular images and stores it in a hash map
     * 
     * @param name The name of the image (Has to match or exeption is thrown). Name
     *             also needs to be 10 chars or under for injection safety
     * @return the corresponding image
     * 
     */
    public void addNamedImageToDict(String name) {
        if (name.length() <= 10) {
            BufferedImage image = makeImageFromModelName(name);
            assetNameMap.put(name, image);
        } else {
            throw new IllegalArgumentException(
                    "String was " + name.length() + " long when its supposed to be under 10 chars");
        }

    }

    /**
     * findImageFromName
     * 
     * This function finds an image from a string name in the given image directory
     * 
     * @param name The name of the image (Has to match or exeption is thrown)
     * @return the wanted image
     * 
     */

    private BufferedImage findImageFromName(String name) {
        if (assetNameMap.containsKey(name)) {
            return assetNameMap.get(name);
        } else {
            throw new IllegalArgumentException("Name " + name + " doesnt exist");
        }
    }

    /**
     * bindPointToNamedImage
     * 
     * This function binds a point to an image from a given name. Name has to exist
     * in prior dict or throws exception
     * 
     * @param modelName the name to search for
     * 
     * @param point     any point that is to be linked to the image
     * 
     */
    public void bindPointToNamedImage(String modelName, Point point) {
        assetPointMap.put(point, findImageFromName(modelName));
    }

    /**
     * makeImageFromModelNam
     * 
     * this function makes an image using the Buffered Image library from a given
     * place
     * 
     * @param modelName this needs to exist as an image name(case sensitive) or
     *                  exception is thrown
     * @return the wanted image
     */
    private BufferedImage makeImageFromModelName(String modelName) {
        try {
            BufferedImage image = ImageIO
                    .read(DrawPanel.class.getResourceAsStream("pics/" + modelName + ".jpg"));
            return image;
        } catch (IOException e) {
            throw new RuntimeException("Image with the name " + modelName + " doesnt exist.");
            // return new BufferedImage(1, 1, 1);
        }
    }

    /**
     * getAssetFromPoint
     * 
     * this function finds an image in the point map
     * 
     * @param point the point to search for (throws exception if not in there)
     * @return the wanted image
     * 
     */
    public BufferedImage getAssetFromPoint(Point point) {
        if (assetPointMap.containsKey(point)) {
            // TODO see if you can be more defensive here
            return assetPointMap.get(point);
        } else {
            throw new IllegalArgumentException("point " + point + " does not exist in hash");
        }
    }

    public void refresh() {
        assetPointMap = new HashMap<Point, BufferedImage>();
    }

}
