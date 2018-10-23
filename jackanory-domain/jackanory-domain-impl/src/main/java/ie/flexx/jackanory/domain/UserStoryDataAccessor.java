package ie.flexx.jackanory.domain;

import ie.flexx.jackanory.data.UserStoryData;

public class UserStoryDataAccessor {
    public static UserStoryData getUserStoryData(UserStory userStory) {
        return ((UserStoryImpl) userStory).getUserStoryData();
    }
}
