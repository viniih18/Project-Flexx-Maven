package ie.flexx.jackanory.domain.dao;

import ie.flexx.jackanory.data.UserStoryData;
import ie.flexx.jackanory.data.dao.UserStoryDataDao;
import ie.flexx.jackanory.domain.UserStory;
import ie.flexx.jackanory.domain.UserStoryDataAccessor;
import ie.flexx.jackanory.domain.UserStoryImpl;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Transactional(Transactional.TxType.MANDATORY)
public class UserStoryDaoImpl implements UserStoryDao {
    private UserStoryDataDao userStoryDataDao;

    public UserStoryDaoImpl(UserStoryDataDao userStoryDataDao) {
        this.userStoryDataDao = userStoryDataDao;
    }

    @Override
    public UserStory createUserStory(UserStory userStory) {
        getUserStoryDataDao().createUserStoryData(UserStoryDataAccessor.getUserStoryData(userStory));
        return userStory;
    }

    @Override
    public UserStory readUserStory(Long id) {
        return new UserStoryImpl(getUserStoryDataDao().readUserStoryData(id));
    }

    @Override
    public List<UserStory> readUserStoryList() {
        List<UserStory> results = new ArrayList<>();
        for (UserStoryData userStoryData : getUserStoryDataDao().readUserStoryDataList()) {
            results.add(new UserStoryImpl(userStoryData));
        }
        return results;
    }

    @Override
    public UserStory updateUserStory(UserStory userStory) {
        getUserStoryDataDao().updateUserStoryData(UserStoryDataAccessor.getUserStoryData(userStory));
        return userStory;
    }

    @Override
    public void deleteUserStory(UserStory userStory) {
        getUserStoryDataDao().deleteUserStoryData(UserStoryDataAccessor.getUserStoryData(userStory));
    }

    protected UserStoryDataDao getUserStoryDataDao() {
        return userStoryDataDao;
    }
}
