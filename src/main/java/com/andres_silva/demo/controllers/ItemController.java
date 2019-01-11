package com.andres_silva.demo.controllers;

import com.andres_silva.demo.forms.ItemForm;
import com.andres_silva.demo.converters.ItemToItemForm;
import com.andres_silva.demo.domain.Item;
import com.andres_silva.demo.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;


@Controller
public class ItemController {
    private ItemService itemService;

    private ItemToItemForm itemToItemForm;

    @Autowired
    public void setItemToItemForm(ItemToItemForm itemToItemForm) {
        this.itemToItemForm = itemToItemForm;
    }

    @Autowired
    public void setItemService(ItemService itemService) {
        this.itemService = itemService;
    }

    @RequestMapping("/")
    @Scope("session")
    public String redirToList(){
        return "redirect:/product/list";
    }

    @RequestMapping({"/product/list", "/product"})
    public String listItem(Model model){
        model.addAttribute("items", itemService.listAll());
        return "list";
    }

    @RequestMapping("/product/show/{id}")
    public String getItem(@PathVariable String id, Model model){
        model.addAttribute("item", itemService.getById(Long.valueOf(id)));
        return "show";
    }

    @RequestMapping("product/edit/{id}")
    @Scope("session")
    public String edit(@PathVariable String id, Model model){
        Item item = itemService.getById(Long.valueOf(id));
        ItemForm itemForm = itemToItemForm.convert(item);

        model.addAttribute("itemForm", itemForm);
        return "productform";
    }

    @RequestMapping("/product/new")
    public String newItem(Model model){
        model.addAttribute("itemForm", new ItemForm());
        return "productform";
    }

    @RequestMapping(value = "/product", method = RequestMethod.POST)
    public String saveOrUpdateItem(@Valid ItemForm itemForm, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return "productform";
        }

        Item savedItem = itemService.saveOrUpdateItemForm(itemForm);

        return "redirect:/product/show/" + savedItem.getId_item();
    }

    @RequestMapping("/product/delete/{id}")
    public String delete(@PathVariable String id){
        itemService.delete(Long.valueOf(id));
        return "redirect:/product/list";
    }
}
