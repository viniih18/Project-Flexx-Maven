package ie.flexx.jackanory.tests;

import ie.flexx.jackanory.domain.UserStory;
import ie.flexx.jackanory.domain.UserStoryResearch;
import ie.flexx.jackanory.manager.UserStoryManager;
import ie.flexx.jackanory.manager.UserStoryResearchManager;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;

/**
 * New Class - Test 3
 * Vinicius Meireles
 */
@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:database-setup.xml")
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class UserStoryResearchImplIntegrationTest {

    @Resource(name = "userStoryManager")
    private UserStoryManager userStoryManager;

    @Resource(name = "userStoryResearchManager")
    private UserStoryResearchManager userStoryResearchManager;

    private String research = "research";
    private String updateResearch = "updateResearch";


    @Test
    public void testDefaultInitialiseUserStoryResearch() {
        UserStoryResearch userStoryResearch = userStoryResearchManager.initialiseUserStoryResearch();
        Assert.assertNotNull(userStoryResearch);
    }

    @Test
    public void testInitialiseUserStoryRequirement() {
        UserStory userStory = userStoryManager.initialiseUserStory(
                "name", "description", "category", "notes"
        );
        Assert.assertNotNull(userStory);
        userStory = userStoryManager.createUserStory(userStory);

        // Initialise object and check the response is not null
        UserStoryResearch userStoryResearch = userStoryResearchManager.initialiseUserStoryResearch(
                research, userStory
        );
        Assert.assertNotNull(userStoryResearch);
    }

    @Test
    public void testCreateUserStoryResearch() {
        UserStory userStory = userStoryManager.initialiseUserStory(
                "name", "description", "category", "notes"
        );
        Assert.assertNotNull(userStory);
        userStory = userStoryManager.createUserStory(userStory);

        // Initialise object and check the response is not null
        UserStoryResearch userStoryResearch = userStoryResearchManager.initialiseUserStoryResearch(
                research, userStory
        );
        Assert.assertNotNull(userStoryResearch);

        // Add the object to the or one of the parent(s) which have reverse relationships
        userStory.addUserStoryResearch(userStoryResearch);

        // Save the or one of the parent(s) to the database
        userStoryManager.updateUserStory(userStory);

        // Re-retrieve the or one of the parent(s) from the database and check if null
        userStory = userStoryManager.getUserStory(userStory.getId());
        Assert.assertNotNull(userStory);

        // Retrieve the test object from one of the parents
        userStoryResearch = userStory.getUserStoryResearchSet().iterator().next();
        Long id = userStoryResearch.getId();
        Assert.assertNotNull(id);

        // Retrieve the object from the database using its id
        UserStoryResearch retrievedUserStoryResearch = userStoryResearchManager.getUserStoryResearch(id);
        Assert.assertNotNull(retrievedUserStoryResearch);

    }

    @Test
    public void testGetUserStoryResearchList() {
        List<UserStoryResearch> userStoryResearchList;

        // Check the list is empty
        userStoryResearchList = userStoryResearchManager.getUserStoryResearchList();
        Assert.assertTrue(userStoryResearchList.isEmpty());

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
        UserStoryResearch userStoryResearch = userStoryResearchManager.initialiseUserStoryResearch(
                research, userStory
        );
        Assert.assertNotNull(userStoryResearch);
        // Initialise update object and check the response is not null
        UserStoryResearch updateUserStoryResearch = userStoryResearchManager.initialiseUserStoryResearch(
                updateResearch, updateUserStory
        );
        Assert.assertNotNull(updateUserStoryResearch);

        // Add the object to the or one of the parent(s) which have reverse relationships
        userStory.addUserStoryResearch(userStoryResearch);
        updateUserStory.addUserStoryResearch(updateUserStoryResearch);

        // Save the or one of the parent(s) to the database
        userStoryManager.updateUserStory(userStory);

        // Check the list contains two objects
        userStoryResearchList = userStoryResearchManager.getUserStoryResearchList();
        Assert.assertEquals(2, userStoryResearchList.size());
    }

    @Test
    public void testUpdateUserStoryResearch() {
        UserStory userStory = userStoryManager.initialiseUserStory(
                "name", "description", "category", "updateNotes"
        );
        Assert.assertNotNull(userStory);
        userStory = userStoryManager.createUserStory(userStory);

        // Initialise object and check the response is not null
        UserStoryResearch userStoryResearch = userStoryResearchManager.initialiseUserStoryResearch(
                research, userStory
        );
        Assert.assertNotNull(userStoryResearch);

        // Add the object to the or one of the parent(s) which have reverse relationships
        userStory.addUserStoryResearch(userStoryResearch);

        // Save the or one of the parent(s) to the database
        userStoryManager.updateUserStory(userStory);

        // Re-retrieve the or one of the parent(s) from the database and check if null
        userStory = userStoryManager.getUserStory(userStory.getId());
        Assert.assertNotNull(userStory);

        // Retrieve the test object from one of the parents
        userStoryResearch = userStory.getUserStoryResearchSet().iterator().next();
        Long id = userStoryResearch.getId();
        Assert.assertNotNull(id);

        // Retrieve the object from the database using its id
        UserStoryResearch retrievedUserStoryResearch = userStoryResearchManager.getUserStoryResearch(id);
        Assert.assertNotNull(retrievedUserStoryResearch);

        // Update the object
        userStoryResearch.setResearch(updateResearch);
        userStoryResearchManager.updateUserStoryResearch(userStoryResearch);

        // Re-Retrieve the object from the database and check its values
        userStoryResearch = userStoryResearchManager.getUserStoryResearch(id);

        userStoryResearch.setResearch(updateResearch);
        Assert.assertEquals(updateResearch, userStoryResearch.getResearch());
    }

    @Test
    public void testDeleteUserStoryResearch() {
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
        UserStoryResearch userStoryResearch = userStoryResearchManager.initialiseUserStoryResearch(
                research, userStory
        );
        Assert.assertNotNull(userStoryResearch);
        // Initialise update object and check the response is not null
        UserStoryResearch updateUserStoryResearch = userStoryResearchManager.initialiseUserStoryResearch(
                updateResearch, updateUserStory
        );
        Assert.assertNotNull(updateUserStoryResearch);

        // Add the object to the or one of the parent(s) which have reverse relationships
        userStory.addUserStoryResearch(userStoryResearch);
        updateUserStory.addUserStoryResearch(updateUserStoryResearch);

        // Save the or one of the parent(s) to the database
        userStoryManager.updateUserStory(userStory);


        // Check the list contains two objects
        List<UserStoryResearch> userStoryResearchList = userStoryResearchManager.getUserStoryResearchList();
        Assert.assertEquals(2, userStoryResearchList.size());

        // Delete the objects from the database
        for (UserStoryResearch tempUserStoryResearch : userStoryResearchList) {
            userStoryResearchManager.deleteUserStoryResearch(tempUserStoryResearch);
        }

        // Check the list is empty
        userStoryResearchList = userStoryResearchManager.getUserStoryResearchList();
        Assert.assertTrue(userStoryResearchList.isEmpty());
    }
}
