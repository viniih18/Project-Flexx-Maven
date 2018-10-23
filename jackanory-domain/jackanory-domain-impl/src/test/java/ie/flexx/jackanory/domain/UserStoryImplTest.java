package ie.flexx.jackanory.domain;

import ie.flexx.jackanory.data.UserStoryData;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Date;

public class UserStoryImplTest {

    private UserStoryImpl userStoryImpl;
    private UserStoryData mockUserStoryData;

    @Before
    public void setup() {
        mockUserStoryData = Mockito.mock(UserStoryData.class);
        userStoryImpl = new UserStoryImpl(mockUserStoryData);

        Mockito.when(mockUserStoryData.getId()).thenReturn(new Long(1));
        Mockito.when(mockUserStoryData.getVersion()).thenReturn(new Long(1));
        Mockito.when(mockUserStoryData.getName()).thenReturn("name");
        Mockito.when(mockUserStoryData.getDescription()).thenReturn("description");
        Mockito.when(mockUserStoryData.getCategory()).thenReturn("category");
        Mockito.when(mockUserStoryData.getSubCategory()).thenReturn("subCategory");
        Mockito.when(mockUserStoryData.getStartDate()).thenReturn(new Date());
        Mockito.when(mockUserStoryData.getAssignedDate()).thenReturn(new Date());
        Mockito.when(mockUserStoryData.getSponsorEmail()).thenReturn("sponsorEmail");
        Mockito.when(mockUserStoryData.getComplexity()).thenReturn("complexity");
        Mockito.when(mockUserStoryData.getNotes()).thenReturn("notes");
    }

    @Test
    public void testDefaultConstructor() {
        UserStoryImpl userStoryImpl = new UserStoryImpl();
        Assert.assertNotNull(userStoryImpl);
    }

    @Test
    public void testMainConstructor() {
        UserStoryImpl userStoryImpl = new UserStoryImpl(mockUserStoryData);
        Assert.assertNotNull(userStoryImpl);
    }

    @Test
    public void testGetId() {
        Long id = userStoryImpl.getId();
        Assert.assertEquals(new Long(1), id);
    }


    @Test
    public void testGetVersion() {
        Long version = userStoryImpl.getVersion();
        Assert.assertEquals(new Long(1), version);
    }

    @Test
    public void testSetVersion() {
        userStoryImpl.setVersion(new Long(1));
        Mockito.verify(mockUserStoryData).setVersion(new Long(1));
    }

    @Test
    public void testGetName() {
        String name = userStoryImpl.getName();
        Assert.assertEquals("name", name);
    }

    @Test
    public void testSetName() {
        userStoryImpl.setName("name");
        Mockito.verify(mockUserStoryData).setName("name");
    }

    @Test
    public void testGetDescription() {
        String description = userStoryImpl.getDescription();
        Assert.assertEquals("description", description);
    }

    @Test
    public void testSetDescription() {
        userStoryImpl.setDescription("description");
        Mockito.verify(mockUserStoryData).setDescription("description");
    }

    @Test
    public void testGetCategory() {
        String category = userStoryImpl.getCategory();
        Assert.assertEquals("category", category);
    }

    @Test
    public void testSetCategory() {
        userStoryImpl.setCategory("category");
        Mockito.verify(mockUserStoryData).setCategory("category");
    }

    @Test
    public void testGetSubCategory() {
        String subCategory = userStoryImpl.getSubCategory();
        Assert.assertEquals("subCategory", subCategory);
    }

    @Test
    public void testSetSubCategory() {
        userStoryImpl.setSubCategory("subCategory");
        Mockito.verify(mockUserStoryData).setSubCategory("subCategory");
    }

    @Test
    public void testGetStartDate() {
        Date startDate = userStoryImpl.getStartDate();
        Assert.assertThat(startDate, IsInstanceOf.instanceOf(Date.class));
    }

    @Test
    public void testSetStartDate() {
        userStoryImpl.setStartDate(new Date());
        Assert.assertThat(userStoryImpl.getStartDate(), IsInstanceOf.instanceOf(Date.class));
    }

    @Test
    public void testGetAssignedDate() {
        Date assignedDate = userStoryImpl.getAssignedDate();
        Assert.assertThat(assignedDate, IsInstanceOf.instanceOf(Date.class));
    }

    @Test
    public void testSetAssignedDate() {
        userStoryImpl.setAssignedDate(new Date());
        Assert.assertThat(userStoryImpl.getAssignedDate(), IsInstanceOf.instanceOf(Date.class));
    }

    @Test
    public void testGetSponsorEmail() {
        String sponsorEmail = userStoryImpl.getSponsorEmail();
        Assert.assertEquals("sponsorEmail", sponsorEmail);
    }

    @Test
    public void testSetSponsorEmail() {
        userStoryImpl.setSponsorEmail("sponsorEmail");
        Mockito.verify(mockUserStoryData).setSponsorEmail("sponsorEmail");
    }

    @Test
    public void testGetComplexity() {
        String complexity = userStoryImpl.getComplexity();
        Assert.assertEquals("complexity", complexity);
    }

    @Test
    public void testSetComplexity() {
        userStoryImpl.setComplexity("complexity");
        Mockito.verify(mockUserStoryData).setComplexity("complexity");
    }

    //
    @Test
    public void testGetNotes() {
        String notes = userStoryImpl.getNotes();
        Assert.assertEquals("notes", notes);
    }

    @Test
    public void testSetNotes() {
        userStoryImpl.setNotes("notes");
        Mockito.verify(mockUserStoryData).setNotes("notes");
    }

}