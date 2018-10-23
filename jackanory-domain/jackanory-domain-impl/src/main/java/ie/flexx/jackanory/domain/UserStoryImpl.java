package ie.flexx.jackanory.domain;

import ie.flexx.jackanory.data.UserStoryData;
import ie.flexx.jackanory.data.UserStoryRequirementData;
import ie.flexx.jackanory.data.UserStoryResearchData;
import org.apache.commons.collections.set.ListOrderedSet;

import java.util.*;

public class UserStoryImpl implements UserStory {
    private UserStoryData userStoryData;
    private List<UserStoryRequirement> userStoryRequirementList;
    private Set<UserStoryResearch> userStoryResearchSet;

    /**
     * No argument constructor for UserStoryImpl used when creating an new domain object.
     */
    public UserStoryImpl() {
        userStoryData = new UserStoryData();
    }

    /**
     * Constructor for UserStoryImpl used by JPA
     *
     * @param userStoryData domain retrieved by the database
     */
    public UserStoryImpl(UserStoryData userStoryData) {
        if (userStoryData == null) throw new IllegalArgumentException("userStoryData should not be null.");
        this.userStoryData = userStoryData;
    }

    @Override
    public Long getId() {
        return getUserStoryData().getId();
    }

    @Override
    public String getDisplayName() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getName());
        stringBuilder.append(", ");
        stringBuilder.append(getDescription());
        stringBuilder.append(" (");
        stringBuilder.append(getCategory());
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    @Override
    public Long getVersion() {
        return getUserStoryData().getVersion();
    }

    @Override
    public void setVersion(Long version) {
        getUserStoryData().setVersion(version);
    }
    //Correction Vinicius Meireles
    @Override
    public String getName() {return getUserStoryData().getName(); };

    @Override
    public void setName(String name) {
        getUserStoryData().setName(name);
    }

    @Override
    public String getDescription() {
        return getUserStoryData().getDescription();
    }

    @Override
    public void setDescription(String description) {
        getUserStoryData().setDescription(description);
    }

    @Override
    public String getCategory() {
        return getUserStoryData().getCategory();
    }

    @Override
    public void setCategory(String category) {
        getUserStoryData().setCategory(category);
    }

    @Override
    public String getSubCategory() {
        return getUserStoryData().getSubCategory();
    }

    @Override
    public void setSubCategory(String subCategory) {
        getUserStoryData().setSubCategory(subCategory);
    }

    @Override
    public Date getStartDate() {
        return getUserStoryData().getStartDate();
    }

    @Override
    public void setStartDate(Date startDate) {
        getUserStoryData().setStartDate(startDate);
    }

    @Override
    public Date getAssignedDate() {
        return getUserStoryData().getAssignedDate();
    }

    @Override
    public void setAssignedDate(Date assignedDate) {
        getUserStoryData().setAssignedDate(assignedDate);
    }

    @Override
    public String getSponsorEmail() {
        return getUserStoryData().getSponsorEmail();
    }

    @Override
    public void setSponsorEmail(String sponsorEmail) {
        getUserStoryData().setSponsorEmail(sponsorEmail);
    }

    @Override
    public String getComplexity() {
        return getUserStoryData().getComplexity();
    }

    @Override
    public void setComplexity(String complexity) {
        getUserStoryData().setComplexity(complexity);
    }
    //Implementation Vinicius Meireles
    @Override
    public String getNotes() {
        return getUserStoryData().getNotes();
    }

    @Override
    public void setNotes(String notes) {
        getUserStoryData().setNotes(notes);
    }

    public UserStoryData getUserStoryData() {
        return userStoryData;
    }

    @Override
    public List<UserStoryRequirement> getUserStoryRequirementList() {
        if (userStoryRequirementList == null) {
            List<UserStoryRequirement> tempUserStoryRequirementList = new ArrayList<>();
            for (UserStoryRequirementData userStoryRequirementData : getUserStoryData().getUserStoryRequirementDataList()) {
                tempUserStoryRequirementList.add(new UserStoryRequirementImpl(userStoryRequirementData, this));
            }
            userStoryRequirementList = Collections.unmodifiableList(tempUserStoryRequirementList);
        }
        return userStoryRequirementList;
    }

    @Override
    public void addUserStoryRequirement(UserStoryRequirement userStoryRequirement) {
        getUserStoryData().addUserStoryRequirementData(UserStoryRequirementDataAccessor.getUserStoryRequirementData(userStoryRequirement));
        // Flush the list
        userStoryRequirementList = null;
    }

    @Override
    public void removeUserStoryRequirement(UserStoryRequirement userStoryRequirement) {
        getUserStoryData().removeUserStoryRequirementData(UserStoryRequirementDataAccessor.getUserStoryRequirementData(userStoryRequirement));
        // Flush the list
        userStoryRequirementList = null;
    }

    @Override
    public Set<UserStoryResearch> getUserStoryResearchSet() {
        if (userStoryResearchSet == null) {
            Set<UserStoryResearch> tempUserStoryResearchSet = ListOrderedSet.decorate(new HashSet());
            for (UserStoryResearchData userStoryResearchData : getUserStoryData().getUserStoryResearchDataSet()) {
                tempUserStoryResearchSet.add(new UserStoryResearchImpl(userStoryResearchData, this));
            }
            userStoryResearchSet = Collections.unmodifiableSet(tempUserStoryResearchSet);
        }
        return userStoryResearchSet;
    }

    @Override
    public void addUserStoryResearch(UserStoryResearch userStoryResearch) {
        getUserStoryData().addUserStoryResearchData(UserStoryResearchDataAccessor.getUserStoryResearchData(userStoryResearch));
        // Flush the list
        userStoryResearchSet = null;
    }

    @Override
    public void removeUserStoryResearch(UserStoryResearch userStoryResearch) {
        getUserStoryData().removeUserStoryResearchData(UserStoryResearchDataAccessor.getUserStoryResearchData(userStoryResearch));
        // Flush the list
        userStoryResearchSet = null;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserStoryImpl that = (UserStoryImpl) o;

        if (!userStoryData.equals(that.userStoryData)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return userStoryData.hashCode();
    }
}