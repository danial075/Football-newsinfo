public class GoalscorerHistory {
int rank;
String name;
String nationality;
String stat;
    public GoalscorerHistory(int rank,String name,String nationality,String stat) {
        this.rank = rank;
        this.name = name;
        this.nationality = nationality;
        this.stat = stat;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }
}
