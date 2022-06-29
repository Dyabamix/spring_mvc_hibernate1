package web.service;

import org.springframework.stereotype.Service;
import web.DAO.PlaceOfOperationDao;


import javax.transaction.Transactional;

@Service
@Transactional
public class ServicePlaceOfOperationImpl implements ServicePlaceOfOperation{

    private PlaceOfOperationDao placeOfOperationDao;

    public ServicePlaceOfOperationImpl(PlaceOfOperationDao placeOfOperationDao) {
        this.placeOfOperationDao = placeOfOperationDao;
    }
}
