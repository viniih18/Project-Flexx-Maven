package ie.flexx.jackanory.data;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UserStoryRequirementDataTest {
    private UserStoryRequirementData userStoryRequirementData;

    @Before
    public void setUp() throws Exception {
        userStoryRequirementData = new UserStoryRequirementData(
                "requirement"
        );
        userStoryRequirementData.setId(new Long(1));
        userStoryRequirementData.setVersion(new Long(1));
        userStoryRequirementData.setRequirement("requirement");
    }

    @Test
    public void testDefaultConstructor() {
        UserStoryRequirementData userStoryRequirementData = new UserStoryRequirementData();
        Assert.assertNotNull(userStoryRequirementData != null);
    }

    @Test
    public void testMainConstructor() {
        userStoryRequirementData = new UserStoryRequirementData(
                "requirement"
        );
        Assert.assertNotNull(userStoryRequirementData != null);
    }

    @Test
    public void testGetId() {
        Assert.assertEquals(new Long(1), userStoryRequirementData.getId());
    }

    @Test
    public void testSetId() {
        UserStoryRequirementData userStoryRequirementData = new UserStoryRequirementData();
        userStoryRequirementData.setId(new Long(2));
        Assert.assertEquals(new Long(2), userStoryRequirementData.getId());
    }

    @Test
    public void testGetVersion() {
        Assert.assertEquals(new Long(1), userStoryRequirementData.getVersion());
    }

    @Test
    public void testSetVersion() {
        UserStoryRequirementData userStoryRequirementData = new UserStoryRequirementData();
        userStoryRequirementData.setVersion(new Long(2));
        Assert.assertEquals(new Long(2), userStoryRequirementData.getVersion());
    }

    @Test
    public void testGetRequirement() {
        Assert.assertEquals("requirement", userStoryRequirementData.getRequirement());
    }

    @Test
    public void testSetRequirement() {
        UserStoryRequirementData userStoryRequirementData = new UserStoryRequirementData();
        userStoryRequirementData.setRequirement("newrequirement");
        Assert.assertEquals("newrequirement", userStoryRequirementData.getRequirement());
    }

}
