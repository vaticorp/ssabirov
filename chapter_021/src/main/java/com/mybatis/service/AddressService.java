package com.mybatis.service;

import com.model.Address;
import java.util.List;

/**
 * This class represents service-interface for address.
 * @author Svyatoslav Sabirov.
 * @since 23.11.2018
 * @version 12.
 */
public interface AddressService {
    List<Address> getAllAddress();
    Address getAddressById(Long id);
    void removeAddress(Address address);
    void addAddress(Address address);
}
