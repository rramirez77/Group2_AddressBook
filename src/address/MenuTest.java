package address;

import address.data.addressEntry;
import org.junit.jupiter.api.Test;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class MenuTest {
    Scanner myObj = new Scanner(System.in);

    @Test
    void prompt_FirstName() {
        addressEntry entry = new addressEntry();
        System.out.print("First Name: ");
        entry.setFirstName("Roman0");
        assertEquals("Romano", entry.getFirstName());
    }

    @Test
    void prompt_LastName() {
        addressEntry entry = new addressEntry();
        System.out.print("Last Name: ");
        entry.setLastName("Ram1rez");
        assertEquals("Ramirez", entry.getLastName());
    }

    @Test
    void prompt_Street() {
        addressEntry entry = new addressEntry();
        System.out.print("Street: ");
        entry.setStreet("#123 ABC St");
        assertEquals("123 ABC St", entry.getStreet());
    }

    @Test
    void prompt_City() {
        addressEntry entry = new addressEntry();
        System.out.print("City: ");
        entry.setCity("Richmond5#");
        assertEquals("Richmond", entry.getCity());
    }

    @Test
    void prompt_State() {
        addressEntry entry = new addressEntry();
        System.out.print("State: ");
        entry.setState("California");
        assertEquals("CA", entry.getState());
    }

    @Test
    void prompt_Zip() {
        addressEntry entry = new addressEntry();
        System.out.print("Zip: ");
        entry.setZip(12345);
        assertEquals(12345, entry.getZip());
    }

    @Test
    void prompt_Telephone() {
        addressEntry entry = new addressEntry();
        System.out.print("Telephone: ");
        entry.setPhone("555-861-9990");
        assertEquals("5558619990", entry.getPhone());
    }

    @Test
    void prompt_Email() {
        addressEntry entry = new addressEntry();
        System.out.print("Email: ");
        entry.setEmail("bgmpengu54@gmail.com");
        assertEquals("bgmpengu54@gmail.com", entry.getEmail());
    }
}