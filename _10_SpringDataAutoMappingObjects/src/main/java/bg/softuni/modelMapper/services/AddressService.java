package bg.softuni.modelMapper.services;

import bg.softuni.modelMapper.DTOs.AddressDTO;
import bg.softuni.modelMapper.entities.Address;

public interface AddressService {

    Address create(AddressDTO addressData);
}
