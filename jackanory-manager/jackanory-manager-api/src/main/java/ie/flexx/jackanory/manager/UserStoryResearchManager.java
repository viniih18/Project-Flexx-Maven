package ie.flexx.jackanory.manager;

import ie.flexx.jackanory.domain.UserStory;
import ie.flexx.jackanory.domain.UserStoryResearch;

import java.util.List;

public interface UserStoryResearchManager {

    /**
     * Initialise A User Story Research
     *
     * @return A User Story Research
     */
    public UserStoryResearch initialiseUserStoryResearch();

    /**
     * Initialise A User Story Research
     *
     * @param research  A Description of the research peformed
     * @param userStory A User Story
     * @return A User Story Research
     * @throws IllegalArgumentException If any of the input parameters are null
     */
    public UserStoryResearch initialiseUserStoryResearch(
            String research,
            UserStory userStory
    );

    public UserStoryResearch createUserStoryResearch(UserStoryResearch userStoryResearch);

    public UserStoryResearch getUserStoryResearch(Long id);

    public List<UserStoryResearch> getUserStoryResearchList();

    public UserStoryResearch updateUserStoryResearch(UserStoryResearch userStoryResearch);

    public void deleteUserStoryResearch(UserStoryResearch userStoryResearch);

}
