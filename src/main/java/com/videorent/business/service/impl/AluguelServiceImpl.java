package com.videorent.business.service.impl;

import com.videorent.business.database.DAO;
import com.videorent.business.model.Aluguel;
import com.videorent.business.service.IAluguelService;
import com.videorent.business.service.validation.AluguelSemBoxesValidation;
import com.videorent.business.service.validation.AluguelSemClienteValidation;
import com.videorent.business.service.validation.Validation;
import com.videorent.exception.BusinessException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AluguelServiceImpl implements IAluguelService {

    private static Logger logger = LogManager.getLogger(AluguelServiceImpl.class);
    private DAO<Aluguel> dao;

    @Inject
    public AluguelServiceImpl(DAO<Aluguel> aluguelDAO){
        logger.debug("Instanciando {}", AluguelServiceImpl.class.getName());
        dao = aluguelDAO;
    }

    public void inserir(Aluguel aluguel) throws BusinessException {

        if(Objects.isNull(aluguel)){
            throw new IllegalArgumentException("Parametro invalido");
        }

        List<Validation<Aluguel>> regrasDeNegocio = new ArrayList<>();
        regrasDeNegocio.add(new AluguelSemBoxesValidation());
        regrasDeNegocio.add(new AluguelSemClienteValidation());

        for(Validation<Aluguel> validacao : regrasDeNegocio){
            validacao.validate(aluguel);
        }
        dao.insert(aluguel);
    }

}
