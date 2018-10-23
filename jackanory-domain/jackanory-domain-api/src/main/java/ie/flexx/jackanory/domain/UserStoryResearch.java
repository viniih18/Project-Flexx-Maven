package ie.flexx.jackanory.domain;

import java.util.List;
import java.util.Set;

public interface UserStoryResearch {

    public Long getId();

    public String getDisplayName();

    public Long getVersion();

    public void setVersion(Long version);

    public String getResearch();

    public void setResearch(String research);

    public String getSource();

    public void setSource(String source);

    public UserStory getUserStory();

    public List<UserStoryRequirement> getUserStoryRequirementList();

    public void addUserStoryRequirement(UserStoryRequirement userStoryRequirement);

    public void removeUserStoryRequirement(UserStoryRequirement userStoryRequirement);

}