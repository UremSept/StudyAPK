package com.example.houjie.studyapk.studyhttp.Bean;

/**
 * Created by houjie on 2016/5/6.
 */
public class PageResult {
    private NovelPage result;
    private String reason;
    public NovelPage getResult() {
        return result;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public void setResult(NovelPage result) {
        this.result = result;
    }
}
