package ie.flexx.jackanory.manager;

import ie.flexx.jackanory.domain.UserStory;
import ie.flexx.jackanory.domain.dao.UserStoryDao;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class UserStoryManagerImplTest {

    private UserStoryManagerImpl userStoryManagerImpl;
    private UserStoryDao mockUserStoryDao;
    private UserStory mockUserStory1;
    private Long id = new Long(1);

    @Before
    public void setup() {
        mockUserStoryDao = Mockito.mock(UserStoryDao.class);
        userStoryManagerImpl = new UserStoryManagerImpl(mockUserStoryDao);

        // Create Mock Objects
        mockUserStory1 = Mockito.mock(UserStory.class);
        UserStory mockUserStory2 = Mockito.mock(UserStory.class);
        UserStory mockUserStory3 = Mockito.mock(UserStory.class);

        // Mock out the Create Call
        Mockito.when((mockUserStoryDao.createUserStory(Mockito.eq(mockUserStory1)))).thenReturn(mockUserStory1);

        // Mock out the Get Call
        Mockito.when((mockUserStoryDao.readUserStory(Mockito.eq(id)))).thenReturn(mockUserStory1);


        // Mock out the List Call
        List<UserStory> userStoryList = new ArrayList<>();
        userStoryList.add(mockUserStory1);
        userStoryList.add(mockUserStory2);
        userStoryList.add(mockUserStory3);
        Mockito.when((mockUserStoryDao.readUserStoryList())).thenReturn(userStoryList);

        // Mock out the Update Call
        Mockito.when((mockUserStoryDao.updateUserStory(Mockito.eq(mockUserStory1)))).thenReturn(mockUserStory1);
    }

    @Test
    public void testConstructor() {
        UserStoryManagerImpl userStoryManagerImpl = new UserStoryManagerImpl(mockUserStoryDao);
        Assert.assertNotNull(userStoryManagerImpl);
    }

    @Test
    public void testInitialiseUserStory() {
        UserStory userStory = userStoryManagerImpl.initialiseUserStory();
        Assert.assertNotNull(userStory);
    }

    @Test
    public void testCreateUserStory() {
        UserStory result = userStoryManagerImpl.createUserStory(mockUserStory1);
        Assert.assertNotNull(result);
        Mockito.verify(mockUserStoryDao).createUserStory(mockUserStory1);
    }

    @Test
    public void testGetUserStory() {
        UserStory userStory = userStoryManagerImpl.getUserStory(id);
        Assert.assertNotNull(userStory);
        Mockito.verify(mockUserStoryDao).readUserStory(Mockito.eq(id));
    }

    @Test
    public void testGetUserStoryList() {
        List<UserStory> userStoryList = userStoryManagerImpl.getUserStoryList();
        Assert.assertEquals(3, userStoryList.size());
        Mockito.verify(mockUserStoryDao).readUserStoryList();
    }

    @Test
    public void testUpdateUserStory() {
        UserStory result = userStoryManagerImpl.updateUserStory(mockUserStory1);
        Assert.assertNotNull(result);
        Mockito.verify(mockUserStoryDao).updateUserStory(Mockito.eq(mockUserStory1));
    }

    @Test
    public void testDeleteUserStory() {
        userStoryManagerImpl.deleteUserStory(mockUserStory1);
        Mockito.verify(mockUserStoryDao).deleteUserStory(mockUserStory1);
    }

    @Test
    public void testGetUserStoryDao() {
        UserStoryDao result = userStoryManagerImpl.getUserStoryDao();
        Assert.assertEquals(mockUserStoryDao, result);
    }
}