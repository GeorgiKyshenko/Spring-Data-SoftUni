package bg.softuni.modelMapper.services;

import bg.softuni.modelMapper.DTOs.addresses.AddressDTO;
import bg.softuni.modelMapper.DTOs.addresses.CreateAddressDTO;
import bg.softuni.modelMapper.entities.Address;
import bg.softuni.modelMapper.repositories.AddressRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;

    private final ModelMapper mapper;

    @Autowired
    public AddressServiceImpl(AddressRepository addressRepository, ModelMapper mapper) {
        this.addressRepository = addressRepository;
        this.mapper = mapper;
    }

    @Override
    public AddressDTO create(CreateAddressDTO addressData) {

        Address address = mapper.map(addressData, Address.class);

        addressRepository.save(address);

        return mapper.map(address, AddressDTO.class);
    }
}
