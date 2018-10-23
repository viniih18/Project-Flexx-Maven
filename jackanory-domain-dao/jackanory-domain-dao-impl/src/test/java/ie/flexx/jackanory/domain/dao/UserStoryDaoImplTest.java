package ie.flexx.jackanory.domain.dao;

import ie.flexx.jackanory.data.UserStoryData;
import ie.flexx.jackanory.data.dao.UserStoryDataDao;
import ie.flexx.jackanory.domain.UserStory;
import ie.flexx.jackanory.domain.UserStoryDataAccessor;
import ie.flexx.jackanory.domain.UserStoryImpl;
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
@PrepareForTest(UserStoryDataAccessor.class)
public class UserStoryDaoImplTest {

    private UserStoryDaoImpl userStoryDaoImpl;
    private UserStoryDataDao mockUserStoryDataDao;
    private UserStory mockUserStory1;
    private UserStoryData mockUserStoryData1;
    private Long id = new Long(1);

    @Before
    public void setup() {
        mockUserStoryDataDao = Mockito.mock(UserStoryDataDao.class);
        userStoryDaoImpl = new UserStoryDaoImpl(mockUserStoryDataDao);

        // Create mock objects
        mockUserStory1 = Mockito.mock(UserStoryImpl.class);
        mockUserStoryData1 = Mockito.mock(UserStoryData.class);
        UserStoryData mockUserStoryData2 = Mockito.mock(UserStoryData.class);
        UserStoryData mockUserStoryData3 = Mockito.mock(UserStoryData.class);

        // Mock out the Create Call
        PowerMockito.when(UserStoryDataAccessor.getUserStoryData(mockUserStory1)).thenReturn(mockUserStoryData1);
        Mockito.when(mockUserStoryDataDao.createUserStoryData(Mockito.eq(mockUserStoryData1))).thenReturn(mockUserStoryData1);

        // Mock out the Read Call
        Mockito.when(mockUserStoryDataDao.readUserStoryData(Mockito.eq(id))).thenReturn(mockUserStoryData1);


        // Mock out the List Call
        List<UserStoryData> userStoryDataList = new ArrayList<>();
        userStoryDataList.add(mockUserStoryData1);
        userStoryDataList.add(mockUserStoryData2);
        userStoryDataList.add(mockUserStoryData3);
        Mockito.when(mockUserStoryDataDao.readUserStoryDataList()).thenReturn(userStoryDataList);
    }

    @Test
    public void testDefaultConstructor() {
        UserStoryDaoImpl userStoryDaoImpl = new UserStoryDaoImpl(mockUserStoryDataDao);
        Assert.assertNotNull(userStoryDaoImpl);
    }

    @Test
    public void testCreateUserStory() {
        UserStory result = userStoryDaoImpl.createUserStory(mockUserStory1);
        Assert.assertNotNull(result);
        Mockito.verify(mockUserStoryDataDao).createUserStoryData(Mockito.eq(mockUserStoryData1));
    }

    @Test
    public void testReadUserStory() {
        UserStory result = userStoryDaoImpl.readUserStory(id);
        Assert.assertNotNull(result);
        Mockito.verify(mockUserStoryDataDao).readUserStoryData(Mockito.eq(id));
    }

    @Test
    public void testReadUserStoryList() {
        List<UserStory> results = userStoryDaoImpl.readUserStoryList();
        Assert.assertEquals(3, results.size());
        Mockito.verify(mockUserStoryDataDao).readUserStoryDataList();
    }

    @Test
    public void testUpdateUserStory() {
        UserStory result = userStoryDaoImpl.updateUserStory(mockUserStory1);
        Assert.assertNotNull(result);
        Mockito.verify(mockUserStoryDataDao).updateUserStoryData(Mockito.eq(mockUserStoryData1));
    }

    @Test
    public void testDeleteUserStory() {
        userStoryDaoImpl.deleteUserStory(mockUserStory1);
        Mockito.verify(mockUserStoryDataDao).deleteUserStoryData(Mockito.eq(mockUserStoryData1));
    }

    @Test
    public void testGetUserStoryDataDao() {
        UserStoryDataDao result = userStoryDaoImpl.getUserStoryDataDao();
        Assert.assertEquals(mockUserStoryDataDao, result);
    }
}