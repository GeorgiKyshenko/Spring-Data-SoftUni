package bg.softuni.modelMapper.services;

import bg.softuni.modelMapper.DTOs.addresses.AddressDTO;
import bg.softuni.modelMapper.DTOs.addresses.CreateAddressDTO;
import bg.softuni.modelMapper.entities.Address;

public interface AddressService {

    AddressDTO create(CreateAddressDTO addressData);
}
