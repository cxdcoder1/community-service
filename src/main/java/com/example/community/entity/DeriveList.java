package com.example.community.entity;

import java.util.ArrayList;
import java.util.List;

public class DeriveList {

    private List<String> list = new ArrayList<>();

    public DeriveList() {
    }

    public DeriveList(List<String> list) {
        this.list = list;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }
}
