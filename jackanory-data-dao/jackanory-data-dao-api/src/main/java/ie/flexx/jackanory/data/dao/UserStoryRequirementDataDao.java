package ie.flexx.jackanory.data.dao;

import ie.flexx.jackanory.data.UserStoryRequirementData;

import java.util.List;

public interface UserStoryRequirementDataDao {
    public UserStoryRequirementData createUserStoryRequirementData(UserStoryRequirementData userStoryRequirementData);

    public UserStoryRequirementData readUserStoryRequirementData(Long id);

    public List<UserStoryRequirementData> readUserStoryRequirementDataList();

    public UserStoryRequirementData updateUserStoryRequirementData(UserStoryRequirementData userStoryRequirementData);

    public void deleteUserStoryRequirementData(UserStoryRequirementData userStoryRequirementData);
}
