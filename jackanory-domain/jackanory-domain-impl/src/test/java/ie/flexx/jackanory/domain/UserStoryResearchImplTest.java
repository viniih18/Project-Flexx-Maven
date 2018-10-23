package ie.flexx.jackanory.domain;

import ie.flexx.jackanory.data.UserStoryResearchData;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class UserStoryResearchImplTest {

    private UserStoryResearchImpl userStoryResearchImpl;
    private UserStoryResearchData mockUserStoryResearchData;

    @Before
    public void setup() {
        mockUserStoryResearchData = Mockito.mock(UserStoryResearchData.class);
        userStoryResearchImpl = new UserStoryResearchImpl(mockUserStoryResearchData);

        Mockito.when(mockUserStoryResearchData.getId()).thenReturn(new Long(1));
        Mockito.when(mockUserStoryResearchData.getVersion()).thenReturn(new Long(1));
        Mockito.when(mockUserStoryResearchData.getResearch()).thenReturn("research");
        Mockito.when(mockUserStoryResearchData.getSource()).thenReturn("source");
    }

    @Test
    public void testDefaultConstructor() {
        UserStoryResearchImpl userStoryResearchImpl = new UserStoryResearchImpl();
        Assert.assertNotNull(userStoryResearchImpl);
    }

    @Test
    public void testMainConstructor() {
        UserStoryResearchImpl userStoryResearchImpl = new UserStoryResearchImpl(mockUserStoryResearchData);
        Assert.assertNotNull(userStoryResearchImpl);
    }

    @Test
    public void testGetId() {
        Long id = userStoryResearchImpl.getId();
        Assert.assertEquals(new Long(1), id);
    }


    @Test
    public void testGetVersion() {
        Long version = userStoryResearchImpl.getVersion();
        Assert.assertEquals(new Long(1), version);
    }

    @Test
    public void testSetVersion() {
        userStoryResearchImpl.setVersion(new Long(1));
        Mockito.verify(mockUserStoryResearchData).setVersion(new Long(1));
    }

    @Test
    public void testGetResearch() {
        String research = userStoryResearchImpl.getResearch();
        Assert.assertEquals("research", research);
    }

    @Test
    public void testSetResearch() {
        userStoryResearchImpl.setResearch("research");
        Mockito.verify(mockUserStoryResearchData).setResearch("research");
    }

    @Test
    public void testGetSource() {
        String source = userStoryResearchImpl.getSource();
        Assert.assertEquals("source", source);
    }

    @Test
    public void testSetSource() {
        userStoryResearchImpl.setSource("source");
        Mockito.verify(mockUserStoryResearchData).setSource("source");
    }

}