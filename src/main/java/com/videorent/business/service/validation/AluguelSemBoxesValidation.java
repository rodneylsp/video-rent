package com.videorent.business.service.validation;

import com.videorent.business.model.Aluguel;
import com.videorent.exception.BusinessException;

import java.util.Objects;

public class AluguelSemBoxesValidation implements Validation<Aluguel> {

    @Override
    public void validate(Aluguel entity) throws BusinessException {
        if(Objects.isNull(entity.getBoxes()) || entity.getBoxes().isEmpty()){
            throw new BusinessException("Aluguel nao possui filmes.");
        }
    }

}
