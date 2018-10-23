package ie.flexx.jackanory.manager;

import ie.flexx.jackanory.domain.UserStory;
import ie.flexx.jackanory.domain.UserStoryImpl;
import ie.flexx.jackanory.domain.dao.UserStoryDao;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class UserStoryManagerImpl implements UserStoryManager {

    private UserStoryDao userStoryDao;

    public UserStoryManagerImpl(UserStoryDao userStoryDao) {
        this.userStoryDao = userStoryDao;
    }

    @Override
    public UserStory initialiseUserStory() {
        return new UserStoryImpl();
    }

    @Override
    public UserStory initialiseUserStory(
            String name,
            String description,
            String category,
            String notes
    ) {
        if (name == null) throw new IllegalArgumentException("name should not be null");
        if (description == null) throw new IllegalArgumentException("description should not be null");
        if (category == null) throw new IllegalArgumentException("category should not be null");

        UserStoryImpl userStory = new UserStoryImpl();
        userStory.setName(name);
        userStory.setDescription(description);
        userStory.setCategory(category);
        return userStory;
    }

    @Override
    public UserStory createUserStory(UserStory userStory) {
        return getUserStoryDao().createUserStory(userStory);
    }

    @Override
    public UserStory getUserStory(Long id) {
        return getUserStoryDao().readUserStory(id);
    }

    @Override
    public List<UserStory> getUserStoryList() {
        return getUserStoryDao().readUserStoryList();
    }

    @Override
    public UserStory updateUserStory(UserStory userStory) {
        return getUserStoryDao().updateUserStory(userStory);
    }

    @Override
    public void deleteUserStory(UserStory userStory) {
        getUserStoryDao().deleteUserStory(userStory);
    }

    protected UserStoryDao getUserStoryDao() {
        return userStoryDao;
    }

}
