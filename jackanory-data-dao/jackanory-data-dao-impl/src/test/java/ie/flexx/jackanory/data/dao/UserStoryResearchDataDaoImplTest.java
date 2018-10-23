package ie.flexx.jackanory.data.dao;

import ie.flexx.jackanory.data.UserStoryData;
import ie.flexx.jackanory.data.UserStoryRequirementData;
import ie.flexx.jackanory.data.UserStoryResearchData;
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

public class UserStoryResearchDataDaoImplTest {
    private UserStoryResearchDataDaoImpl userStoryResearchDataDaoImpl;
    private EntityManager mockEntityManager;
    private UserStoryResearchData mockUserStoryResearchData1;
    private UserStoryResearchData mockUserStoryResearchData2;
    private UserStoryResearchData mockUserStoryResearchData3;
    private UserStoryData mockUserStoryData;
    private UserStoryRequirementData mockUserStoryRequirementData;
    private Long id = new Long(1);

    @Before
    public void setUp() throws Exception {
        userStoryResearchDataDaoImpl = new UserStoryResearchDataDaoImpl();
        mockEntityManager = Mockito.mock(EntityManager.class);
        userStoryResearchDataDaoImpl.setEntityManager(mockEntityManager);

        mockUserStoryResearchData1 = Mockito.mock(UserStoryResearchData.class);
        mockUserStoryResearchData2 = Mockito.mock(UserStoryResearchData.class);
        mockUserStoryResearchData3 = Mockito.mock(UserStoryResearchData.class);

        mockUserStoryData = Mockito.mock(UserStoryData.class);
        mockUserStoryRequirementData = Mockito.mock(UserStoryRequirementData.class);

        List<UserStoryResearchData> userStoryResearchDataList = new ArrayList<UserStoryResearchData>();
        userStoryResearchDataList.add(mockUserStoryResearchData1);
        userStoryResearchDataList.add(mockUserStoryResearchData2);
        userStoryResearchDataList.add(mockUserStoryResearchData3);

        // Mock out the read call
        Mockito.when(mockEntityManager.find(Mockito.eq(UserStoryResearchData.class), Mockito.eq(id))).thenReturn(mockUserStoryResearchData1);

        // Mock out the read list call
        CriteriaBuilder mockCriteriaBuilder = Mockito.mock(CriteriaBuilder.class);
        CriteriaQuery mockCriteriaQuery = Mockito.mock(CriteriaQuery.class);
        Root mockRoot = Mockito.mock(Root.class);
        TypedQuery mockTypedQuery = Mockito.mock(TypedQuery.class);

        Mockito.when(mockEntityManager.getCriteriaBuilder()).thenReturn(mockCriteriaBuilder);
        Mockito.when(mockCriteriaBuilder.createQuery(Mockito.eq(UserStoryResearchData.class))).thenReturn(mockCriteriaQuery);

        Mockito.when(mockCriteriaQuery.from(Mockito.eq(UserStoryResearchData.class))).thenReturn(mockRoot);
        Mockito.when(mockCriteriaQuery.select(Mockito.eq(mockRoot))).thenReturn(mockCriteriaQuery);
        Mockito.when(mockEntityManager.createQuery(Mockito.eq(mockCriteriaQuery))).thenReturn(mockTypedQuery);
        Mockito.when(mockTypedQuery.getResultList()).thenReturn(userStoryResearchDataList);

        // Mock out the update call
        Mockito.when(mockEntityManager.merge(mockUserStoryResearchData1)).thenReturn(mockUserStoryResearchData1);

        // Mock out the delete call
        Mockito.when(mockUserStoryResearchData1.getUserStoryData()).thenReturn(mockUserStoryData);
    }

    @Test
    public void testDefaultDaoImplConstructor() {
        UserStoryResearchDataDaoImpl userStoryResearchDataDaoImpl = new UserStoryResearchDataDaoImpl();
        Assert.assertNotNull(userStoryResearchDataDaoImpl);
    }

    @Test
    public void testCreateUserStoryResearchData() {
        UserStoryResearchData result = userStoryResearchDataDaoImpl.createUserStoryResearchData(mockUserStoryResearchData1);
        Assert.assertNotNull(result);
        Mockito.verify(mockEntityManager).persist(mockUserStoryResearchData1);
    }

    @Test
    public void testReadUserStoryResearchData() {
        UserStoryResearchData result = userStoryResearchDataDaoImpl.readUserStoryResearchData(id);
        Assert.assertEquals(mockUserStoryResearchData1, result);
    }

    @Test
    public void testReadUserStoryResearchDataList() {
        List<UserStoryResearchData> userStoryResearchDataList = userStoryResearchDataDaoImpl.readUserStoryResearchDataList();
        Assert.assertEquals(new Integer(3), new Integer(userStoryResearchDataList.size()));
        Assert.assertEquals(mockUserStoryResearchData1, userStoryResearchDataList.get(0));
        Assert.assertEquals(mockUserStoryResearchData2, userStoryResearchDataList.get(1));
        Assert.assertEquals(mockUserStoryResearchData3, userStoryResearchDataList.get(2));
    }

    @Test
    public void testUpdateUserStoryResearchData() {
        UserStoryResearchData result = userStoryResearchDataDaoImpl.updateUserStoryResearchData(mockUserStoryResearchData1);
        Assert.assertNotNull(result);
        Mockito.verify(mockEntityManager).merge(mockUserStoryResearchData1);
        Mockito.verify(mockEntityManager).persist(mockUserStoryResearchData1);
    }

    @Test
    public void testDeleteUserStoryResearchData() {
        userStoryResearchDataDaoImpl.deleteUserStoryResearchData(mockUserStoryResearchData1);
        Mockito.verify(mockEntityManager).remove(mockUserStoryResearchData1);
    }
}
