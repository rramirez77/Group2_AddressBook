package address.data;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class addressEntryTest {

    @Test
    void testToString() {
        addressEntry entry1;
        entry1 = new addressEntry("Romano", "Ramirez", "123 ABC Street", "Richmond", "CA",
                94806, "123456789", "rramirez77@horizon.csueastbay.edu");

        assertEquals(entry1.toString(), entry1.toString());
    }

    @Test
    void setFirstName() {
        addressEntry entry1 = new addressEntry();
        entry1.setFirstName("Romano");
        assertEquals("Romano", entry1.getFirstName());
    }

    @Test
    void setLastName() {
        addressEntry entry1 = new addressEntry();
        entry1.setLastName("Ramirez");
        assertEquals("Ramirez", entry1.getLastName());
    }

    @Test
    void setStreet() {
        addressEntry entry1 = new addressEntry();
        entry1.setStreet("123 ABC Street");
        assertEquals("123 ABC Street", entry1.getStreet());
    }

    @Test
    void setCity() {
        addressEntry entry1 = new addressEntry();
        entry1.setCity("Richmond");
        assertEquals("Richmond", entry1.getCity());
    }

    @Test
    void setState() {
        addressEntry entry1 = new addressEntry();
        entry1.setState("CA");
        assertEquals("CA", entry1.getState());
    }

    @Test
    void setZip() {
        addressEntry entry1 = new addressEntry();
        entry1.setZip(12345);
        assertEquals(12345, entry1.getZip());
    }

    @Test
    void setPhone() {
        addressEntry entry1 = new addressEntry();
        entry1.setPhone("5558619990");
        assertEquals("5558619990", entry1.getPhone());
    }

    @Test
    void setEmail() {
        addressEntry entry1 = new addressEntry();
        entry1.setEmail("bgmpengu54@gmail.com");
        assertEquals("bgmpengu54@gmail.com", entry1.getEmail());
    }
}