package com.andres_silva.demo.converters;

import com.andres_silva.demo.domain.Client;
import com.andres_silva.demo.forms.ClienteForm;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;


@Component
public class ClientFormToClient implements Converter<ClienteForm, Client> {

    @Override
    public Client convert(ClienteForm clienteForm) {
        Client client = new Client();
        if (clienteForm.getId_client() != null  && !StringUtils.isEmpty(clienteForm.getId_client())) {
            client.setId_client(new Long(clienteForm.getId_client()));
        }
        client.setClient_name(clienteForm.getClient_name());
        client.setRegion(clienteForm.getRegion());
        return client;
    }

}
