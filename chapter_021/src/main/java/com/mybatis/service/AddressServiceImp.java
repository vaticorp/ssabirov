package com.mybatis.service;

import com.model.Address;
import com.mybatis.mapper.AddressMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * This class represents service for address.
 * @author Svyatoslav Sabirov.
 * @since 24.11.2018
 * @version 7.
 */
@Service
@Transactional
public class AddressServiceImp implements AddressService {

    @Autowired
    AddressMapper addressMapper;

    @Override
    public List<Address> getAllAddress() {
        return this.addressMapper.getListOfEntities();
    }

    @Override
    public Address getAddressById(Long id) {
        return this.addressMapper.getEntityById(id);
    }

    @Override
    public void removeAddress(Address address) {
        this.addressMapper.removeEntity(address);
    }

    @Override
    public void addAddress(Address address) {
        this.addressMapper.addEntity(address);
    }
}
