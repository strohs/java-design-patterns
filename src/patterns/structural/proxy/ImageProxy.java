package patterns.structural.proxy;

import javafx.geometry.Point2D;

//Proxy class.
public class ImageProxy implements Image {

    //this is going to be a virtual proxy, we will create the real object until it is absolutely necessary

    private String name;
    private BitmapImage image;
    private Point2D location;

    public ImageProxy( String name ) {
        this.name = name;
    }

    @Override
    public void setLocation( Point2D point2d ) {
        //if real object has already been created then set the location
        if ( image != null ) {
            image.setLocation( point2d );
        } else {
            //store the location locally until we create the real object
            location = point2d;
        }
    }

    @Override
    public Point2D getLocation() {
        if ( image != null ) {
            return image.getLocation();
        }
        return location;
    }

    @Override
    public void render() {
        if ( image == null ) {
            //create the real object here
            image = new BitmapImage( name );
            if ( location != null ) {
                image.setLocation( location );
            }
        }
        image.render();
    }
}
