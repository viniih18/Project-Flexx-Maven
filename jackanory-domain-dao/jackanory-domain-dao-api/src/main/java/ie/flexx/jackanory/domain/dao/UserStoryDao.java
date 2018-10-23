package ie.flexx.jackanory.domain.dao;

import ie.flexx.jackanory.domain.UserStory;

import java.util.List;

public interface UserStoryDao {
    public UserStory createUserStory(UserStory userStory);

    public UserStory readUserStory(Long id);

    public List<UserStory> readUserStoryList();

    public UserStory updateUserStory(UserStory userStory);

    public void deleteUserStory(UserStory userStory);
}
