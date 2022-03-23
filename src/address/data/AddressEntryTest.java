package address.data;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddressEntryTest {

    @Test
    void testToString() {
        Name name = new Name("Romano", "Ramirez");
        Address address = new Address("123 ABC Street", "Richmond", "CA", 94806);
        AddressEntry entry1 = new AddressEntry(name, address, "5558619990", "bgmpengu54@gmail.com", "1");
        Assertions.assertEquals(entry1.toString(), entry1.toString());
    }

    @Test
    void getId() {
        Name name = new Name("Romano", "Ramirez");
        Address address = new Address("123 ABC Street", "Richmond", "CA", 94806);
        AddressEntry entry1 = new AddressEntry(name, address, "5558619990", "bgmpengu54@gmail.com", "1");
        assertEquals("1", entry1.getId());
    }

    @Test
    void getPhone() {
        Name name = new Name("Romano", "Ramirez");
        Address address = new Address("123 ABC Street", "Richmond", "CA", 94806);
        AddressEntry entry1 = new AddressEntry(name, address, "5558619990", "bgmpengu54@gmail.com", "1");
        assertEquals("5558619990", entry1.getPhone());
    }

    @Test
    void getEmail() {
        Name name = new Name("Romano", "Ramirez");
        Address address = new Address("123 ABC Street", "Richmond", "CA", 94806);
        AddressEntry entry1 = new AddressEntry(name, address, "5558619990", "bgmpengu54@gmail.com", "1");
        assertEquals("bgmpengu54@gmail.com", entry1.getEmail());
    }

    @Test
    void getName() {
        Name name = new Name("Romano", "Ramirez");
        Address address = new Address("123 ABC Street", "Richmond", "CA", 94806);
        AddressEntry entry1 = new AddressEntry(name, address, "5558619990", "bgmpengu54@gmail.com", "1");
        assertEquals(name, entry1.getName());
    }

    @Test
    void getAddress() {
        Name name = new Name("Romano", "Ramirez");
        Address address = new Address("123 ABC Street", "Richmond", "CA", 94806);
        AddressEntry entry1 = new AddressEntry(name, address, "5558619990", "bgmpengu54@gmail.com", "1");
        assertEquals(address, entry1.getAddress());
    }

    @Test
    void setPhone() {
        AddressEntry entry1 = new AddressEntry();
        entry1.setPhone("5558619990");
        Assertions.assertEquals("5558619990", entry1.getPhone());
    }

    @Test
    void setEmail() {
        AddressEntry entry1 = new AddressEntry();
        entry1.setEmail("bgmpengu54@gmail.com");
        Assertions.assertEquals("bgmpengu54@gmail.com", entry1.getEmail());
    }

    @Test
    void setName() {
        Name name = new Name("Romano", "Ramirez");
        AddressEntry entry1 = new AddressEntry();
        entry1.setName(name);
        Assertions.assertEquals(name, entry1.getName());
    }

    @Test
    void setAddress() {
        Address address = new Address("123 ABC Street", "Richmond", "CA", 94806);
        AddressEntry entry1 = new AddressEntry();
        entry1.setAddress(address);
        Assertions.assertEquals(address, entry1.getAddress());
    }
}