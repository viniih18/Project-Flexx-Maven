package ie.flexx.jackanory.manager;

import ie.flexx.jackanory.domain.UserStory;
import ie.flexx.jackanory.domain.UserStoryRequirement;

import java.util.List;

public interface UserStoryRequirementManager {

    /**
     * Initialise A User Story Requirement
     *
     * @return A User Story Requirement
     */
    public UserStoryRequirement initialiseUserStoryRequirement();

    /**
     * Initialise A User Story Requirement
     *
     * @param requirement The Requirement of the User Story
     * @param userStory   A User Story
     * @return A User Story Requirement
     * @throws IllegalArgumentException If any of the input parameters are null
     */
    public UserStoryRequirement initialiseUserStoryRequirement(
            String requirement,
            UserStory userStory
    );

    public UserStoryRequirement createUserStoryRequirement(UserStoryRequirement userStoryRequirement);

    public UserStoryRequirement getUserStoryRequirement(Long id);

    public List<UserStoryRequirement> getUserStoryRequirementList();

    public UserStoryRequirement updateUserStoryRequirement(UserStoryRequirement userStoryRequirement);

    public void deleteUserStoryRequirement(UserStoryRequirement userStoryRequirement);

}
