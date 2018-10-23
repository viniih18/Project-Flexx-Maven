package ie.flexx.jackanory.data.dao;

import ie.flexx.jackanory.data.UserStoryData;
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

public class UserStoryDataDaoImplTest {
    private UserStoryDataDaoImpl userStoryDataDaoImpl;
    private EntityManager mockEntityManager;
    private UserStoryData mockUserStoryData1;
    private UserStoryData mockUserStoryData2;
    private UserStoryData mockUserStoryData3;
    private Long id = new Long(1);

    @Before
    public void setUp() throws Exception {
        userStoryDataDaoImpl = new UserStoryDataDaoImpl();
        mockEntityManager = Mockito.mock(EntityManager.class);
        userStoryDataDaoImpl.setEntityManager(mockEntityManager);

        mockUserStoryData1 = Mockito.mock(UserStoryData.class);
        mockUserStoryData2 = Mockito.mock(UserStoryData.class);
        mockUserStoryData3 = Mockito.mock(UserStoryData.class);

        List<UserStoryData> userStoryDataList = new ArrayList<UserStoryData>();
        userStoryDataList.add(mockUserStoryData1);
        userStoryDataList.add(mockUserStoryData2);
        userStoryDataList.add(mockUserStoryData3);

        // Mock out the read call
        Mockito.when(mockEntityManager.find(Mockito.eq(UserStoryData.class), Mockito.eq(id))).thenReturn(mockUserStoryData1);

        // Mock out the read list call
        CriteriaBuilder mockCriteriaBuilder = Mockito.mock(CriteriaBuilder.class);
        CriteriaQuery mockCriteriaQuery = Mockito.mock(CriteriaQuery.class);
        Root mockRoot = Mockito.mock(Root.class);
        TypedQuery mockTypedQuery = Mockito.mock(TypedQuery.class);

        Mockito.when(mockEntityManager.getCriteriaBuilder()).thenReturn(mockCriteriaBuilder);
        Mockito.when(mockCriteriaBuilder.createQuery(Mockito.eq(UserStoryData.class))).thenReturn(mockCriteriaQuery);

        Mockito.when(mockCriteriaQuery.from(Mockito.eq(UserStoryData.class))).thenReturn(mockRoot);
        Mockito.when(mockCriteriaQuery.select(Mockito.eq(mockRoot))).thenReturn(mockCriteriaQuery);
        Mockito.when(mockEntityManager.createQuery(Mockito.eq(mockCriteriaQuery))).thenReturn(mockTypedQuery);
        Mockito.when(mockTypedQuery.getResultList()).thenReturn(userStoryDataList);

        // Mock out the update call
        Mockito.when(mockEntityManager.merge(mockUserStoryData1)).thenReturn(mockUserStoryData1);
    }

    @Test
    public void testDefaultDaoImplConstructor() {
        UserStoryDataDaoImpl userStoryDataDaoImpl = new UserStoryDataDaoImpl();
        Assert.assertNotNull(userStoryDataDaoImpl);
    }

    @Test
    public void testCreateUserStoryData() {
        UserStoryData result = userStoryDataDaoImpl.createUserStoryData(mockUserStoryData1);
        Assert.assertNotNull(result);
        Mockito.verify(mockEntityManager).persist(mockUserStoryData1);
    }

    @Test
    public void testReadUserStoryData() {
        UserStoryData result = userStoryDataDaoImpl.readUserStoryData(id);
        Assert.assertEquals(mockUserStoryData1, result);
    }

    @Test
    public void testReadUserStoryDataList() {
        List<UserStoryData> userStoryDataList = userStoryDataDaoImpl.readUserStoryDataList();
        Assert.assertEquals(new Integer(3), new Integer(userStoryDataList.size()));
        Assert.assertEquals(mockUserStoryData1, userStoryDataList.get(0));
        Assert.assertEquals(mockUserStoryData2, userStoryDataList.get(1));
        Assert.assertEquals(mockUserStoryData3, userStoryDataList.get(2));
    }

    @Test
    public void testUpdateUserStoryData() {
        UserStoryData result = userStoryDataDaoImpl.updateUserStoryData(mockUserStoryData1);
        Assert.assertNotNull(result);
        Mockito.verify(mockEntityManager).merge(mockUserStoryData1);
        Mockito.verify(mockEntityManager).persist(mockUserStoryData1);
    }

    @Test
    public void testDeleteUserStoryData() {
        userStoryDataDaoImpl.deleteUserStoryData(mockUserStoryData1);
        Mockito.verify(mockEntityManager).remove(mockUserStoryData1);
    }
}
