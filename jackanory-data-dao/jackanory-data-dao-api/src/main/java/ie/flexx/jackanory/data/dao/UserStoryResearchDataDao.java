package ie.flexx.jackanory.data.dao;

import ie.flexx.jackanory.data.UserStoryResearchData;

import java.util.List;

public interface UserStoryResearchDataDao {
    public UserStoryResearchData createUserStoryResearchData(UserStoryResearchData userStoryResearchData);

    public UserStoryResearchData readUserStoryResearchData(Long id);

    public List<UserStoryResearchData> readUserStoryResearchDataList();

    public UserStoryResearchData updateUserStoryResearchData(UserStoryResearchData userStoryResearchData);

    public void deleteUserStoryResearchData(UserStoryResearchData userStoryResearchData);
}
