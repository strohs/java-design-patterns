package patterns.creational.abstractfactory2;


import patterns.creational.abstractfactory2.aws.AwsResourceFactory;
import patterns.creational.abstractfactory2.gcp.GoogleResourceFactory;

public class Client {

    private ResourceFactory factory;

    public Client( ResourceFactory factory ) {
        this.factory = factory;
    }

    //creates a compute instance using whatever factory implementation was instantiated by the client
    public Instance createServer( Instance.Capacity cap, int storageMB) {
        Instance instance = factory.createInstance( cap );
        Storage storage = factory.createStorage( storageMB );
        instance.attachStorage( storage );
        return instance;
    }

    public static void main(String[] args) {
        //example 1 create AWS resource using AwsResourceFactory
        Client aws = new Client( new AwsResourceFactory() );
        Instance i1 = aws.createServer( Instance.Capacity.micro, 20480 );
        i1.start();
        i1.stop();

        System.out.println("======================================================");

        //example 2 create Google Cloud resources using GoogleResourceFactory
        Client goog = new Client( new GoogleResourceFactory() );
        Instance i2 = goog.createServer( Instance.Capacity.large, 1024 );
        i2.start();
        i2.stop();
    }

}
