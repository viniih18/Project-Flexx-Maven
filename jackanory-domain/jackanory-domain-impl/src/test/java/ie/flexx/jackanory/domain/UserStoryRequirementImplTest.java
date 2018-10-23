package ie.flexx.jackanory.domain;

import ie.flexx.jackanory.data.UserStoryRequirementData;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class UserStoryRequirementImplTest {

    private UserStoryRequirementImpl userStoryRequirementImpl;
    private UserStoryRequirementData mockUserStoryRequirementData;

    @Before
    public void setup() {
        mockUserStoryRequirementData = Mockito.mock(UserStoryRequirementData.class);
        userStoryRequirementImpl = new UserStoryRequirementImpl(mockUserStoryRequirementData);

        Mockito.when(mockUserStoryRequirementData.getId()).thenReturn(new Long(1));
        Mockito.when(mockUserStoryRequirementData.getVersion()).thenReturn(new Long(1));
        Mockito.when(mockUserStoryRequirementData.getRequirement()).thenReturn("requirement");
    }

    @Test
    public void testDefaultConstructor() {
        UserStoryRequirementImpl userStoryRequirementImpl = new UserStoryRequirementImpl();
        Assert.assertNotNull(userStoryRequirementImpl);
    }

    @Test
    public void testMainConstructor() {
        UserStoryRequirementImpl userStoryRequirementImpl = new UserStoryRequirementImpl(mockUserStoryRequirementData);
        Assert.assertNotNull(userStoryRequirementImpl);
    }

    @Test
    public void testGetId() {
        Long id = userStoryRequirementImpl.getId();
        Assert.assertEquals(new Long(1), id);
    }


    @Test
    public void testGetVersion() {
        Long version = userStoryRequirementImpl.getVersion();
        Assert.assertEquals(new Long(1), version);
    }

    @Test
    public void testSetVersion() {
        userStoryRequirementImpl.setVersion(new Long(1));
        Mockito.verify(mockUserStoryRequirementData).setVersion(new Long(1));
    }

    @Test
    public void testGetRequirement() {
        String requirement = userStoryRequirementImpl.getRequirement();
        Assert.assertEquals("requirement", requirement);
    }

    @Test
    public void testSetRequirement() {
        userStoryRequirementImpl.setRequirement("requirement");
        Mockito.verify(mockUserStoryRequirementData).setRequirement("requirement");
    }

}