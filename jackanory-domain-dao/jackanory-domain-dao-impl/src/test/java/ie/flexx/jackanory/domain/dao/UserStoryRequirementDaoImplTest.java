package ie.flexx.jackanory.domain.dao;

import ie.flexx.jackanory.data.UserStoryRequirementData;
import ie.flexx.jackanory.data.dao.UserStoryRequirementDataDao;
import ie.flexx.jackanory.domain.UserStoryRequirement;
import ie.flexx.jackanory.domain.UserStoryRequirementDataAccessor;
import ie.flexx.jackanory.domain.UserStoryRequirementImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(PowerMockRunner.class)
@PrepareForTest(UserStoryRequirementDataAccessor.class)
public class UserStoryRequirementDaoImplTest {

    private UserStoryRequirementDaoImpl userStoryRequirementDaoImpl;
    private UserStoryRequirementDataDao mockUserStoryRequirementDataDao;
    private UserStoryRequirement mockUserStoryRequirement1;
    private UserStoryRequirementData mockUserStoryRequirementData1;
    private Long id = new Long(1);

    @Before
    public void setup() {
        mockUserStoryRequirementDataDao = Mockito.mock(UserStoryRequirementDataDao.class);
        userStoryRequirementDaoImpl = new UserStoryRequirementDaoImpl(mockUserStoryRequirementDataDao);

        // Create mock objects
        mockUserStoryRequirement1 = Mockito.mock(UserStoryRequirementImpl.class);
        mockUserStoryRequirementData1 = Mockito.mock(UserStoryRequirementData.class);
        UserStoryRequirementData mockUserStoryRequirementData2 = Mockito.mock(UserStoryRequirementData.class);
        UserStoryRequirementData mockUserStoryRequirementData3 = Mockito.mock(UserStoryRequirementData.class);

        // Mock out the Create Call
        PowerMockito.when(UserStoryRequirementDataAccessor.getUserStoryRequirementData(mockUserStoryRequirement1)).thenReturn(mockUserStoryRequirementData1);
        Mockito.when(mockUserStoryRequirementDataDao.createUserStoryRequirementData(Mockito.eq(mockUserStoryRequirementData1))).thenReturn(mockUserStoryRequirementData1);

        // Mock out the Read Call
        Mockito.when(mockUserStoryRequirementDataDao.readUserStoryRequirementData(Mockito.eq(id))).thenReturn(mockUserStoryRequirementData1);


        // Mock out the List Call
        List<UserStoryRequirementData> userStoryRequirementDataList = new ArrayList<>();
        userStoryRequirementDataList.add(mockUserStoryRequirementData1);
        userStoryRequirementDataList.add(mockUserStoryRequirementData2);
        userStoryRequirementDataList.add(mockUserStoryRequirementData3);
        Mockito.when(mockUserStoryRequirementDataDao.readUserStoryRequirementDataList()).thenReturn(userStoryRequirementDataList);
    }

    @Test
    public void testDefaultConstructor() {
        UserStoryRequirementDaoImpl userStoryRequirementDaoImpl = new UserStoryRequirementDaoImpl(mockUserStoryRequirementDataDao);
        Assert.assertNotNull(userStoryRequirementDaoImpl);
    }

    @Test
    public void testCreateUserStoryRequirement() {
        UserStoryRequirement result = userStoryRequirementDaoImpl.createUserStoryRequirement(mockUserStoryRequirement1);
        Assert.assertNotNull(result);
        Mockito.verify(mockUserStoryRequirementDataDao).createUserStoryRequirementData(Mockito.eq(mockUserStoryRequirementData1));
    }

    @Test
    public void testReadUserStoryRequirement() {
        UserStoryRequirement result = userStoryRequirementDaoImpl.readUserStoryRequirement(id);
        Assert.assertNotNull(result);
        Mockito.verify(mockUserStoryRequirementDataDao).readUserStoryRequirementData(Mockito.eq(id));
    }

    @Test
    public void testReadUserStoryRequirementList() {
        List<UserStoryRequirement> results = userStoryRequirementDaoImpl.readUserStoryRequirementList();
        Assert.assertEquals(3, results.size());
        Mockito.verify(mockUserStoryRequirementDataDao).readUserStoryRequirementDataList();
    }

    @Test
    public void testUpdateUserStoryRequirement() {
        UserStoryRequirement result = userStoryRequirementDaoImpl.updateUserStoryRequirement(mockUserStoryRequirement1);
        Assert.assertNotNull(result);
        Mockito.verify(mockUserStoryRequirementDataDao).updateUserStoryRequirementData(Mockito.eq(mockUserStoryRequirementData1));
    }

    @Test
    public void testDeleteUserStoryRequirement() {
        userStoryRequirementDaoImpl.deleteUserStoryRequirement(mockUserStoryRequirement1);
        Mockito.verify(mockUserStoryRequirementDataDao).deleteUserStoryRequirementData(Mockito.eq(mockUserStoryRequirementData1));
    }

    @Test
    public void testGetUserStoryRequirementDataDao() {
        UserStoryRequirementDataDao result = userStoryRequirementDaoImpl.getUserStoryRequirementDataDao();
        Assert.assertEquals(mockUserStoryRequirementDataDao, result);
    }
}