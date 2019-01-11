package com.andres_silva.demo.converters;

import com.andres_silva.demo.domain.Item;
import com.andres_silva.demo.forms.ItemForm;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ItemToItemForm implements Converter<Item, ItemForm> {
    @Override
    public ItemForm convert(Item item) {
        ItemForm itemForm = new ItemForm();
        itemForm.setId_item(item.getId_item());
        itemForm.setItem_description(item.getItem_description());
        itemForm.setPrice(item.getPrice());
        itemForm.setExpiration_date(item.getExpiration_date());
        return itemForm;
    }
}
