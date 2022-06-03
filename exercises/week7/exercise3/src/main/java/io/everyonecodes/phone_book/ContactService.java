package io.everyonecodes.phone_book;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ContactService {

    private final AddressRepository addressRepository;
    private final ContactRepository contactRepository;

    public ContactService(AddressRepository addressRepository, ContactRepository contactRepository) {
        this.addressRepository = addressRepository;
        this.contactRepository = contactRepository;
    }

    Contact postContact(Contact contact) {
        Optional<Address> address = Optional.of(contact.getAddress());
        address.ifPresent(addressRepository::save);
        var oAddress = addressRepository.findByStreet(address.get().getStreet());
        Optional<Long> oAddressId = Optional.empty();
        if (oAddress.isPresent()) {
            oAddressId = Optional.ofNullable(oAddress.get().getId());
        }
        oAddressId.ifPresent(contact::setId);
        return contactRepository.save(contact);
    }
}
