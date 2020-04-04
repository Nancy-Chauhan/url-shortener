package com.main.urlshortener;

import org.hashids.Hashids;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UrlShortenerService {
    private UrlRepository urlRepository;

    @Autowired
    public UrlShortenerService(UrlRepository urlRepository, Hashids hashids) {
        this.urlRepository = urlRepository;
        this.hashids = hashids;
    }

    private Hashids hashids;


    public ShortenedUrl shorten(String targetUrl) {
        var url = new Url(targetUrl);
        urlRepository.save(url);


        String shortenedUrl = hashids.encode(url.getId());
        return new ShortenedUrl(shortenedUrl, targetUrl);
    }

    public Optional<Url> resolve(String shortenedUrl) {
        long[] id = hashids.decode(shortenedUrl);
        return urlRepository.findById(id[0]);
    }
}
