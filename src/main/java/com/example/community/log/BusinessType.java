package com.example.community.log;

/**
 * 业务操作类型
 *
 * @author ruoyi
 */
public enum BusinessType {

    OTHER(0),

    INSERT(1),

    UPDATE(2),

    DELETE(3),

    GRANT(4),

    EXPORT(5),

    IMPORT(6),

    FORCE(7),

    GENCODE(8),

    CLEAN(9);

    private int key;

    BusinessType(int key) {
        this.key = key;
    }

    public int getKey() {
        return key;
    }
}
