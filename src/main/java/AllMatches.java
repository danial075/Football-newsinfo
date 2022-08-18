import com.google.gson.annotations.SerializedName;

/**
 * Author:    Danial Sheikh
 * The Allmatches Class is used to create an object to store the Json data from the json field all-matches which links with the Team class
 **/

public class AllMatches {
  int lost;
  int against;
  @SerializedName("goal-difference")    // The @SerializedName allows me to deal with the field names which clash aka don't work when written in java. It clearly indicates what should be Deserialized
  int GoalDifference;
  int won;
  int For;
  int drawn;
  int played;

  public AllMatches(int lost,int against,int GoalDifference,int won,int For,int drawn,int played) {
    this.lost = lost;
    this.against = against;
    this.GoalDifference = GoalDifference;
    this.won = won;
    this.For = For;
    this.drawn = drawn;
    this.played = played;
  }

  public int getLost() {
    return lost;
  }

  public void setLost(int lost) {
    this.lost = lost;
  }

  public int getAgainst() {
    return against;
  }

  public void setAgainst(int against) {
    this.against = against;
  }

  public int getGoalDifference() {
    return GoalDifference;
  }

  public void setGoalDifference(int goalDifference) {
    this.GoalDifference = goalDifference;
  }

  public int getWon() {
    return won;
  }

  public void setWon(int won) {
    this.won = won;
  }

  public int getFor() {
    return For;
  }

  public void setFor(int aFor) {
    For = aFor;
  }

  public int getDrawn() {
    return drawn;
  }

  public void setDrawn(int drawn) {
    this.drawn = drawn;
  }

  public int getPlayed() {
    return played;
  }

  public void setPlayed(int played) {
    this.played = played;
  }
}
