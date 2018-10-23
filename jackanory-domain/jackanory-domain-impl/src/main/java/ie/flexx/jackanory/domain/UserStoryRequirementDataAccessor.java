package ie.flexx.jackanory.domain;

import ie.flexx.jackanory.data.UserStoryRequirementData;

public class UserStoryRequirementDataAccessor {
    public static UserStoryRequirementData getUserStoryRequirementData(UserStoryRequirement userStoryRequirement) {
        return ((UserStoryRequirementImpl) userStoryRequirement).getUserStoryRequirementData();
    }
}
