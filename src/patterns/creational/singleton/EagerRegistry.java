package patterns.creational.singleton;

/**
 * This class uses eager initialization of singleton instance.
 * Singleton is created when this class is loaded
 */
public class EagerRegistry {

    //private constructor
    private EagerRegistry() {

    }

    private static final EagerRegistry INSTANCE = new EagerRegistry();

    public static EagerRegistry getInstance() {
        return INSTANCE;
    }
}