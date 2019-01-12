package com.andres_silva.demo.converters;

import com.andres_silva.demo.domain.Client;
import com.andres_silva.demo.forms.ClienteForm;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ClientToClientForm implements Converter<Client, ClienteForm> {
    @Override
    public ClienteForm convert(Client client) {
        ClienteForm clienteForm = new ClienteForm();
        clienteForm.setId_client(client.getId_client());
        clienteForm.setClient_name(client.getClient_name());
        clienteForm.setRegion(client.getRegion());
        return clienteForm;
    }
}
