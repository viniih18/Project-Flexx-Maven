package ie.flexx.jackanory.domain;

import ie.flexx.jackanory.data.UserStoryRequirementData;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class UserStoryRequirementDataAccessorTest {
    private UserStoryRequirementImpl mockUserStoryRequirementImpl;
    private UserStoryRequirementData mockUserStoryRequirementData;

    @Before
    public void setUp() {
        mockUserStoryRequirementImpl = Mockito.mock(UserStoryRequirementImpl.class);
        mockUserStoryRequirementData = Mockito.mock(UserStoryRequirementData.class);
        Mockito.when(mockUserStoryRequirementImpl.getUserStoryRequirementData()).thenReturn(mockUserStoryRequirementData);
    }

    @Test
    public void testGetUserStoryRequirementData() {
        UserStoryRequirementData userStoryRequirementData = UserStoryRequirementDataAccessor.getUserStoryRequirementData(mockUserStoryRequirementImpl);
        Assert.assertNotNull(userStoryRequirementData);
        Assert.assertEquals(mockUserStoryRequirementData, userStoryRequirementData);
    }
}