package patterns.creational.abstractfactory2.gcp;


import patterns.creational.abstractfactory2.Instance;
import patterns.creational.abstractfactory2.ResourceFactory;
import patterns.creational.abstractfactory2.Storage;

//Factory implementation for Google cloud platform resources
public class GoogleResourceFactory implements ResourceFactory {


    @Override
    public Instance createInstance( Instance.Capacity capacity ) {
        return new GoogleComputeEngineInstance( capacity );
    }

    @Override
    public Storage createStorage( int capMB ) {
        return new GoogleCloudStorage( capMB );
    }
}
