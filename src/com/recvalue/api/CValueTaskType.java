package com.recvalue.api;

/**
 * CValue 门面层公开的稳定任务类型标识。
 * Stable task-type identifiers exposed by the CValue facade.
 */
public enum CValueTaskType {
    MAIN_DBC("mainDBC");

    private final String key;

    CValueTaskType(String key) {
        this.key = key;
    }

    /**
     * 返回底层 mission-sync 数据里使用的任务类型 key。
     * Returns the task-type key used by the underlying mission-sync payload.
     */
    public String key() {
        return key;
    }
}
