package ie.flexx.jackanory.data.dao;

import ie.flexx.jackanory.data.UserStoryResearchData;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.transaction.Transactional;
import java.util.List;

@Transactional(Transactional.TxType.MANDATORY)
public class UserStoryResearchDataDaoImpl implements UserStoryResearchDataDao {
    @PersistenceContext(unitName = "persistence-domain")
    private EntityManager entityManager;

    public UserStoryResearchDataDaoImpl() {
    }

    @Override
    public UserStoryResearchData createUserStoryResearchData(UserStoryResearchData userStoryResearchData) {
        getEntityManager().persist(userStoryResearchData);
        return userStoryResearchData;
    }

    @Override
    public UserStoryResearchData readUserStoryResearchData(Long id) {
        return getEntityManager().find(UserStoryResearchData.class, id);
    }

    @Override
    public List<UserStoryResearchData> readUserStoryResearchDataList() {
        CriteriaBuilder criteriaBuilder = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<UserStoryResearchData> criteria = criteriaBuilder.createQuery(UserStoryResearchData.class);
        criteria = criteria.select(criteria.from(UserStoryResearchData.class));
        return getEntityManager().createQuery(criteria).getResultList();
    }


    @Override
    public UserStoryResearchData updateUserStoryResearchData(UserStoryResearchData userStoryResearchData) {
        userStoryResearchData = getEntityManager().merge(userStoryResearchData);
        getEntityManager().persist(userStoryResearchData);
        return userStoryResearchData;
    }

    @Override
    public void deleteUserStoryResearchData(UserStoryResearchData userStoryResearchData) {
        userStoryResearchData = getEntityManager().merge(userStoryResearchData);

        if (userStoryResearchData.getUserStoryData() != null) userStoryResearchData.getUserStoryData().removeUserStoryResearchData(userStoryResearchData);
        getEntityManager().remove(userStoryResearchData);
    }


    protected EntityManager getEntityManager() {
        return entityManager;
    }

    protected void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
