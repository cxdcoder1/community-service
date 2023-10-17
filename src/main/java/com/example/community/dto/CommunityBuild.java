package com.example.community.dto;

/**
 * @author zhf
 */
public class CommunityBuild {
    private String  communityName;
    private String buildNum;

    public String getCommunityName() {
        return communityName;
    }

    public void setCommunityName(String communityName) {
        this.communityName = communityName;
    }

    public String getBuildNum() {
        return buildNum;
    }

    public void setBuildNum(String buildNum) {
        this.buildNum = buildNum;
    }

    @Override
    public String toString() {
        return "CommunityBuild{" +
                "communityName='" + communityName + '\'' +
                ", buildNum='" + buildNum + '\'' +
                '}';
    }
}
