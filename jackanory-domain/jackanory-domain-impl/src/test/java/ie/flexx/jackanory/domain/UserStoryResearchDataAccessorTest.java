package ie.flexx.jackanory.domain;

import ie.flexx.jackanory.data.UserStoryResearchData;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class UserStoryResearchDataAccessorTest {
    private UserStoryResearchImpl mockUserStoryResearchImpl;
    private UserStoryResearchData mockUserStoryResearchData;

    @Before
    public void setUp() {
        mockUserStoryResearchImpl = Mockito.mock(UserStoryResearchImpl.class);
        mockUserStoryResearchData = Mockito.mock(UserStoryResearchData.class);
        Mockito.when(mockUserStoryResearchImpl.getUserStoryResearchData()).thenReturn(mockUserStoryResearchData);
    }

    @Test
    public void testGetUserStoryResearchData() {
        UserStoryResearchData userStoryResearchData = UserStoryResearchDataAccessor.getUserStoryResearchData(mockUserStoryResearchImpl);
        Assert.assertNotNull(userStoryResearchData);
        Assert.assertEquals(mockUserStoryResearchData, userStoryResearchData);
    }
}