package patterns.creational.prototype;

//Doesn't support cloning, we want the general to be a unique unit
public class General extends GameUnit {

	private String state = "idle";
	
	public void boostMorale() {
		this.state = "MoralBoost";
	}
	
	@Override
	public String toString() {
		return "General "+state+" @ "+getPosition();
	}

    @Override
    public GameUnit clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException( "Generals are unique" );
    }

    @Override
	protected void reset() {
	    throw new UnsupportedOperationException( "Reset not supported" );
	}
}
