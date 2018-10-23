package ie.flexx.jackanory.data;

import org.apache.commons.collections.set.ListOrderedSet;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "user_story")
public class UserStoryData implements Serializable {

    private Long id;
    private Long version;
    private String description;
    private String category;
    private String subCategory;
    private Date startDate;
    private Date assignedDate;
    private String sponsorEmail;
    private String complexity;
    private String workflowState;
    //Correction (Test1) Vinicius Meireles
    private String name;
    //Correction (Test2) Vinicius Meireles
    private String notes;


    private List<UserStoryRequirementData> userStoryRequirementDataList;
    private Set<UserStoryResearchData> userStoryResearchDataSet;

    /**
     * No Attribute Constructor
     */
    public UserStoryData() {
    }

    /**
     * Required Attribute Constructor
     */
    public UserStoryData(
            String name,
            String description,
            String category

    ) {
        this.name = name;
        this.description = description;
        this.category = category;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "user_story_id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Version
    @Column(name = "version")
    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "description", nullable = false)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "category", nullable = false)
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Column(name = "sub_category")
    public String getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(String subCategory) {
        this.subCategory = subCategory;
    }

    @Column(name = "start_date")
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Column(name = "assigned_date")
    public Date getAssignedDate() {
        return assignedDate;
    }

    public void setAssignedDate(Date assignedDate) {
        this.assignedDate = assignedDate;
    }

    @Column(name = "sponsor_email")
    public String getSponsorEmail() {
        return sponsorEmail;
    }

    public void setSponsorEmail(String sponsorEmail) {
        this.sponsorEmail = sponsorEmail;
    }

    @Column(name = "complexity")
    public String getComplexity() {
        return complexity;
    }

    public void setComplexity(String complexity) {
        this.complexity = complexity;
    }

    @Column(name = "workflow_state")
    public String getWorkflowState() {
        return workflowState;
    }

    public void setWorkflowState(String workflowState) {
        this.workflowState = workflowState;
    }

    //Correction (Test2) Vinicius Meireles
    @Column(name = "notes")
    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true, mappedBy = "userStoryData", targetEntity = UserStoryRequirementData.class)
    @OrderColumn(name = "sequence_no")
    public List<UserStoryRequirementData> getUserStoryRequirementDataList() {
        if (userStoryRequirementDataList == null) {
            userStoryRequirementDataList = new ArrayList<>();
        }
        return userStoryRequirementDataList;
    }

    public void setUserStoryRequirementDataList(List<UserStoryRequirementData> userStoryRequirementDataList) {
        this.userStoryRequirementDataList = userStoryRequirementDataList;
    }

    public void addUserStoryRequirementData(UserStoryRequirementData userStoryRequirementData) {
        getUserStoryRequirementDataList().add(userStoryRequirementData);
        userStoryRequirementData.setUserStoryData(this);
    }

    public void removeUserStoryRequirementData(UserStoryRequirementData userStoryRequirementData) {
        getUserStoryRequirementDataList().remove(userStoryRequirementData);
        userStoryRequirementData.setUserStoryData(null);
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true, mappedBy = "userStoryData", targetEntity = UserStoryResearchData.class)
    @OrderBy
    public Set<UserStoryResearchData> getUserStoryResearchDataSet() {
        if (userStoryResearchDataSet == null) {
            userStoryResearchDataSet = ListOrderedSet.decorate(new HashSet());
        }
        return userStoryResearchDataSet;
    }

    public void setUserStoryResearchDataSet(Set<UserStoryResearchData> userStoryResearchDataSet) {
        this.userStoryResearchDataSet = userStoryResearchDataSet;
    }

    public void addUserStoryResearchData(UserStoryResearchData userStoryResearchData) {
        getUserStoryResearchDataSet().add(userStoryResearchData);
        userStoryResearchData.setUserStoryData(this);
    }

    public void removeUserStoryResearchData(UserStoryResearchData userStoryResearchData) {
        getUserStoryResearchDataSet().remove(userStoryResearchData);
        userStoryResearchData.setUserStoryData(null);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserStoryData that = (UserStoryData) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : super.hashCode();
    }
}
