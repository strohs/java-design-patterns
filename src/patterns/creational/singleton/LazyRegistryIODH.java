package patterns.creational.singleton;

/**
 * Singleton pattern using lazy initialization holder class. This ensures that, we have a lazy initialization
 * without worrying about synchronization.
 */
public class LazyRegistryIODH {

    private LazyRegistryIODH() {
        System.out.println("In LazyRegistryIODH constructor");
    }

    private static class RegistryHolder {
        static LazyRegistryIODH INSTANCE = new LazyRegistryIODH();
    }

    //singleton class is not created until someone calls this method
    public static LazyRegistryIODH getInstance() {
        return RegistryHolder.INSTANCE;
    }
}
