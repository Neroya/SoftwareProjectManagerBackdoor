package cn.edu.xjtu.stu.orangesoft.backdoor.pojo;

import org.springframework.stereotype.Component;

@Component
public class GroupAssess {
    private int TeamID;
    private int Score;
    private String TeamAssess;
    private int AssessorID;

    public void setTeamID(int teamID) {
        TeamID = teamID;
    }

    public void setScore(int score) {
        Score = score;
    }

    public void setTeamAssess(String teamAssess) {
        TeamAssess = teamAssess;
    }

    public void setAssessorID(int assessorID) {
        AssessorID = assessorID;
    }

    public int getTeamID() {
        return TeamID;
    }

    public int getScore() {
        return Score;
    }

    public String getTeamAssess() {
        return TeamAssess;
    }

    public int getAssessorID() {
        return AssessorID;
    }
}
