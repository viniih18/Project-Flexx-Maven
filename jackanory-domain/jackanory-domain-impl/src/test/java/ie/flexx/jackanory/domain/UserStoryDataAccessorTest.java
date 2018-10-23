package ie.flexx.jackanory.domain;

import ie.flexx.jackanory.data.UserStoryData;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class UserStoryDataAccessorTest {
    private UserStoryImpl mockUserStoryImpl;
    private UserStoryData mockUserStoryData;

    @Before
    public void setUp() {
        mockUserStoryImpl = Mockito.mock(UserStoryImpl.class);
        mockUserStoryData = Mockito.mock(UserStoryData.class);
        Mockito.when(mockUserStoryImpl.getUserStoryData()).thenReturn(mockUserStoryData);
    }

    @Test
    public void testGetUserStoryData() {
        UserStoryData userStoryData = UserStoryDataAccessor.getUserStoryData(mockUserStoryImpl);
        Assert.assertNotNull(userStoryData);
        Assert.assertEquals(mockUserStoryData, userStoryData);
    }
}