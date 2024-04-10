package com.aracely.jacinto.expenses.controller;

import com.aracely.jacinto.expenses.models.Address;
import com.aracely.jacinto.expenses.models.Person;
import com.aracely.jacinto.expenses.repository.AddressRepository;
import com.aracely.jacinto.expenses.repository.PersonRepository;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class AddressController {
  private final AddressRepository addressRepository;
  private final PersonRepository personRepository;

  public AddressController(AddressRepository addressRepository, PersonRepository personRepository) {
    this.addressRepository = addressRepository;
    this.personRepository = personRepository;
  }

  @GetMapping("/address/{userId}")
  public ResponseEntity<Address> getPersonAddress(
      @PathVariable(name = "userId") int userId
  ) {
    return personRepository.findById(userId)
        .map(person -> ResponseEntity.ok().body(person.getAddress()))
        .orElse(ResponseEntity.notFound().build());
  }

  @PostMapping("/address/{userId}")
  public ResponseEntity<Address> saveAddress(
      @PathVariable(name = "userId") int userId,
      @RequestBody Address address
  ) {
    return personRepository.findById(userId)
        .map(person -> {
          addressRepository.save(address);
          person.setAddress(address);
          personRepository.save(person);
          return ResponseEntity.ok().body(address);
        })
        .orElse(ResponseEntity.notFound().build());
  }

  @PutMapping("address/{userId}")
  public ResponseEntity<Address> updateAddress(
      @PathVariable(name = "userId") int userId,
      @RequestBody Address newAddress
  ) {
    return personRepository.findById(userId)
        .map(person -> {
          Address currentAddress = person.getAddress();
          if (currentAddress != null) {
            currentAddress.setStreet(newAddress.getStreet());
            currentAddress.setExtNumber(newAddress.getExtNumber());
            currentAddress.setPostalCode(newAddress.getPostalCode());
            currentAddress.setState(newAddress.getState());
            currentAddress.setCountry(newAddress.getCountry());
            addressRepository.save(currentAddress);
            return ResponseEntity.ok().body(currentAddress);
          } else {
            // If person does not have an existing address, save the new address
            addressRepository.save(newAddress);
            person.setAddress(newAddress);
            personRepository.save(person);
            return ResponseEntity.ok().body(newAddress);
          }
        })
        .orElse(ResponseEntity.notFound().build());
  }
}
