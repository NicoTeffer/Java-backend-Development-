package io.everyonecodes.phone_book;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PhoneBookEndpointTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @MockBean
    ContactRepository contactRepository;

    @MockBean
    ContactService contactService;

    String url = "/contacts";
    ///contacts/postalcodes/{postalCode}

    @Test
    void postContact() {
        Address address = new Address("TestStreet 12", "2700");
        Contact contact = new Contact("TestName", address);

        testRestTemplate.postForObject(url, contact, Contact.class);

        Mockito.verify(contactService).postContact(contact);
    }

    @Test
    void getContacts() {
        testRestTemplate.getForObject(url, Contact[].class);

        Mockito.verify(contactRepository).findAll();
    }

    @Test
    void getContactsByPostalCode() {
        String postalCode = "2700";

        testRestTemplate.getForObject(url + "/postalcodes/" + postalCode, Contact[].class);

        Mockito.verify(contactRepository).findByAddressPostalCode(postalCode);
    }
}