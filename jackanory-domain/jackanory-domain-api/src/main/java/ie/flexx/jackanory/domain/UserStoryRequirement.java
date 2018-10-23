package ie.flexx.jackanory.domain;

import java.util.List;
import java.util.Set;

public interface UserStoryRequirement {

    public Long getId();

    public String getDisplayName();

    public Long getVersion();

    public void setVersion(Long version);

    public String getRequirement();

    public void setRequirement(String requirement);

    public UserStory getUserStory();

}