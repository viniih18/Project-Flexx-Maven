package ie.flexx.jackanory.manager;

import ie.flexx.jackanory.domain.UserStory;
import ie.flexx.jackanory.domain.UserStoryDataAccessor;
import ie.flexx.jackanory.domain.UserStoryResearch;
import ie.flexx.jackanory.domain.UserStoryResearchImpl;
import ie.flexx.jackanory.domain.dao.UserStoryResearchDao;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class UserStoryResearchManagerImpl implements UserStoryResearchManager {

    private UserStoryResearchDao userStoryResearchDao;

    public UserStoryResearchManagerImpl(UserStoryResearchDao userStoryResearchDao) {
        this.userStoryResearchDao = userStoryResearchDao;
    }

    @Override
    public UserStoryResearch initialiseUserStoryResearch() {
        //Correction Vinicius Meireles
        //return null;
        return new UserStoryResearchImpl();
    }

    @Override
    public UserStoryResearch initialiseUserStoryResearch(
            String research,
            UserStory userStory
    ) {
        if (research == null) throw new IllegalArgumentException("research should not be null");
        if (userStory == null) throw new IllegalArgumentException("userStory should not be null");

        UserStoryResearchImpl userStoryResearch = new UserStoryResearchImpl();
        userStoryResearch.setResearch(research);
        userStoryResearch.getUserStoryResearchData().setUserStoryData(UserStoryDataAccessor.getUserStoryData(userStory));
        return userStoryResearch;
    }

    @Override
    public UserStoryResearch createUserStoryResearch(UserStoryResearch userStoryResearch) {
        return getUserStoryResearchDao().createUserStoryResearch(userStoryResearch);
    }

    @Override
    public UserStoryResearch getUserStoryResearch(Long id) {
        return getUserStoryResearchDao().readUserStoryResearch(id);
    }

    @Override
    public List<UserStoryResearch> getUserStoryResearchList() {
        return getUserStoryResearchDao().readUserStoryResearchList();
    }

    @Override
    public UserStoryResearch updateUserStoryResearch(UserStoryResearch userStoryResearch) {
        return getUserStoryResearchDao().updateUserStoryResearch(userStoryResearch);
    }

    @Override
    public void deleteUserStoryResearch(UserStoryResearch userStoryResearch) {
        getUserStoryResearchDao().deleteUserStoryResearch(userStoryResearch);
    }

    protected UserStoryResearchDao getUserStoryResearchDao() {
        return userStoryResearchDao;
    }

}
