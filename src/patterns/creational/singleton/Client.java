package patterns.creational.singleton;

public class Client {

	public static void main(String[] args) {

	    //get the singleton instance
	    EagerRegistry registry = EagerRegistry.getInstance();

	    //lazy singleton with double check locking
	    LazyRegistryWithDCL registryWithDCL1 = LazyRegistryWithDCL.getInstance();
        LazyRegistryWithDCL registryWithDCL2 = LazyRegistryWithDCL.getInstance();
        System.out.println( registryWithDCL1 == registryWithDCL2);

        //lazy singleton IODH
        LazyRegistryIODH lazyRegistryIODH =  LazyRegistryIODH.getInstance();
	}

}
