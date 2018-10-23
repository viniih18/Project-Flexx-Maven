package ie.flexx.jackanory.manager;

import ie.flexx.jackanory.domain.UserStory;
import ie.flexx.jackanory.domain.UserStoryDataAccessor;
import ie.flexx.jackanory.domain.UserStoryRequirement;
import ie.flexx.jackanory.domain.UserStoryRequirementImpl;
import ie.flexx.jackanory.domain.dao.UserStoryRequirementDao;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class UserStoryRequirementManagerImpl implements UserStoryRequirementManager {

    private UserStoryRequirementDao userStoryRequirementDao;

    public UserStoryRequirementManagerImpl(UserStoryRequirementDao userStoryRequirementDao) {
        this.userStoryRequirementDao = userStoryRequirementDao;
    }

    @Override
    public UserStoryRequirement initialiseUserStoryRequirement() {
        return new UserStoryRequirementImpl();
    }

    @Override
    public UserStoryRequirement initialiseUserStoryRequirement(
            String requirement,
            UserStory userStory
    ) {
        if (requirement == null) throw new IllegalArgumentException("requirement should not be null");
        if (userStory == null) throw new IllegalArgumentException("userStory should not be null");

        UserStoryRequirementImpl userStoryRequirement = new UserStoryRequirementImpl();
        userStoryRequirement.setRequirement(requirement);
        userStoryRequirement.getUserStoryRequirementData().setUserStoryData(UserStoryDataAccessor.getUserStoryData(userStory));
        return userStoryRequirement;
    }

    @Override
    public UserStoryRequirement createUserStoryRequirement(UserStoryRequirement userStoryRequirement) {
        return getUserStoryRequirementDao().createUserStoryRequirement(userStoryRequirement);
    }

    @Override
    public UserStoryRequirement getUserStoryRequirement(Long id) {
        return getUserStoryRequirementDao().readUserStoryRequirement(id);
    }

    @Override
    public List<UserStoryRequirement> getUserStoryRequirementList() {
        return getUserStoryRequirementDao().readUserStoryRequirementList();
    }

    @Override
    public UserStoryRequirement updateUserStoryRequirement(UserStoryRequirement userStoryRequirement) {
        return getUserStoryRequirementDao().updateUserStoryRequirement(userStoryRequirement);
    }

    @Override
    public void deleteUserStoryRequirement(UserStoryRequirement userStoryRequirement) {
        getUserStoryRequirementDao().deleteUserStoryRequirement(userStoryRequirement);
    }

    protected UserStoryRequirementDao getUserStoryRequirementDao() {
        return userStoryRequirementDao;
    }

}
