package ie.flexx.jackanory.domain;

import ie.flexx.jackanory.data.UserStoryResearchData;

public class UserStoryResearchDataAccessor {
    public static UserStoryResearchData getUserStoryResearchData(UserStoryResearch userStoryResearch) {
        return ((UserStoryResearchImpl) userStoryResearch).getUserStoryResearchData();
    }
}
