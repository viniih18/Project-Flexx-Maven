package ie.flexx.jackanory.domain.dao;

import ie.flexx.jackanory.data.UserStoryResearchData;
import ie.flexx.jackanory.data.dao.UserStoryResearchDataDao;
import ie.flexx.jackanory.domain.UserStoryResearch;
import ie.flexx.jackanory.domain.UserStoryResearchDataAccessor;
import ie.flexx.jackanory.domain.UserStoryResearchImpl;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Transactional(Transactional.TxType.MANDATORY)
public class UserStoryResearchDaoImpl implements UserStoryResearchDao {
    private UserStoryResearchDataDao userStoryResearchDataDao;

    public UserStoryResearchDaoImpl(UserStoryResearchDataDao userStoryResearchDataDao) {
        this.userStoryResearchDataDao = userStoryResearchDataDao;
    }

    @Override
    public UserStoryResearch createUserStoryResearch(UserStoryResearch userStoryResearch) {
        getUserStoryResearchDataDao().createUserStoryResearchData(UserStoryResearchDataAccessor.getUserStoryResearchData(userStoryResearch));
        return userStoryResearch;
    }

    @Override
    public UserStoryResearch readUserStoryResearch(Long id) {
        return new UserStoryResearchImpl(getUserStoryResearchDataDao().readUserStoryResearchData(id));
    }

    @Override
    public List<UserStoryResearch> readUserStoryResearchList() {
        List<UserStoryResearch> results = new ArrayList<>();
        for (UserStoryResearchData userStoryResearchData : getUserStoryResearchDataDao().readUserStoryResearchDataList()) {
            results.add(new UserStoryResearchImpl(userStoryResearchData));
        }
        return results;
    }

    @Override
    public UserStoryResearch updateUserStoryResearch(UserStoryResearch userStoryResearch) {
        getUserStoryResearchDataDao().updateUserStoryResearchData(UserStoryResearchDataAccessor.getUserStoryResearchData(userStoryResearch));
        return userStoryResearch;
    }

    @Override
    public void deleteUserStoryResearch(UserStoryResearch userStoryResearch) {
        getUserStoryResearchDataDao().deleteUserStoryResearchData(UserStoryResearchDataAccessor.getUserStoryResearchData(userStoryResearch));
    }

    protected UserStoryResearchDataDao getUserStoryResearchDataDao() {
        return userStoryResearchDataDao;
    }
}
