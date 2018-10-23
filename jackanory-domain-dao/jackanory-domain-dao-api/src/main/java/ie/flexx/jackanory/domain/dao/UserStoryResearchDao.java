package ie.flexx.jackanory.domain.dao;

import ie.flexx.jackanory.domain.UserStoryResearch;

import java.util.List;

public interface UserStoryResearchDao {
    public UserStoryResearch createUserStoryResearch(UserStoryResearch userStoryResearch);

    public UserStoryResearch readUserStoryResearch(Long id);

    public List<UserStoryResearch> readUserStoryResearchList();

    public UserStoryResearch updateUserStoryResearch(UserStoryResearch userStoryResearch);

    public void deleteUserStoryResearch(UserStoryResearch userStoryResearch);
}
