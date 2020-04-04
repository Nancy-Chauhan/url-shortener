package com.nanami.urlshortener;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Url {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String targetUrl;

    protected Url() {
    }

    public Url(String targetUrl) {
        this.targetUrl = targetUrl;
    }

    public Long getId() {
        return id;
    }

    public String getTargetUrl() {
        return targetUrl;
    }

    @Override
    public String toString() {
        return "Url{" +
                "id=" + id +
                ", targetUrl='" + targetUrl + '\'' +
                '}';
    }
}
