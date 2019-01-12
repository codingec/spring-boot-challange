package com.andres_silva.demo.repositories;

import com.andres_silva.demo.domain.Item;
import org.springframework.data.repository.CrudRepository;


public interface ItemRepository extends CrudRepository<Item, Long> {
}
