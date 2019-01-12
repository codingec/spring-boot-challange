package com.andres_silva.demo.controllers;

import com.andres_silva.demo.domain.Client;
import com.andres_silva.demo.forms.ItemForm;
import com.andres_silva.demo.forms.ClienteForm;
import com.andres_silva.demo.converters.ItemToItemForm;
import com.andres_silva.demo.converters.ClientToClientForm;
import com.andres_silva.demo.domain.Item;
import com.andres_silva.demo.services.ItemService;
import com.andres_silva.demo.services.ClientService;
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
    private ClientService clientService;
    private ItemToItemForm itemToItemForm;
    private ClientToClientForm clientToClientForm;

    @Autowired
    public void setItemToItemForm(ItemToItemForm itemToItemForm) {
        this.itemToItemForm = itemToItemForm;
    }

    @Autowired
    public void setItemService(ItemService itemService) {
        this.itemService = itemService;
    }

    @Autowired
    public void setClientToClientForm(ClientToClientForm clientToClientForm) {
        this.clientToClientForm = clientToClientForm;
    }


    @Autowired
    public void setClientService(ClientService clientService) {
        this.clientService = clientService;
    }



    @RequestMapping("/")
    @Scope("session")
    public String redirToList(){
        return "redirect:/product/list";
    }

    @RequestMapping({"/product/list", "/product"})
    public String listItem(Model model){
        model.addAttribute("items", itemService.listAll());
        model.addAttribute("clients", clientService.listAll());
        return "list";
    }

    @RequestMapping("/product/show/{id}")
    public String getItem(@PathVariable String id, Model model){
        model.addAttribute("item", itemService.getById(Long.valueOf(id)));
        return "show";
    }

    @RequestMapping("product/edit/{id}/{ids}")
    @Scope("session")
    public String edit(@PathVariable String id, @PathVariable String ids, Model model){
        Item item = itemService.getById(Long.valueOf(id));
        ItemForm itemForm = itemToItemForm.convert(item);
        Client client = clientService.getById(Long.valueOf(ids));
        ClienteForm clientForm = clientToClientForm.convert(client);
        model.addAttribute("itemForm", itemForm);
        model.addAttribute("clientForm", clientForm);
        return "editForm";
    }

    @RequestMapping("/product/new")
    public String newItem(Model model){
        model.addAttribute("itemForm", new ItemForm());
        model.addAttribute("clientForm", new ClienteForm());
        return "createForm";
    }

    @RequestMapping(value = "/product", method = RequestMethod.POST)
    public String saveOrUpdateItem(@Valid ItemForm itemForm,ClienteForm clienteForm, BindingResult bindingResult){

        if(bindingResult.hasErrors()){ return "productform"; }
        Client savedClient = clientService.saveOrUpdateClientForm(clienteForm);
        itemForm.setClient(savedClient);
        Item savedItem = itemService.saveOrUpdateItemForm(itemForm);
        return "redirect:/product/show/" + savedItem.getId_item();
    }

    @RequestMapping("/product/delete/{id}")
    public String delete(@PathVariable String id){
        itemService.delete(Long.valueOf(id));
        return "redirect:/product/list";
    }
}
