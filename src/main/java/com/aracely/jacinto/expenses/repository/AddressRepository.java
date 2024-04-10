package com.aracely.jacinto.expenses.repository;

import com.aracely.jacinto.expenses.models.Address;
import com.aracely.jacinto.expenses.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> { }
