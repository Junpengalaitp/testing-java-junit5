package guru.springframework.sfgpetclinic.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OwnerTest {

    @Test
    void dependentAssertions() {
        Owner owner = new Owner(1l, "Joe", "Buck");
        owner.setCity("Key West");
        owner.setTelephone("12321412423");

        assertAll("Properties test",
                () -> assertAll("Person Properties",
                        () -> assertEquals("Joe", owner.getFirstName(), "FirstName Did Not Match"),
                        () -> assertEquals("Buck", owner.getLastName())),

                () -> assertAll("OwnerProperties",
                        () -> assertEquals("Key West", owner.getCity()),
                        () -> assertEquals("12321412423", owner.getTelephone())
                ));
    }
}