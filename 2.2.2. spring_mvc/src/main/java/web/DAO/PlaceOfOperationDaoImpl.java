package web.DAO;


import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class PlaceOfOperationDaoImpl implements PlaceOfOperationDao{

    @PersistenceContext
    private EntityManager entityManager;

}
