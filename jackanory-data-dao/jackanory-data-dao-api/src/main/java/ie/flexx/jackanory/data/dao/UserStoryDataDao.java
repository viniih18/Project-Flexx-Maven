package ie.flexx.jackanory.data.dao;

import ie.flexx.jackanory.data.UserStoryData;

import java.util.List;

public interface UserStoryDataDao {
    public UserStoryData createUserStoryData(UserStoryData userStoryData);

    public UserStoryData readUserStoryData(Long id);

    public List<UserStoryData> readUserStoryDataList();

    public UserStoryData updateUserStoryData(UserStoryData userStoryData);

    public void deleteUserStoryData(UserStoryData userStoryData);
}
