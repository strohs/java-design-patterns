package patterns.creational.objectPool;

import javafx.geometry.Point2D;

//concrete reusable, this is the class we want to pool so we don't trigger going out to disk
// to read and image each time
public class Bitmap implements Image {

    private Point2D location;

    private String name;

    public Bitmap(String name) {
        //in reality this class would read image data from disk and store it in a byte array
        this.name = name;
    }

    @Override
    public void draw() {
        System.out.println("Drawing "+name+" @ "+location);
    }

    @Override
    public Point2D getLocation() {
        return location;
    }

    @Override
    public void setLocation(Point2D location) {
        this.location = location;
    }

    @Override
    public void reset() {
        setLocation( null );
        System.out.println("Bitmap is reset");
    }
}
