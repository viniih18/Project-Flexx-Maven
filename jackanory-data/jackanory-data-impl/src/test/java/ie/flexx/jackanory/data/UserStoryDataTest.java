package ie.flexx.jackanory.data;

import org.hamcrest.core.IsInstanceOf;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

public class UserStoryDataTest {
    private UserStoryData userStoryData;

    @Before
    public void setUp() throws Exception {
        userStoryData = new UserStoryData(
                "name",
                "description",
                "category"
        );
        userStoryData.setId(new Long(1));
        userStoryData.setVersion(new Long(1));
        userStoryData.setName("name");
        userStoryData.setDescription("description");
        userStoryData.setCategory("category");
        userStoryData.setSubCategory("subCategory");
        userStoryData.setStartDate(new Date());
        userStoryData.setAssignedDate(new Date());
        userStoryData.setSponsorEmail("sponsorEmail");
        userStoryData.setComplexity("complexity");
        userStoryData.setNotes("notes");
    }

    @Test
    public void testDefaultConstructor() {
        UserStoryData userStoryData = new UserStoryData();
        Assert.assertNotNull(userStoryData != null);
    }

    @Test
    public void testMainConstructor() {
        userStoryData = new UserStoryData(
                "name",
                "description",
                "category"
        );
        Assert.assertNotNull(userStoryData != null);
    }

    @Test
    public void testGetId() {
        Assert.assertEquals(new Long(1), userStoryData.getId());
    }

    @Test
    public void testSetId() {
        UserStoryData userStoryData = new UserStoryData();
        userStoryData.setId(new Long(2));
        Assert.assertEquals(new Long(2), userStoryData.getId());
    }

    @Test
    public void testGetVersion() {
        Assert.assertEquals(new Long(1), userStoryData.getVersion());
    }

    @Test
    public void testSetVersion() {
        UserStoryData userStoryData = new UserStoryData();
        userStoryData.setVersion(new Long(2));
        Assert.assertEquals(new Long(2), userStoryData.getVersion());
    }

    @Test
    public void testGetName() {
        Assert.assertEquals("name", userStoryData.getName());
    }

    @Test
    public void testSetName() {
        UserStoryData userStoryData = new UserStoryData();
        userStoryData.setName("newname");
        Assert.assertEquals("newname", userStoryData.getName());
    }

    @Test
    public void testGetDescription() {
        Assert.assertEquals("description", userStoryData.getDescription());
    }

    @Test
    public void testSetDescription() {
        UserStoryData userStoryData = new UserStoryData();
        userStoryData.setDescription("newdescription");
        Assert.assertEquals("newdescription", userStoryData.getDescription());
    }

    @Test
    public void testGetCategory() {
        Assert.assertEquals("category", userStoryData.getCategory());
    }

    @Test
    public void testSetCategory() {
        UserStoryData userStoryData = new UserStoryData();
        userStoryData.setCategory("newcategory");
        Assert.assertEquals("newcategory", userStoryData.getCategory());
    }

    @Test
    public void testGetSubCategory() {
        Assert.assertEquals("subCategory", userStoryData.getSubCategory());
    }

    @Test
    public void testSetSubCategory() {
        UserStoryData userStoryData = new UserStoryData();
        userStoryData.setSubCategory("newsubCategory");
        Assert.assertEquals("newsubCategory", userStoryData.getSubCategory());
    }

    @Test
    public void testGetStartDate() {
        Assert.assertThat(userStoryData.getStartDate(), IsInstanceOf.instanceOf(Date.class));
    }

    @Test
    public void testSetStartDate() {
        UserStoryData userStoryData = new UserStoryData();
        userStoryData.setStartDate(new Date());
        Assert.assertThat(userStoryData.getStartDate(), IsInstanceOf.instanceOf(Date.class));
    }

    @Test
    public void testGetAssignedDate() {
        Assert.assertThat(userStoryData.getAssignedDate(), IsInstanceOf.instanceOf(Date.class));
    }

    @Test
    public void testSetAssignedDate() {
        UserStoryData userStoryData = new UserStoryData();
        userStoryData.setAssignedDate(new Date());
        Assert.assertThat(userStoryData.getAssignedDate(), IsInstanceOf.instanceOf(Date.class));
    }

    @Test
    public void testGetSponsorEmail() {
        Assert.assertEquals("sponsorEmail", userStoryData.getSponsorEmail());
    }

    @Test
    public void testSetSponsorEmail() {
        UserStoryData userStoryData = new UserStoryData();
        userStoryData.setSponsorEmail("newsponsorEmail");
        Assert.assertEquals("newsponsorEmail", userStoryData.getSponsorEmail());
    }

    @Test
    public void testGetComplexity() {
        Assert.assertEquals("complexity", userStoryData.getComplexity());
    }

    @Test
    public void testSetComplexity() {
        UserStoryData userStoryData = new UserStoryData();
        userStoryData.setComplexity("newcomplexity");
        Assert.assertEquals("newcomplexity", userStoryData.getComplexity());
    }

    //Implementation Vinicius Meireles
    @Test
    public void testGetNotes() {
        Assert.assertEquals("notes", userStoryData.getNotes());
    }

    @Test
    public void testSetNotes() {
        UserStoryData userStoryData = new UserStoryData();
        userStoryData.setNotes("newnotes");
        Assert.assertEquals("newnotes", userStoryData.getNotes());
    }

}
