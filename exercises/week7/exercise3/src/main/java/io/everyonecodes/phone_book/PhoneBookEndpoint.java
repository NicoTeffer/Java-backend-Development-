package io.everyonecodes.phone_book;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/")
public class PhoneBookEndpoint {

    private final ContactRepository contactRepository;
    private final ContactService contactService;

    public PhoneBookEndpoint(ContactRepository contactRepository, AddressRepository addressRepository, ContactService contactService) {
        this.contactRepository = contactRepository;
        this.contactService = contactService;
    }

    //TODO: POST a Contact to “/contacts” -> saves a new Contact along with its Address
    // and returns the saved Contact.
    @PostMapping("/contacts")
    Contact postContact(@Valid @RequestBody Contact contact) {
        return contactService.postContact(contact);
    }

    //TODO: GET to “/contacts” -> returns a list of all the saved Contacts.
    @GetMapping("/contacts")
    List<Contact> getContacts() {
        return contactRepository.findAll();
    }

    //TODO: GET to “/contacts/postalcodes/{postalCode}”
    // -> returns a list of all the saved Contacts that match the given postalCode.
    @GetMapping("/contacts/postalcodes/{postalCode}")
    List<Contact> getContactsByPostalCode(@PathVariable String postalCode) {
        return contactRepository.findByAddressPostalCode(postalCode);
    }
}
