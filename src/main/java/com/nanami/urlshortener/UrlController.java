package com.nanami.urlshortener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class UrlController {

    @Autowired
    public UrlController(UrlShortenerService urlShortenerService) {
        this.urlShortenerService = urlShortenerService;
    }

    private UrlShortenerService urlShortenerService;

    @PostMapping("/shorten")
    public ShortenedUrl shorten(@RequestBody String targetUrl) {
        return urlShortenerService.shorten(targetUrl);
    }

    @GetMapping("/resolve/{shortenedUrl}")
    public Url resolve(@PathVariable("shortenedUrl") String shortenedUrl) {
        return urlShortenerService.resolve(shortenedUrl).orElseThrow(UrlNotFoundException::new);
    }

    @GetMapping("/redirect/{shortenedUrl}")
    public RedirectView redirect(@PathVariable("shortenedUrl") String shortenedUrl) {
        var url = urlShortenerService.resolve(shortenedUrl).orElseThrow(UrlNotFoundException::new);
        return new RedirectView(url.getTargetUrl());
    }

}