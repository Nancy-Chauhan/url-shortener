package com.main.urlshortener;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpStatusCodeException;

import java.nio.charset.Charset;

public class UrlNotFoundException extends HttpStatusCodeException {

    protected UrlNotFoundException() {
        super(HttpStatus.NOT_FOUND, "Url not found");
    }
}
