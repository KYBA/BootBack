package com.example.demo.entity.resp;

import lombok.Data;

@Data
public class CharityVO {

    private Long charityId;

    private String charityName;

    private String charitySize;

    private String charityWebsite;

    private int charityAge;

    private String state;

    public Long getCharityId() {
        return charityId;
    }

    public void setCharityId(Long charityId) {
        this.charityId = charityId;
    }

    public String getCharityName() {
        return charityName;
    }

    public void setCharityName(String charityName) {
        this.charityName = charityName;
    }

    public String getCharitySize() {
        return charitySize;
    }

    public void setCharitySize(String charitySize) {
        this.charitySize = charitySize;
    }

    public String getCharityWebsite() {
        return charityWebsite;
    }

    public void setCharityWebsite(String charityWebsite) {
        this.charityWebsite = charityWebsite;
    }

    public int getCharityAge() {
        return charityAge;
    }

    public void setCharityAge(int charityAge) {
        this.charityAge = charityAge;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
