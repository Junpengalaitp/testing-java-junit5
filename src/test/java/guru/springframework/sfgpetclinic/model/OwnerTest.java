package guru.springframework.sfgpetclinic.model;

import guru.springframework.sfgpetclinic.ModelTests;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class OwnerTest implements ModelTests {

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

    @DisplayName("Value Source Test ")
    @ParameterizedTest(name = "{displayName} - [{index} {arguments}]")
    @ValueSource(strings = {"Spring", "Framework", "Guru"})
    void testValueSource(String val) {
        System.out.println(val);
    }

    @DisplayName("Enum Source Test ")
    @ParameterizedTest(name = "{displayName} - [{index} {arguments}]")
    @EnumSource(OwnerType.class)
    void enumTest(OwnerType ownerType) {
        System.out.println(ownerType);
    }
}