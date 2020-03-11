package com.videorent.business.service.validation;

import com.videorent.business.model.Aluguel;
import com.videorent.exception.BusinessException;

import java.util.Objects;


public class AluguelSemClienteValidation implements Validation<Aluguel> {

    @Override
    public void validate(Aluguel entity) throws BusinessException {
        if(Objects.isNull(entity.getCliente())){
            throw new BusinessException("Deve associar um cliente ao aluguel.");
        }
    }
}
