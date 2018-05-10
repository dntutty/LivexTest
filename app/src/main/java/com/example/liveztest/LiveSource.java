package com.example.liveztest;

public class LiveSource {
    private String sourceName;
    private String sourceUri;

    public LiveSource(String sourceName,String sourceUri) {
        this.sourceName = sourceName;
        this.sourceUri = sourceUri;
    }
    public String getSourceName() {
        return sourceName;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }

    public String getSourceUri() {
        return sourceUri;
    }

    public void setSourceUri(String sourceUri) {
        this.sourceUri = sourceUri;
    }
}
