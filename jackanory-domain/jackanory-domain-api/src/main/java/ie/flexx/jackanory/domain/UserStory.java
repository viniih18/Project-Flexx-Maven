package ie.flexx.jackanory.domain;

import java.util.Date;
import java.util.List;
import java.util.Set;

public interface UserStory {

    public Long getId();

    public String getDisplayName();

    public Long getVersion();

    public void setVersion(Long version);

    public String getName();

    public void setName(String name);


    public String getDescription();

    public void setDescription(String description);

    public String getCategory();

    public void setCategory(String category);

    public String getSubCategory();

    public void setSubCategory(String subCategory);

    public Date getStartDate();

    public void setStartDate(Date startDate);

    public Date getAssignedDate();

    public void setAssignedDate(Date assignedDate);

    public String getSponsorEmail();

    public void setSponsorEmail(String sponsorEmail);

    public String getComplexity();

    public void setComplexity(String complexity);
    //Implementation Vinicius Meireles
    public String getNotes();

    public void setNotes(String notes);

    public List<UserStoryRequirement> getUserStoryRequirementList();

    public void addUserStoryRequirement(UserStoryRequirement userStoryRequirement);

    public void removeUserStoryRequirement(UserStoryRequirement userStoryRequirement);

    public Set<UserStoryResearch> getUserStoryResearchSet();

    public void addUserStoryResearch(UserStoryResearch userStoryResearch);

    public void removeUserStoryResearch(UserStoryResearch userStoryResearch);

}