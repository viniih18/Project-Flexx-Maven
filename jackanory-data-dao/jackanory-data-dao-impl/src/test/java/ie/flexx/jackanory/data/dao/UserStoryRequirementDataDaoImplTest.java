package ie.flexx.jackanory.data.dao;

import ie.flexx.jackanory.data.UserStoryData;
import ie.flexx.jackanory.data.UserStoryRequirementData;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class UserStoryRequirementDataDaoImplTest {
    private UserStoryRequirementDataDaoImpl userStoryRequirementDataDaoImpl;
    private EntityManager mockEntityManager;
    private UserStoryRequirementData mockUserStoryRequirementData1;
    private UserStoryRequirementData mockUserStoryRequirementData2;
    private UserStoryRequirementData mockUserStoryRequirementData3;
    private UserStoryData mockUserStoryData;
    private Long id = new Long(1);

    @Before
    public void setUp() throws Exception {
        userStoryRequirementDataDaoImpl = new UserStoryRequirementDataDaoImpl();
        mockEntityManager = Mockito.mock(EntityManager.class);
        userStoryRequirementDataDaoImpl.setEntityManager(mockEntityManager);

        mockUserStoryRequirementData1 = Mockito.mock(UserStoryRequirementData.class);
        mockUserStoryRequirementData2 = Mockito.mock(UserStoryRequirementData.class);
        mockUserStoryRequirementData3 = Mockito.mock(UserStoryRequirementData.class);

        mockUserStoryData = Mockito.mock(UserStoryData.class);

        List<UserStoryRequirementData> userStoryRequirementDataList = new ArrayList<UserStoryRequirementData>();
        userStoryRequirementDataList.add(mockUserStoryRequirementData1);
        userStoryRequirementDataList.add(mockUserStoryRequirementData2);
        userStoryRequirementDataList.add(mockUserStoryRequirementData3);

        // Mock out the read call
        Mockito.when(mockEntityManager.find(Mockito.eq(UserStoryRequirementData.class), Mockito.eq(id))).thenReturn(mockUserStoryRequirementData1);

        // Mock out the read list call
        CriteriaBuilder mockCriteriaBuilder = Mockito.mock(CriteriaBuilder.class);
        CriteriaQuery mockCriteriaQuery = Mockito.mock(CriteriaQuery.class);
        Root mockRoot = Mockito.mock(Root.class);
        TypedQuery mockTypedQuery = Mockito.mock(TypedQuery.class);

        Mockito.when(mockEntityManager.getCriteriaBuilder()).thenReturn(mockCriteriaBuilder);
        Mockito.when(mockCriteriaBuilder.createQuery(Mockito.eq(UserStoryRequirementData.class))).thenReturn(mockCriteriaQuery);

        Mockito.when(mockCriteriaQuery.from(Mockito.eq(UserStoryRequirementData.class))).thenReturn(mockRoot);
        Mockito.when(mockCriteriaQuery.select(Mockito.eq(mockRoot))).thenReturn(mockCriteriaQuery);
        Mockito.when(mockEntityManager.createQuery(Mockito.eq(mockCriteriaQuery))).thenReturn(mockTypedQuery);
        Mockito.when(mockTypedQuery.getResultList()).thenReturn(userStoryRequirementDataList);

        // Mock out the update call
        Mockito.when(mockEntityManager.merge(mockUserStoryRequirementData1)).thenReturn(mockUserStoryRequirementData1);

        // Mock out the delete call
        Mockito.when(mockUserStoryRequirementData1.getUserStoryData()).thenReturn(mockUserStoryData);
    }

    @Test
    public void testDefaultDaoImplConstructor() {
        UserStoryRequirementDataDaoImpl userStoryRequirementDataDaoImpl = new UserStoryRequirementDataDaoImpl();
        Assert.assertNotNull(userStoryRequirementDataDaoImpl);
    }

    @Test
    public void testCreateUserStoryRequirementData() {
        UserStoryRequirementData result = userStoryRequirementDataDaoImpl.createUserStoryRequirementData(mockUserStoryRequirementData1);
        Assert.assertNotNull(result);
        Mockito.verify(mockEntityManager).persist(mockUserStoryRequirementData1);
    }

    @Test
    public void testReadUserStoryRequirementData() {
        UserStoryRequirementData result = userStoryRequirementDataDaoImpl.readUserStoryRequirementData(id);
        Assert.assertEquals(mockUserStoryRequirementData1, result);
    }

    @Test
    public void testReadUserStoryRequirementDataList() {
        List<UserStoryRequirementData> userStoryRequirementDataList = userStoryRequirementDataDaoImpl.readUserStoryRequirementDataList();
        Assert.assertEquals(new Integer(3), new Integer(userStoryRequirementDataList.size()));
        Assert.assertEquals(mockUserStoryRequirementData1, userStoryRequirementDataList.get(0));
        Assert.assertEquals(mockUserStoryRequirementData2, userStoryRequirementDataList.get(1));
        Assert.assertEquals(mockUserStoryRequirementData3, userStoryRequirementDataList.get(2));
    }

    @Test
    public void testUpdateUserStoryRequirementData() {
        UserStoryRequirementData result = userStoryRequirementDataDaoImpl.updateUserStoryRequirementData(mockUserStoryRequirementData1);
        Assert.assertNotNull(result);
        Mockito.verify(mockEntityManager).merge(mockUserStoryRequirementData1);
        Mockito.verify(mockEntityManager).persist(mockUserStoryRequirementData1);
    }

    @Test
    public void testDeleteUserStoryRequirementData() {
        userStoryRequirementDataDaoImpl.deleteUserStoryRequirementData(mockUserStoryRequirementData1);
        Mockito.verify(mockEntityManager).remove(mockUserStoryRequirementData1);
    }
}
