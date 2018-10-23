package ie.flexx.jackanory.data.dao;

import ie.flexx.jackanory.data.UserStoryRequirementData;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.transaction.Transactional;
import java.util.List;

@Transactional(Transactional.TxType.MANDATORY)
public class UserStoryRequirementDataDaoImpl implements UserStoryRequirementDataDao {
    @PersistenceContext(unitName = "persistence-domain")
    private EntityManager entityManager;

    public UserStoryRequirementDataDaoImpl() {
    }

    @Override
    public UserStoryRequirementData createUserStoryRequirementData(UserStoryRequirementData userStoryRequirementData) {
        getEntityManager().persist(userStoryRequirementData);
        return userStoryRequirementData;
    }

    @Override
    public UserStoryRequirementData readUserStoryRequirementData(Long id) {
        return getEntityManager().find(UserStoryRequirementData.class, id);
    }

    @Override
    public List<UserStoryRequirementData> readUserStoryRequirementDataList() {
        CriteriaBuilder criteriaBuilder = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<UserStoryRequirementData> criteria = criteriaBuilder.createQuery(UserStoryRequirementData.class);
        criteria = criteria.select(criteria.from(UserStoryRequirementData.class));
        return getEntityManager().createQuery(criteria).getResultList();
    }

    @Override
    public UserStoryRequirementData updateUserStoryRequirementData(UserStoryRequirementData userStoryRequirementData) {
        userStoryRequirementData = getEntityManager().merge(userStoryRequirementData);
        getEntityManager().persist(userStoryRequirementData);
        return userStoryRequirementData;
    }

    @Override
    public void deleteUserStoryRequirementData(UserStoryRequirementData userStoryRequirementData) {
        userStoryRequirementData = getEntityManager().merge(userStoryRequirementData);

        if (userStoryRequirementData.getUserStoryData() != null) userStoryRequirementData.getUserStoryData().removeUserStoryRequirementData(userStoryRequirementData);
        getEntityManager().remove(userStoryRequirementData);
    }

    protected EntityManager getEntityManager() {
        return entityManager;
    }

    protected void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
