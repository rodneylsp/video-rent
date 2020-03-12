package com.videorent.business.service.validation;

import com.videorent.business.model.Cliente;
import com.videorent.exception.BusinessException;

public class ClienteNomeInvalido implements Validation<Cliente> {

    private static final int MIN_CARACTERES = 20;

    @Override
    public void validate(Cliente entity) throws BusinessException {
        if(entity.getNome().length() < MIN_CARACTERES){
            throw new BusinessException("Nome com menos de 20 caracteres");
        }
    }

}
