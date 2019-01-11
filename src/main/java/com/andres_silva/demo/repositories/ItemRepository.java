package com.andres_silva.demo.repositories;

import com.andres_silva.demo.domain.Item;
import com.andres_silva.demo.domain.Client;
import org.springframework.data.repository.CrudRepository;


public interface ItemRepository extends CrudRepository<Item, Long> {
}
