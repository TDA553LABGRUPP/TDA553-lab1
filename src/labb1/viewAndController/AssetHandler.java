package labb1.viewAndController;

import java.util.HashMap;

import javax.imageio.ImageIO;

import java.awt.*;
import java.awt.image.BufferedImage;

import java.io.IOException;

public class AssetHandler {
    private HashMap<Point, BufferedImage> assetPointMap = new HashMap<Point, BufferedImage>();
    private HashMap<String, BufferedImage> assetNameMap = new HashMap<String, BufferedImage>();

    public void addNamedImageToDict(String name) {
        BufferedImage image = makeImageFromModelName(name);
        assetNameMap.put(name, image);
    }

    private BufferedImage findImageFromName(String name) {
        if (assetNameMap.containsKey(name)) {
            return assetNameMap.get(name);
        }else   {
            throw new IllegalArgumentException("Name doesnt exist");
        }
    }

    public void bindPointToNamedImage(String modelName, Point point) {
        assetPointMap.put(point, findImageFromName(modelName));
    }

    private BufferedImage makeImageFromModelName(String modelName) {
        try {
            BufferedImage image = ImageIO
                    .read(DrawPanel.class.getResourceAsStream("pics/" + modelName + ".jpg"));
            return image;
        } catch (IOException e) {
            throw new RuntimeException("Image doesnt exist. Name might be wrong");
            // return new BufferedImage(1, 1, 1);
        }
    }

    public BufferedImage getAssetFromPoint(Point point) {
        if (assetPointMap.containsKey(point)) {
            //might need to make this safe
            return assetPointMap.get(point);
        }else{
            throw new IllegalArgumentException("point does not exist");
        }
    }


    public void refresh(){
        assetPointMap = new HashMap<Point, BufferedImage>();
    }




}
