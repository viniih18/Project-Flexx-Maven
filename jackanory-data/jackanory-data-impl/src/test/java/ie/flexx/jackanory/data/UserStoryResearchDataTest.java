package ie.flexx.jackanory.data;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UserStoryResearchDataTest {
    private UserStoryResearchData userStoryResearchData;

    @Before
    public void setUp() throws Exception {
        userStoryResearchData = new UserStoryResearchData(
                "research"
        );
        userStoryResearchData.setId(new Long(1));
        userStoryResearchData.setVersion(new Long(1));
        userStoryResearchData.setResearch("research");
        userStoryResearchData.setSource("source");
    }

    @Test
    public void testDefaultConstructor() {
        UserStoryResearchData userStoryResearchData = new UserStoryResearchData();
        Assert.assertNotNull(userStoryResearchData != null);
    }

    @Test
    public void testMainConstructor() {
        userStoryResearchData = new UserStoryResearchData(
                "research"
        );
        Assert.assertNotNull(userStoryResearchData != null);
    }

    @Test
    public void testGetId() {
        Assert.assertEquals(new Long(1), userStoryResearchData.getId());
    }

    @Test
    public void testSetId() {
        UserStoryResearchData userStoryResearchData = new UserStoryResearchData();
        userStoryResearchData.setId(new Long(2));
        Assert.assertEquals(new Long(2), userStoryResearchData.getId());
    }

    @Test
    public void testGetVersion() {
        Assert.assertEquals(new Long(1), userStoryResearchData.getVersion());
    }

    @Test
    public void testSetVersion() {
        UserStoryResearchData userStoryResearchData = new UserStoryResearchData();
        userStoryResearchData.setVersion(new Long(2));
        Assert.assertEquals(new Long(2), userStoryResearchData.getVersion());
    }

    @Test
    public void testGetResearch() {
        Assert.assertEquals("research", userStoryResearchData.getResearch());
    }

    @Test
    public void testSetResearch() {
        UserStoryResearchData userStoryResearchData = new UserStoryResearchData();
        userStoryResearchData.setResearch("newresearch");
        Assert.assertEquals("newresearch", userStoryResearchData.getResearch());
    }

    @Test
    public void testGetSource() {
        Assert.assertEquals("source", userStoryResearchData.getSource());
    }

    @Test
    public void testSetSource() {
        UserStoryResearchData userStoryResearchData = new UserStoryResearchData();
        userStoryResearchData.setSource("newsource");
        Assert.assertEquals("newsource", userStoryResearchData.getSource());
    }

}
