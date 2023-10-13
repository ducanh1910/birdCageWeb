package service.impl;

import model.Address;
import repository.AddressRepository;
import service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepository;
    @Override
    public List<Address> findAll(){return addressRepository.findAll();}
}
