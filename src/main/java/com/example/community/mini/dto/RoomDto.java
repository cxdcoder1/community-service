package com.example.community.mini.dto;

import java.io.Serializable;

/**
 * Room的Dto
 */
public class RoomDto implements Serializable {

    private String label;

    private String value;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
