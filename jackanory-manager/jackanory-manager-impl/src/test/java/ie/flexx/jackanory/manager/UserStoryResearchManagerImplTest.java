package ie.flexx.jackanory.manager;

import ie.flexx.jackanory.domain.UserStoryResearch;
import ie.flexx.jackanory.domain.dao.UserStoryResearchDao;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class UserStoryResearchManagerImplTest {

    private UserStoryResearchManagerImpl userStoryResearchManagerImpl;
    private UserStoryResearchDao mockUserStoryResearchDao;
    private UserStoryResearch mockUserStoryResearch1;
    private Long id = new Long(1);

    @Before
    public void setup() {
        mockUserStoryResearchDao = Mockito.mock(UserStoryResearchDao.class);
        userStoryResearchManagerImpl = new UserStoryResearchManagerImpl(mockUserStoryResearchDao);

        // Create Mock Objects
        mockUserStoryResearch1 = Mockito.mock(UserStoryResearch.class);
        UserStoryResearch mockUserStoryResearch2 = Mockito.mock(UserStoryResearch.class);
        UserStoryResearch mockUserStoryResearch3 = Mockito.mock(UserStoryResearch.class);

        // Mock out the Create Call
        Mockito.when((mockUserStoryResearchDao.createUserStoryResearch(Mockito.eq(mockUserStoryResearch1)))).thenReturn(mockUserStoryResearch1);

        // Mock out the Get Call
        Mockito.when((mockUserStoryResearchDao.readUserStoryResearch(Mockito.eq(id)))).thenReturn(mockUserStoryResearch1);


        // Mock out the List Call
        List<UserStoryResearch> userStoryResearchList = new ArrayList<>();
        userStoryResearchList.add(mockUserStoryResearch1);
        userStoryResearchList.add(mockUserStoryResearch2);
        userStoryResearchList.add(mockUserStoryResearch3);
        Mockito.when((mockUserStoryResearchDao.readUserStoryResearchList())).thenReturn(userStoryResearchList);

        // Mock out the Update Call
        Mockito.when((mockUserStoryResearchDao.updateUserStoryResearch(Mockito.eq(mockUserStoryResearch1)))).thenReturn(mockUserStoryResearch1);
    }

    @Test
    public void testConstructor() {
        UserStoryResearchManagerImpl userStoryResearchManagerImpl = new UserStoryResearchManagerImpl(mockUserStoryResearchDao);
        Assert.assertNotNull(userStoryResearchManagerImpl);
    }

    @Test
    public void testInitialiseUserStoryResearch() {
        UserStoryResearch userStoryResearch = userStoryResearchManagerImpl.initialiseUserStoryResearch();
        Assert.assertNotNull(userStoryResearch);
    }

    @Test
    public void testCreateUserStoryResearch() {
        UserStoryResearch result = userStoryResearchManagerImpl.createUserStoryResearch(mockUserStoryResearch1);
        Assert.assertNotNull(result);
        Mockito.verify(mockUserStoryResearchDao).createUserStoryResearch(mockUserStoryResearch1);
    }

    @Test
    public void testGetUserStoryResearch() {
        UserStoryResearch userStoryResearch = userStoryResearchManagerImpl.getUserStoryResearch(id);
        Assert.assertNotNull(userStoryResearch);
        Mockito.verify(mockUserStoryResearchDao).readUserStoryResearch(Mockito.eq(id));
    }

    @Test
    public void testGetUserStoryResearchList() {
        List<UserStoryResearch> userStoryResearchList = userStoryResearchManagerImpl.getUserStoryResearchList();
        Assert.assertEquals(3, userStoryResearchList.size());
        Mockito.verify(mockUserStoryResearchDao).readUserStoryResearchList();
    }

    @Test
    public void testUpdateUserStoryResearch() {
        UserStoryResearch result = userStoryResearchManagerImpl.updateUserStoryResearch(mockUserStoryResearch1);
        Assert.assertNotNull(result);
        Mockito.verify(mockUserStoryResearchDao).updateUserStoryResearch(Mockito.eq(mockUserStoryResearch1));
    }

    @Test
    public void testDeleteUserStoryResearch() {
        userStoryResearchManagerImpl.deleteUserStoryResearch(mockUserStoryResearch1);
        Mockito.verify(mockUserStoryResearchDao).deleteUserStoryResearch(mockUserStoryResearch1);
    }

    @Test
    public void testGetUserStoryResearchDao() {
        UserStoryResearchDao result = userStoryResearchManagerImpl.getUserStoryResearchDao();
        Assert.assertEquals(mockUserStoryResearchDao, result);
    }
}