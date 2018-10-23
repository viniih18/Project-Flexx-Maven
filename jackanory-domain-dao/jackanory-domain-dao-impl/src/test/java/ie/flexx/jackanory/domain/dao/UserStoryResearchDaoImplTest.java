package ie.flexx.jackanory.domain.dao;

import ie.flexx.jackanory.data.UserStoryResearchData;
import ie.flexx.jackanory.data.dao.UserStoryResearchDataDao;
import ie.flexx.jackanory.domain.UserStoryResearch;
import ie.flexx.jackanory.domain.UserStoryResearchDataAccessor;
import ie.flexx.jackanory.domain.UserStoryResearchImpl;
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
@PrepareForTest(UserStoryResearchDataAccessor.class)
public class UserStoryResearchDaoImplTest {

    private UserStoryResearchDaoImpl userStoryResearchDaoImpl;
    private UserStoryResearchDataDao mockUserStoryResearchDataDao;
    private UserStoryResearch mockUserStoryResearch1;
    private UserStoryResearchData mockUserStoryResearchData1;
    private Long id = new Long(1);

    @Before
    public void setup() {
        mockUserStoryResearchDataDao = Mockito.mock(UserStoryResearchDataDao.class);
        userStoryResearchDaoImpl = new UserStoryResearchDaoImpl(mockUserStoryResearchDataDao);

        // Create mock objects
        mockUserStoryResearch1 = Mockito.mock(UserStoryResearchImpl.class);
        mockUserStoryResearchData1 = Mockito.mock(UserStoryResearchData.class);
        UserStoryResearchData mockUserStoryResearchData2 = Mockito.mock(UserStoryResearchData.class);
        UserStoryResearchData mockUserStoryResearchData3 = Mockito.mock(UserStoryResearchData.class);

        // Mock out the Create Call
        PowerMockito.when(UserStoryResearchDataAccessor.getUserStoryResearchData(mockUserStoryResearch1)).thenReturn(mockUserStoryResearchData1);
        Mockito.when(mockUserStoryResearchDataDao.createUserStoryResearchData(Mockito.eq(mockUserStoryResearchData1))).thenReturn(mockUserStoryResearchData1);

        // Mock out the Read Call
        Mockito.when(mockUserStoryResearchDataDao.readUserStoryResearchData(Mockito.eq(id))).thenReturn(mockUserStoryResearchData1);


        // Mock out the List Call
        List<UserStoryResearchData> userStoryResearchDataList = new ArrayList<>();
        userStoryResearchDataList.add(mockUserStoryResearchData1);
        userStoryResearchDataList.add(mockUserStoryResearchData2);
        userStoryResearchDataList.add(mockUserStoryResearchData3);
        Mockito.when(mockUserStoryResearchDataDao.readUserStoryResearchDataList()).thenReturn(userStoryResearchDataList);
    }

    @Test
    public void testDefaultConstructor() {
        UserStoryResearchDaoImpl userStoryResearchDaoImpl = new UserStoryResearchDaoImpl(mockUserStoryResearchDataDao);
        Assert.assertNotNull(userStoryResearchDaoImpl);
    }

    @Test
    public void testCreateUserStoryResearch() {
        UserStoryResearch result = userStoryResearchDaoImpl.createUserStoryResearch(mockUserStoryResearch1);
        Assert.assertNotNull(result);
        Mockito.verify(mockUserStoryResearchDataDao).createUserStoryResearchData(Mockito.eq(mockUserStoryResearchData1));
    }

    @Test
    public void testReadUserStoryResearch() {
        UserStoryResearch result = userStoryResearchDaoImpl.readUserStoryResearch(id);
        Assert.assertNotNull(result);
        Mockito.verify(mockUserStoryResearchDataDao).readUserStoryResearchData(Mockito.eq(id));
    }

    @Test
    public void testReadUserStoryResearchList() {
        List<UserStoryResearch> results = userStoryResearchDaoImpl.readUserStoryResearchList();
        Assert.assertEquals(3, results.size());
        Mockito.verify(mockUserStoryResearchDataDao).readUserStoryResearchDataList();
    }

    @Test
    public void testUpdateUserStoryResearch() {
        UserStoryResearch result = userStoryResearchDaoImpl.updateUserStoryResearch(mockUserStoryResearch1);
        Assert.assertNotNull(result);
        Mockito.verify(mockUserStoryResearchDataDao).updateUserStoryResearchData(Mockito.eq(mockUserStoryResearchData1));
    }

    @Test
    public void testDeleteUserStoryResearch() {
        userStoryResearchDaoImpl.deleteUserStoryResearch(mockUserStoryResearch1);
        Mockito.verify(mockUserStoryResearchDataDao).deleteUserStoryResearchData(Mockito.eq(mockUserStoryResearchData1));
    }

    @Test
    public void testGetUserStoryResearchDataDao() {
        UserStoryResearchDataDao result = userStoryResearchDaoImpl.getUserStoryResearchDataDao();
        Assert.assertEquals(mockUserStoryResearchDataDao, result);
    }
}