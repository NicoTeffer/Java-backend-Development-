package io.everyonecodes.phone_book;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class ContactServiceTest {

    @Autowired
    ContactService contactService;

    @MockBean
    AddressRepository addressRepository;

    @MockBean
    ContactRepository contactRepository;

    @Test
    void postContact() {
        Address address = new Address("TestStreet 12", "2700");
        Contact contact = new Contact("TestName", address);

        Mockito.when(addressRepository.findByStreet(address.getStreet())).thenReturn(Optional.of(address));
        Mockito.when(contactRepository.save(contact)).thenReturn(contact);

        contactService.postContact(contact);

        Mockito.verify(addressRepository).findByStreet(address.getStreet());
        Mockito.verify(addressRepository).save(address);
        Mockito.verify(contactRepository).save(contact);
    }
}