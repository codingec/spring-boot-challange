package com.andres_silva.demo.converters;

import com.andres_silva.demo.domain.Item;
import com.andres_silva.demo.forms.ItemForm;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;



@Component
public class ItemFormToItem implements Converter<ItemForm, Item> {

    @Override
    public Item convert(ItemForm itemForm) {
        Item item = new Item();
        if (itemForm.getId_item() != null  && !StringUtils.isEmpty(itemForm.getId_item())) {
            item.setId_item(new Integer(itemForm.getId_item()));
        }
        item.setItem_description(itemForm.getItem_description());
        item.setClient(itemForm.getClient());
        item.setPrice(itemForm.getPrice());
        item.setExpiration_date(itemForm.getExpiration_date());
        return item;
    }

}
