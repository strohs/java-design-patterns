package patterns.creational.builder;

import java.time.LocalDate;
import java.time.Period;

//The concrete builder for UserWebDTO.
public class UserWebDTOBuilder implements UserDTOBuilder {

    private String firstName;
    private String lastName;
    private String age;
    private String address;
    private UserWebDTO dto;


    @Override
    public UserDTOBuilder withFirstName( String fname ) {
        firstName = fname;
        return this;
    }

    @Override
    public UserDTOBuilder withLastName( String lname ) {
        lastName = lname;
        return this;
    }

    @Override
    public UserDTOBuilder withBirthday( LocalDate date ) {
        Period ageInYears = Period.between( date, LocalDate.now() );
        age = Integer.toString( ageInYears.getYears() );
        return this;
    }

    @Override
    public UserDTOBuilder withAddress( Address address ) {
        this.address = address.getHouseNumber() +
                ", " + address.getStreet() +
                ", " + address.getCity() +
                ", " + address.getState() +
                ", " + address.getZipcode();
        return this;
    }

    private String buildFirstLastName() {
        return firstName + " " + lastName;
    }

    @Override
    public UserDTO build() {
        dto = new UserWebDTO( buildFirstLastName(),  address, age );
        return dto;
    }

    @Override
    /**
     * return whatever we have already built
     */
    public UserDTO getUserDTO() {
        return dto;
    }
}
