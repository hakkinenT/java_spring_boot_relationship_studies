package com.example.jpastudies.repositories;

import com.example.jpastudies.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
