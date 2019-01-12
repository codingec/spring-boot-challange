package com.andres_silva.demo.services;

import com.andres_silva.demo.domain.Client;
import com.andres_silva.demo.forms.ItemForm;
import com.andres_silva.demo.domain.Item;

import java.util.List;


public interface ItemService {

    List<Item> listAll();

    Item getById(Long id);

    Item saveOrUpdate(Item item);

    void delete(Long id);

    Item saveOrUpdateItemForm(ItemForm itemForm);
}
