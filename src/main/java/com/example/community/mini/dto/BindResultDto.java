package com.example.community.mini.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BindResultDto implements Serializable {

    private List<BindCommonDto> applyList = new ArrayList<>();//申请中的绑定信息

    private List<BindCommonDto> bindList = new ArrayList<>();//已绑定的信息

    private List<BindCommonDto> rejectList = new ArrayList<>();//已拒绝的绑定信息


    public List<BindCommonDto> getApplyList() {
        return applyList;
    }

    public void setApplyList(List<BindCommonDto> applyList) {
        this.applyList = applyList;
    }

    public List<BindCommonDto> getBindList() {
        return bindList;
    }

    public void setBindList(List<BindCommonDto> bindList) {
        this.bindList = bindList;
    }

    public List<BindCommonDto> getRejectList() {
        return rejectList;
    }

    public void setRejectList(List<BindCommonDto> rejectList) {
        this.rejectList = rejectList;
    }
}
