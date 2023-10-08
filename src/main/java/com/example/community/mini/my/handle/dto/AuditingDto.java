package com.example.community.mini.my.handle.dto;


import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 审批提交的Dto
 */
public class AuditingDto implements Serializable {
    @NotNull(message = "绑定Id不能为空")
    private Long ownerRoomId;

    private boolean pass;

    private String opinion;


    public Long getOwnerRoomId() {
        return ownerRoomId;
    }

    public void setOwnerRoomId(Long ownerRoomId) {
        this.ownerRoomId = ownerRoomId;
    }

    public boolean isPass() {
        return pass;
    }

    public void setPass(boolean pass) {
        this.pass = pass;
    }

    public String getOpinion() {
        return opinion;
    }

    public void setOpinion(String opinion) {
        this.opinion = opinion;
    }
}
