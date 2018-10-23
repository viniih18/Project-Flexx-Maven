package ie.flexx.jackanory.data.dao;

import ie.flexx.jackanory.data.UserStoryData;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.transaction.Transactional;
import java.util.List;

@Transactional(Transactional.TxType.MANDATORY)
public class UserStoryDataDaoImpl implements UserStoryDataDao {
    @PersistenceContext(unitName = "persistence-domain")
    private EntityManager entityManager;

    public UserStoryDataDaoImpl() {
    }

    @Override
    public UserStoryData createUserStoryData(UserStoryData userStoryData) {
        getEntityManager().persist(userStoryData);
        return userStoryData;
    }

    @Override
    public UserStoryData readUserStoryData(Long id) {
        return getEntityManager().find(UserStoryData.class, id);
    }

    @Override
    public List<UserStoryData> readUserStoryDataList() {
        CriteriaBuilder criteriaBuilder = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<UserStoryData> criteria = criteriaBuilder.createQuery(UserStoryData.class);
        criteria = criteria.select(criteria.from(UserStoryData.class));
        return getEntityManager().createQuery(criteria).getResultList();
    }

    @Override
    public UserStoryData updateUserStoryData(UserStoryData userStoryData) {
        userStoryData = getEntityManager().merge(userStoryData);
        getEntityManager().persist(userStoryData);
        return userStoryData;
    }

    @Override
    public void deleteUserStoryData(UserStoryData userStoryData) {
        userStoryData = getEntityManager().merge(userStoryData);

        getEntityManager().remove(userStoryData);
    }

    protected EntityManager getEntityManager() {
        return entityManager;
    }

    protected void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
