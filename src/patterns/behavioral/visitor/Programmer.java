package patterns.behavioral.visitor;

public class Programmer extends AbstractEmployee {
	private String skill;
	
	public Programmer(String name, String skill) {
		super(name);
		this.skill = skill;
	}
	
	public String getSkill() {
		return skill;
	}



	@Override
    //can implement accept in AbstractEmployee because using "this" would return AbstractEmployee
	public void accept( Visitor visitor ) {
		visitor.visit( this );
	}
}
