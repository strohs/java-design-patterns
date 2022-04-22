package patterns.creational.abstractfactory2;

//Represents an abstract product, in this case a compute instance in the cloud
public interface Instance {
    enum Capacity{micro, small, large}

    void start();

    void attachStorage( Storage storage );

    void stop();
}
