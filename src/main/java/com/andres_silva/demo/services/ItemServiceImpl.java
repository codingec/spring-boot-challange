package com.andres_silva.demo.services;

import com.andres_silva.demo.domain.Item;
import com.andres_silva.demo.forms.ItemForm;
import com.andres_silva.demo.converters.ItemFormToItem;
import com.andres_silva.demo.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ItemServiceImpl implements ItemService {

    private ItemRepository itemRepository;
    private ItemFormToItem itemFormToItem;

    @Autowired
    public ItemServiceImpl(ItemRepository itemRepository, ItemFormToItem itemFormToItem) {
        this.itemRepository = itemRepository;
        this.itemFormToItem = itemFormToItem;
    }


    @Override
    public List<Item> listAll() {
        List<Item> items = new ArrayList<>();
        itemRepository.findAll().forEach(items::add); //fun with Java 8
        return items;
    }

    @Override
    public Item getById(Long id) {
        return itemRepository.findById(id).orElse(null);
    }

    @Override
    public Item saveOrUpdate(Item item) {
//        for (String name : item) {

           itemRepository.save(item);
//        }

        return item;
    }

    @Override
    public void delete(Long id) {
        itemRepository.deleteById(id);

    }

    @Override
    public Item saveOrUpdateItemForm(ItemForm itemForm) {
        Item savedItem = saveOrUpdate(itemFormToItem.convert(itemForm));

        System.out.println("Saved Item Id: " + savedItem.getId_item());
        return savedItem;
    }
}
