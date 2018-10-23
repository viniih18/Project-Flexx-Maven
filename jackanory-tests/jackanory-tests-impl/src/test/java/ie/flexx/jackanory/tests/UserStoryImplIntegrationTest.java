package ie.flexx.jackanory.tests;

import ie.flexx.jackanory.domain.UserStory;
import ie.flexx.jackanory.manager.UserStoryManager;
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
public class UserStoryImplIntegrationTest {

    @Resource(name = "userStoryManager")
    private UserStoryManager userStoryManager;

    private String name = "name";
    private String updateName = "updateName";

    private String description = "description";
    private String updateDescription = "updateDescription";

    private String category = "category";
    private String updateCategory = "updateCategory";
    //Implementation Vinicius Meireles
    private String notes = "notes";
    private String updateNotes = "updateNotes";

    @Test
    public void testDefaultInitialiseUserStory() {
        UserStory userStory = userStoryManager.initialiseUserStory();
        Assert.assertNotNull(userStory);
    }

    @Test
    public void testInitialiseUserStory() {
        // Initialise object and check the response is not null
        UserStory userStory = userStoryManager.initialiseUserStory(
                name, description, category, notes
        );
        Assert.assertNotNull(userStory);
    }


    @Test
    public void testCreateUserStory() {
        // Initialise object and check the response is not null
        UserStory userStory = userStoryManager.initialiseUserStory(
                name, description, category, notes
        );
        Assert.assertNotNull(userStory);

        // Create the object in the database and retrieve it's id
        userStoryManager.createUserStory(userStory);
        Long id = userStory.getId();
        Assert.assertNotNull(id);

        // Retrieve the object from the database using its id
        UserStory retrievedUserStory = userStoryManager.getUserStory(id);
        Assert.assertNotNull(retrievedUserStory);

    }

    @Test
    public void testGetUserStoryList() {
        List<UserStory> userStoryList;

        // Check the list is empty
        userStoryList = userStoryManager.getUserStoryList();
        Assert.assertTrue(userStoryList.isEmpty());

        // Initialise object and check the response is not null
        UserStory userStory = userStoryManager.initialiseUserStory(
                name, description, category, notes
        );
        Assert.assertNotNull(userStory);
        // Initialise update object and check the response is not null
        UserStory updateUserStory = userStoryManager.initialiseUserStory(
                updateName, updateDescription, updateCategory, updateNotes
        );
        Assert.assertNotNull(updateUserStory);

        // Create the object in the database and retrieve it's id
        userStoryManager.createUserStory(userStory);
        Long id = userStory.getId();
        Assert.assertNotNull(id);
        // Create the update object in the database and retrieve it's id
        userStoryManager.createUserStory(updateUserStory);
        Long updateId = updateUserStory.getId();
        Assert.assertNotNull(updateId);

        // Check the list contains two objects
        userStoryList = userStoryManager.getUserStoryList();
        Assert.assertEquals(2, userStoryList.size());
    }

    @Test
    public void testUpdateUserStory() {
        // Initialise object and check the response is not null
        UserStory userStory = userStoryManager.initialiseUserStory(
                name, description, category, notes
        );
        Assert.assertNotNull(userStory);

        // Create the object in the database and retrieve it's id
        userStoryManager.createUserStory(userStory);
        Long id = userStory.getId();
        Assert.assertNotNull(id);

        // Retrieve the object from the database using its id
        UserStory retrievedUserStory = userStoryManager.getUserStory(id);
        Assert.assertNotNull(retrievedUserStory);

        // Update the object
        userStory.setName(updateName);
        userStory.setDescription(updateDescription);
        userStory.setCategory(updateCategory);
        //Implementation Vinicius Meireles
        userStory.setNotes(updateNotes);
        userStoryManager.updateUserStory(userStory);

        // Re-Retrieve the object from the database and check its values
        userStory = userStoryManager.getUserStory(id);

        userStory.setName(updateName);
        Assert.assertEquals(updateName, userStory.getName());
        userStory.setDescription(updateDescription);
        Assert.assertEquals(updateDescription, userStory.getDescription());
        userStory.setCategory(updateCategory);
        Assert.assertEquals(updateCategory, userStory.getCategory());
        //Implementation Vinicius Meireles
        userStory.setNotes(updateNotes);
        Assert.assertEquals(updateNotes, userStory.getNotes());
    }

    @Test
    public void testDeleteUserStory() {
        // Initialise object and check the response is not null
        UserStory userStory = userStoryManager.initialiseUserStory(
                name, description, category, notes
        );
        Assert.assertNotNull(userStory);
        // Initialise update object and check the response is not null
        UserStory updateUserStory = userStoryManager.initialiseUserStory(
                updateName, updateDescription, updateCategory, updateNotes
        );
        Assert.assertNotNull(updateUserStory);

        // Create the object in the database and retrieve it's id
        userStoryManager.createUserStory(userStory);
        Long id = userStory.getId();
        Assert.assertNotNull(id);
        // Create the update object in the database and retrieve it's id
        userStoryManager.createUserStory(updateUserStory);
        Long updateId = updateUserStory.getId();
        Assert.assertNotNull(updateId);


        // Check the list contains two objects
        List<UserStory> userStoryList = userStoryManager.getUserStoryList();
        Assert.assertEquals(2, userStoryList.size());

        // Delete the objects from the database
        for (UserStory tempUserStory : userStoryList) {
            userStoryManager.deleteUserStory(tempUserStory);
        }

        // Check the list is empty
        userStoryList = userStoryManager.getUserStoryList();
        Assert.assertTrue(userStoryList.isEmpty());
    }
}