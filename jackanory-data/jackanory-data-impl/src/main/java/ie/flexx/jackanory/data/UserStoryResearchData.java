package ie.flexx.jackanory.data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user_story_research")
public class UserStoryResearchData implements Serializable {

    private Long id;
    private Long version;
    private String research;
    private String source;

    private UserStoryData userStoryData;
    //Implementation Vinicius Meireles
    private List<UserStoryRequirementData> userStoryRequirementDataList;

    /**
     * No Attribute Constructor
     */
    public UserStoryResearchData() {
    }

    /**
     * Required Attribute Constructor
     */
    public UserStoryResearchData(
            String research

    ) {
        this.research = research;
    }

    @Id
    @GeneratedValue
    @Column(name = "user_story_research_id")
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

    @Column(name = "research", nullable = false)
    public String getResearch() {
        return research;
    }

    public void setResearch(String research) {
        this.research = research;
    }

    @Column(name = "source")
    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    //Implementation Vinicius Meireles
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true, mappedBy = "userStoryData", targetEntity = UserStoryRequirementData.class)
    @OrderColumn(name = "sequence_no")
    public List<UserStoryRequirementData> getUserStoryRequirementDataList(){
        if(userStoryRequirementDataList == null){
            userStoryRequirementDataList = new ArrayList<>();
        }
        return userStoryRequirementDataList;
    }

    public void setUserStoryRequirementDataList(List<UserStoryRequirementData> userStoryRequirementDataList) {
        this.userStoryRequirementDataList = userStoryRequirementDataList;
    }

    public void addUserStoryRequirementData(UserStoryRequirementData userStoryRequirementData) {
        getUserStoryRequirementDataList().add(userStoryRequirementData);
        userStoryRequirementData.setUserStoryResearchData(this);
    }

    public void removeUserStoryRequirementData(UserStoryRequirementData userStoryRequirementData) {
        getUserStoryRequirementDataList().remove(userStoryRequirementData);
        userStoryRequirementData.setUserStoryResearchData(null);
    }


    public UserStoryData getUserStoryData() {
        return userStoryData;
    }

    public void setUserStoryData(UserStoryData userStoryData) {
        this.userStoryData = userStoryData;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserStoryResearchData that = (UserStoryResearchData) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : super.hashCode();
    }
}
