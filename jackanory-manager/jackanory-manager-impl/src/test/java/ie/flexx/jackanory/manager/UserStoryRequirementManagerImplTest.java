package ie.flexx.jackanory.manager;

import ie.flexx.jackanory.domain.UserStoryRequirement;
import ie.flexx.jackanory.domain.dao.UserStoryRequirementDao;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class UserStoryRequirementManagerImplTest {

    private UserStoryRequirementManagerImpl userStoryRequirementManagerImpl;
    private UserStoryRequirementDao mockUserStoryRequirementDao;
    private UserStoryRequirement mockUserStoryRequirement1;
    private Long id = new Long(1);

    @Before
    public void setup() {
        mockUserStoryRequirementDao = Mockito.mock(UserStoryRequirementDao.class);
        userStoryRequirementManagerImpl = new UserStoryRequirementManagerImpl(mockUserStoryRequirementDao);

        // Create Mock Objects
        mockUserStoryRequirement1 = Mockito.mock(UserStoryRequirement.class);
        UserStoryRequirement mockUserStoryRequirement2 = Mockito.mock(UserStoryRequirement.class);
        UserStoryRequirement mockUserStoryRequirement3 = Mockito.mock(UserStoryRequirement.class);

        // Mock out the Create Call
        Mockito.when((mockUserStoryRequirementDao.createUserStoryRequirement(Mockito.eq(mockUserStoryRequirement1)))).thenReturn(mockUserStoryRequirement1);

        // Mock out the Get Call
        Mockito.when((mockUserStoryRequirementDao.readUserStoryRequirement(Mockito.eq(id)))).thenReturn(mockUserStoryRequirement1);


        // Mock out the List Call
        List<UserStoryRequirement> userStoryRequirementList = new ArrayList<>();
        userStoryRequirementList.add(mockUserStoryRequirement1);
        userStoryRequirementList.add(mockUserStoryRequirement2);
        userStoryRequirementList.add(mockUserStoryRequirement3);
        Mockito.when((mockUserStoryRequirementDao.readUserStoryRequirementList())).thenReturn(userStoryRequirementList);

        // Mock out the Update Call
        Mockito.when((mockUserStoryRequirementDao.updateUserStoryRequirement(Mockito.eq(mockUserStoryRequirement1)))).thenReturn(mockUserStoryRequirement1);
    }

    @Test
    public void testConstructor() {
        UserStoryRequirementManagerImpl userStoryRequirementManagerImpl = new UserStoryRequirementManagerImpl(mockUserStoryRequirementDao);
        Assert.assertNotNull(userStoryRequirementManagerImpl);
    }

    @Test
    public void testInitialiseUserStoryRequirement() {
        UserStoryRequirement userStoryRequirement = userStoryRequirementManagerImpl.initialiseUserStoryRequirement();
        Assert.assertNotNull(userStoryRequirement);
    }

    @Test
    public void testCreateUserStoryRequirement() {
        UserStoryRequirement result = userStoryRequirementManagerImpl.createUserStoryRequirement(mockUserStoryRequirement1);
        Assert.assertNotNull(result);
        Mockito.verify(mockUserStoryRequirementDao).createUserStoryRequirement(mockUserStoryRequirement1);
    }

    @Test
    public void testGetUserStoryRequirement() {
        UserStoryRequirement userStoryRequirement = userStoryRequirementManagerImpl.getUserStoryRequirement(id);
        Assert.assertNotNull(userStoryRequirement);
        Mockito.verify(mockUserStoryRequirementDao).readUserStoryRequirement(Mockito.eq(id));
    }

    @Test
    public void testGetUserStoryRequirementList() {
        List<UserStoryRequirement> userStoryRequirementList = userStoryRequirementManagerImpl.getUserStoryRequirementList();
        Assert.assertEquals(3, userStoryRequirementList.size());
        Mockito.verify(mockUserStoryRequirementDao).readUserStoryRequirementList();
    }

    @Test
    public void testUpdateUserStoryRequirement() {
        UserStoryRequirement result = userStoryRequirementManagerImpl.updateUserStoryRequirement(mockUserStoryRequirement1);
        Assert.assertNotNull(result);
        Mockito.verify(mockUserStoryRequirementDao).updateUserStoryRequirement(Mockito.eq(mockUserStoryRequirement1));
    }

    @Test
    public void testDeleteUserStoryRequirement() {
        userStoryRequirementManagerImpl.deleteUserStoryRequirement(mockUserStoryRequirement1);
        Mockito.verify(mockUserStoryRequirementDao).deleteUserStoryRequirement(mockUserStoryRequirement1);
    }

    @Test
    public void testGetUserStoryRequirementDao() {
        UserStoryRequirementDao result = userStoryRequirementManagerImpl.getUserStoryRequirementDao();
        Assert.assertEquals(mockUserStoryRequirementDao, result);
    }
}