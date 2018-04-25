package patterns.creational.abstractfactory2.aws;


import patterns.creational.abstractfactory2.Instance;
import patterns.creational.abstractfactory2.ResourceFactory;
import patterns.creational.abstractfactory2.Storage;

//Factory implementation for Amazon Web Services resources
public class AwsResourceFactory implements ResourceFactory {


    @Override
    //create EC2 instance
    public Instance createInstance( Instance.Capacity capacity ) {
        return new Ec2Instance( capacity );
    }

    @Override
    //create S3 storage
    public Storage createStorage( int capMB ) {
        return new S3Storage( capMB );
    }
}
