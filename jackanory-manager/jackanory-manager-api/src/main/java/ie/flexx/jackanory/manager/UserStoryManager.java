package ie.flexx.jackanory.manager;

import ie.flexx.jackanory.domain.UserStory;

import java.util.List;

public interface UserStoryManager {

    /**
     * Initialise A User Story
     *
     * @return A User Story
     */
    public UserStory initialiseUserStory();

    /**
     * Initialise A User Story
     *
     * @param name        The Name of the User Story
     * @param description The Description of the User Story
     * @param category    The Category of the User Story
     * @return A User Story
     * @throws IllegalArgumentException If any of the input parameters are null
     */
    public UserStory initialiseUserStory(
            String name,
            String description,
            String category,
            String notes
    );

    public UserStory createUserStory(UserStory userStory);

    public UserStory getUserStory(Long id);

    public List<UserStory> getUserStoryList();

    public UserStory updateUserStory(UserStory userStory);

    public void deleteUserStory(UserStory userStory);

}
