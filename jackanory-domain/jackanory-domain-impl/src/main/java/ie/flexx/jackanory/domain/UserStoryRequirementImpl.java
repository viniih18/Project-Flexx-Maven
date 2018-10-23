package ie.flexx.jackanory.domain;

import ie.flexx.jackanory.data.UserStoryData;
import ie.flexx.jackanory.data.UserStoryRequirementData;
import ie.flexx.jackanory.data.UserStoryResearchData;
import org.apache.commons.collections.set.ListOrderedSet;

import java.util.*;

public class UserStoryRequirementImpl implements UserStoryRequirement {
    private UserStoryRequirementData userStoryRequirementData;
    private List<UserStoryRequirement> userStoryRequirementList;
    private UserStory userStory;

    private Set<UserStoryResearch> userStoryResearchSet;

    /**
     * No argument constructor for UserStoryRequirementImpl used when creating an new domain object.
     */
    public UserStoryRequirementImpl() {
        userStoryRequirementData = new UserStoryRequirementData();
    }

    /**
     * Constructor for UserStoryRequirementImpl used by JPA
     *
     * @param userStoryRequirementData domain retrieved by the database
     */
    public UserStoryRequirementImpl(UserStoryRequirementData userStoryRequirementData) {
        if (userStoryRequirementData == null) throw new IllegalArgumentException("userStoryRequirementData should not be null.");
        this.userStoryRequirementData = userStoryRequirementData;
    }

    /**
     * Constructor for UserStoryRequirementImpl used when accessing via uniqueManyToOneRelationshipSet to
     * retrieving the children for the userStory
     *
     * @param userStoryRequirementData domain child object to be constructed
     * @param userStory                domain parent object
     */
    public UserStoryRequirementImpl(UserStoryRequirementData userStoryRequirementData, UserStory userStory) {
        if (userStoryRequirementData == null) throw new IllegalArgumentException("userStoryRequirementData should not be null.");
        if (userStory == null) throw new IllegalArgumentException("userStory should not be null.");
        this.userStoryRequirementData = userStoryRequirementData;
        this.userStory = userStory;
    }

    /**
     * Constructor for UserStoryRequirementImpl used when accessing via uniqueManyToOneRelationshipSet to
     * retrieving the children for the userStoryResearch
     *
     * @param userStoryRequirementData domain child object to be constructed
     * @param userStoryResearch                domain parent object
     */
    public UserStoryRequirementImpl(UserStoryRequirementData userStoryRequirementData, UserStoryResearch userStoryResearch) {
        if (userStoryRequirementData == null) throw new IllegalArgumentException("userStoryRequirementData should not be null.");
        if (userStory == null) throw new IllegalArgumentException("userStory should not be null.");
        this.userStoryRequirementData = userStoryRequirementData;
        this.userStory = userStory;
    }

    @Override
    public Long getId() {
        return getUserStoryRequirementData().getId();
    }

    @Override
    public String getDisplayName() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getVersion());
        stringBuilder.append(" ");
        stringBuilder.append("%");
        stringBuilder.append(" (");
        stringBuilder.append(getRequirement());
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    @Override
    public Long getVersion() {
        return getUserStoryRequirementData().getVersion();
    }

    @Override
    public void setVersion(Long version) {
        getUserStoryRequirementData().setVersion(version);
    }

    @Override
    public String getRequirement() {
        return getUserStoryRequirementData().getRequirement();
    }

    @Override
    public void setRequirement(String requirement) {
        getUserStoryRequirementData().setRequirement(requirement);
    }


    public UserStoryRequirementData getUserStoryRequirementData() {
        return userStoryRequirementData;
    }

    @Override
    public UserStory getUserStory() {
        if (userStory == null) {
            UserStoryData userStoryData = getUserStoryRequirementData().getUserStoryData();
            if (userStoryData != null) {
                userStory = new UserStoryImpl(userStoryData);
            }
        }
        return userStory;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserStoryRequirementImpl that = (UserStoryRequirementImpl) o;

        if (!userStoryRequirementData.equals(that.userStoryRequirementData)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return userStoryRequirementData.hashCode();
    }
}