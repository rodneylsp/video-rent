package com.videorent.business.service.validation;

import com.videorent.business.model.AbstractEntity;
import com.videorent.exception.BusinessException;

public interface Validation<T extends AbstractEntity> {

    void validate(T entity) throws BusinessException;
}
