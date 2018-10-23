package ie.flexx.jackanory.tests;

import ie.flexx.jackanory.domain.UserStory;
import ie.flexx.jackanory.domain.UserStoryRequirement;
import ie.flexx.jackanory.manager.UserStoryManager;
import ie.flexx.jackanory.manager.UserStoryRequirementManager;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:database-setup.xml")
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class UserStoryRequirementImplIntegrationTest {

    @Resource(name = "userStoryManager")
    private UserStoryManager userStoryManager;

    @Resource(name = "userStoryRequirementManager")
    private UserStoryRequirementManager userStoryRequirementManager;

    private String requirement = "requirement";
    private String updateRequirement = "updateRequirement";

    @Test
    public void testDefaultInitialiseUserStoryRequirement() {
        UserStoryRequirement userStoryRequirement = userStoryRequirementManager.initialiseUserStoryRequirement();
        Assert.assertNotNull(userStoryRequirement);
    }

    @Test
    public void testInitialiseUserStoryRequirement() {
        UserStory userStory = userStoryManager.initialiseUserStory(
                "name", "description", "category", "notes"
        );
        Assert.assertNotNull(userStory);
        userStory = userStoryManager.createUserStory(userStory);

        // Initialise object and check the response is not null
        UserStoryRequirement userStoryRequirement = userStoryRequirementManager.initialiseUserStoryRequirement(
                requirement, userStory
        );
        Assert.assertNotNull(userStoryRequirement);
    }


    @Test
    public void testCreateUserStoryRequirement() {
        UserStory userStory = userStoryManager.initialiseUserStory(
                "name", "description", "category", "notes"
        );
        Assert.assertNotNull(userStory);
        userStory = userStoryManager.createUserStory(userStory);

        // Initialise object and check the response is not null
        UserStoryRequirement userStoryRequirement = userStoryRequirementManager.initialiseUserStoryRequirement(
                requirement, userStory
        );
        Assert.assertNotNull(userStoryRequirement);

        // Add the object to the or one of the parent(s) which have reverse relationships
        userStory.addUserStoryRequirement(userStoryRequirement);

        // Save the or one of the parent(s) to the database
        userStoryManager.updateUserStory(userStory);

        // Re-retrieve the or one of the parent(s) from the database and check if null
        userStory = userStoryManager.getUserStory(userStory.getId());
        Assert.assertNotNull(userStory);

        // Retrieve the test object from one of the parents
        userStoryRequirement = userStory.getUserStoryRequirementList().iterator().next();
        Long id = userStoryRequirement.getId();
        Assert.assertNotNull(id);

        // Retrieve the object from the database using its id
        UserStoryRequirement retrievedUserStoryRequirement = userStoryRequirementManager.getUserStoryRequirement(id);
        Assert.assertNotNull(retrievedUserStoryRequirement);

    }

    @Test
    public void testGetUserStoryRequirementList() {
        List<UserStoryRequirement> userStoryRequirementList;

        // Check the list is empty
        userStoryRequirementList = userStoryRequirementManager.getUserStoryRequirementList();
        Assert.assertTrue(userStoryRequirementList.isEmpty());

        UserStory userStory = userStoryManager.initialiseUserStory(
                "name", "description", "category", "notes"
        );
        Assert.assertNotNull(userStory);
        userStory = userStoryManager.createUserStory(userStory);

        UserStory updateUserStory = userStoryManager.initialiseUserStory(
                "updateName", "updateDescription", "updateCategory", "updateNotes"
        );
        Assert.assertNotNull(updateUserStory);
        updateUserStory = userStoryManager.createUserStory(updateUserStory);

        // Initialise object and check the response is not null
        UserStoryRequirement userStoryRequirement = userStoryRequirementManager.initialiseUserStoryRequirement(
                requirement, userStory
        );
        Assert.assertNotNull(userStoryRequirement);
        // Initialise update object and check the response is not null
        UserStoryRequirement updateUserStoryRequirement = userStoryRequirementManager.initialiseUserStoryRequirement(
                updateRequirement, updateUserStory
        );
        Assert.assertNotNull(updateUserStoryRequirement);

        // Add the object to the or one of the parent(s) which have reverse relationships
        userStory.addUserStoryRequirement(userStoryRequirement);
        updateUserStory.addUserStoryRequirement(updateUserStoryRequirement);

        // Save the or one of the parent(s) to the database
        userStoryManager.updateUserStory(userStory);

        // Check the list contains two objects
        userStoryRequirementList = userStoryRequirementManager.getUserStoryRequirementList();
        Assert.assertEquals(2, userStoryRequirementList.size());
    }

    @Test
    public void testUpdateUserStoryRequirement() {
        UserStory userStory = userStoryManager.initialiseUserStory(
                "name", "description", "category", "updateNotes"
        );
        Assert.assertNotNull(userStory);
        userStory = userStoryManager.createUserStory(userStory);

        // Initialise object and check the response is not null
        UserStoryRequirement userStoryRequirement = userStoryRequirementManager.initialiseUserStoryRequirement(
                requirement, userStory
        );
        Assert.assertNotNull(userStoryRequirement);

        // Add the object to the or one of the parent(s) which have reverse relationships
        userStory.addUserStoryRequirement(userStoryRequirement);

        // Save the or one of the parent(s) to the database
        userStoryManager.updateUserStory(userStory);

        // Re-retrieve the or one of the parent(s) from the database and check if null
        userStory = userStoryManager.getUserStory(userStory.getId());
        Assert.assertNotNull(userStory);

        // Retrieve the test object from one of the parents
        userStoryRequirement = userStory.getUserStoryRequirementList().iterator().next();
        Long id = userStoryRequirement.getId();
        Assert.assertNotNull(id);

        // Retrieve the object from the database using its id
        UserStoryRequirement retrievedUserStoryRequirement = userStoryRequirementManager.getUserStoryRequirement(id);
        Assert.assertNotNull(retrievedUserStoryRequirement);

        // Update the object
        userStoryRequirement.setRequirement(updateRequirement);
        userStoryRequirementManager.updateUserStoryRequirement(userStoryRequirement);

        // Re-Retrieve the object from the database and check its values
        userStoryRequirement = userStoryRequirementManager.getUserStoryRequirement(id);

        userStoryRequirement.setRequirement(updateRequirement);
        Assert.assertEquals(updateRequirement, userStoryRequirement.getRequirement());
    }

    @Test
    public void testDeleteUserStoryRequirement() {
        UserStory userStory = userStoryManager.initialiseUserStory(
                "name", "description", "category", "notes"
        );
        Assert.assertNotNull(userStory);
        userStory = userStoryManager.createUserStory(userStory);

        UserStory updateUserStory = userStoryManager.initialiseUserStory(
                "updateName", "updateDescription", "updateCategory", "updateNotes"
        );
        Assert.assertNotNull(updateUserStory);
        updateUserStory = userStoryManager.createUserStory(updateUserStory);

        // Initialise object and check the response is not null
        UserStoryRequirement userStoryRequirement = userStoryRequirementManager.initialiseUserStoryRequirement(
                requirement, userStory
        );
        Assert.assertNotNull(userStoryRequirement);
        // Initialise update object and check the response is not null
        UserStoryRequirement updateUserStoryRequirement = userStoryRequirementManager.initialiseUserStoryRequirement(
                updateRequirement, updateUserStory
        );
        Assert.assertNotNull(updateUserStoryRequirement);

        // Add the object to the or one of the parent(s) which have reverse relationships
        userStory.addUserStoryRequirement(userStoryRequirement);
        updateUserStory.addUserStoryRequirement(updateUserStoryRequirement);

        // Save the or one of the parent(s) to the database
        userStoryManager.updateUserStory(userStory);


        // Check the list contains two objects
        List<UserStoryRequirement> userStoryRequirementList = userStoryRequirementManager.getUserStoryRequirementList();
        Assert.assertEquals(2, userStoryRequirementList.size());

        // Delete the objects from the database
        for (UserStoryRequirement tempUserStoryRequirement : userStoryRequirementList) {
            userStoryRequirementManager.deleteUserStoryRequirement(tempUserStoryRequirement);
        }

        // Check the list is empty
        userStoryRequirementList = userStoryRequirementManager.getUserStoryRequirementList();
        Assert.assertTrue(userStoryRequirementList.isEmpty());
    }
}