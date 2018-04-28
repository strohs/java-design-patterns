package patterns.behavioral.command;

//This class is the receiver (of commands)
//a dummy service class that adds and removes members from a mailing list server
public class EWSService {

	//Add a new member to mailing list
	public void addMember(String contact, String contactGroup) {
		//contact exchange
		System.out.println("Added "+contact +" to "+contactGroup);
	}
	
	//Remove member from mailing list
	public void removeMember(String contact, String contactGroup) {
		//contact exchange
		System.out.println("Removed "+contact +" from "+contactGroup);
	}
}
