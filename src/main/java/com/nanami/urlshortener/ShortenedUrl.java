package com.nanami.urlshortener;

public class ShortenedUrl {
    private final String shortenedUrl;
    private final String targetUrl;

    public ShortenedUrl(String shortenedUrl, String targetUrl) {
        this.shortenedUrl = shortenedUrl;
        this.targetUrl = targetUrl;
    }

    public String getShortenedUrl() {
        return shortenedUrl;
    }

    public String getTargetUrl() {
        return targetUrl;
    }
}

