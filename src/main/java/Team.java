/**
 * Author:    Danial Sheikh
 * The Team Class is used to create an object to store the Json data coming in
 **/
import com.google.gson.annotations.SerializedName;

public class Team {
    @SerializedName("all-matches")
    AllMatches allMatches;
    String name;
    @SerializedName("total-points")
    int totalPoints;

    public int getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(int totalPoints) {
        this.totalPoints = totalPoints;
    }

    public AllMatches getMatchdata() {
        return allMatches;
    }

    public void setMatchdata(AllMatches matchdata) {
        this.allMatches = matchdata;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
