package ie.flexx.jackanory.domain.dao;

import ie.flexx.jackanory.data.UserStoryRequirementData;
import ie.flexx.jackanory.data.dao.UserStoryRequirementDataDao;
import ie.flexx.jackanory.domain.UserStoryRequirement;
import ie.flexx.jackanory.domain.UserStoryRequirementDataAccessor;
import ie.flexx.jackanory.domain.UserStoryRequirementImpl;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Transactional(Transactional.TxType.MANDATORY)
public class UserStoryRequirementDaoImpl implements UserStoryRequirementDao {
    private UserStoryRequirementDataDao userStoryRequirementDataDao;

    public UserStoryRequirementDaoImpl(UserStoryRequirementDataDao userStoryRequirementDataDao) {
        this.userStoryRequirementDataDao = userStoryRequirementDataDao;
    }

    @Override
    public UserStoryRequirement createUserStoryRequirement(UserStoryRequirement userStoryRequirement) {
        getUserStoryRequirementDataDao().createUserStoryRequirementData(UserStoryRequirementDataAccessor.getUserStoryRequirementData(userStoryRequirement));
        return userStoryRequirement;
    }
    //Correction Vinicius Meireles
    //@Override
    public UserStoryRequirement readUserStoryRequirement(Long id) {
        return new UserStoryRequirementImpl(getUserStoryRequirementDataDao().readUserStoryRequirementData(id));
    }

    @Override
    public List<UserStoryRequirement> readUserStoryRequirementList() {
        List<UserStoryRequirement> results = new ArrayList<>();
        for (UserStoryRequirementData userStoryRequirementData : getUserStoryRequirementDataDao().readUserStoryRequirementDataList()) {
            results.add(new UserStoryRequirementImpl(userStoryRequirementData));
        }
        return results;
    }

    @Override
    public UserStoryRequirement updateUserStoryRequirement(UserStoryRequirement userStoryRequirement) {
        getUserStoryRequirementDataDao().updateUserStoryRequirementData(UserStoryRequirementDataAccessor.getUserStoryRequirementData(userStoryRequirement));
        return userStoryRequirement;
    }

    @Override
    public void deleteUserStoryRequirement(UserStoryRequirement userStoryRequirement) {
        getUserStoryRequirementDataDao().deleteUserStoryRequirementData(UserStoryRequirementDataAccessor.getUserStoryRequirementData(userStoryRequirement));
    }

    protected UserStoryRequirementDataDao getUserStoryRequirementDataDao() {
        return userStoryRequirementDataDao;
    }
}
