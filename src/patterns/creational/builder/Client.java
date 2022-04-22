package patterns.creational.builder;

import java.time.LocalDate;

//This is our example client which also works as "director". It will build a UserWebDTO
public class Client {

	public static void main(String[] args) {
	    UserDTOBuilder builder = new UserWebDTOBuilder();
	    User user = createUser();
	    UserDTO dto = directBuild( builder,user );
        System.out.println( dto );
	}

	//build a UserDTO
	private static UserDTO directBuild( UserDTOBuilder builder, User user ) {
	    return builder.withFirstName( user.getFirstName() )
            .withLastName( user.getLastName() )
            .withAddress( user.getAddress() )
            .withBirthday( user.getBirthday() )
            .build();
    }
    
	/**
	 * Returns a sample user. 
	 */
	public static User createUser() {
		User user = new User();
		user.setBirthday(LocalDate.of(1960, 5, 6));
		user.setFirstName("Ron");
		user.setLastName("Swanson");
		Address address = new Address();
		address.setHouseNumber("100");
		address.setStreet("State Street");
		address.setCity("Pawnee");
		address.setState("Indiana");
		address.setZipcode("47998");
		user.setAddress(address);
		return user;
	}
}
