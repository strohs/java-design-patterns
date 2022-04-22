package patterns.structural.composite;

//Leaf node in composite pattern
public class BinaryFile extends File {

    //size of the file
    private long size;

    public BinaryFile( String name, long size ) {
        super( name );
        this.size = size;
    }

    @Override
    public void ls() {
        System.out.println( getName() + "\t" + size);
    }

    @Override
    public void addFile( File file ) {
        //not applicable to a leaf node
        throw new UnsupportedOperationException( "Leaf node doesn't support addFile operation" );
    }

    @Override
    public File[] getFiles() {
        //not applicable to a leaf node
        throw new UnsupportedOperationException( "Leaf node doesn't support getFiles operation" );
    }

    @Override
    public boolean removeFile( File file ) {
        //not applicable to a leaf node
        throw new UnsupportedOperationException( "Leaf node doesn't support removeFile operation" );
    }
}
