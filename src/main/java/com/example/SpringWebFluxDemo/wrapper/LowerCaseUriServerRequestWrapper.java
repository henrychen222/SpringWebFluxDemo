/**
 * 10.8 evening
 * https://developer.okta.com/blog/2018/09/24/reactive-apis-with-spring-webflux#learn-more-about-reactive-programming-spring-webflux-and-oidc
 */
package com.example.SpringWebFluxDemo.wrapper;

import org.springframework.http.server.PathContainer;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.support.ServerRequestWrapper;

import java.net.URI;

public class LowerCaseUriServerRequestWrapper extends ServerRequestWrapper {

    public LowerCaseUriServerRequestWrapper(ServerRequest delegate) {
        super(delegate);
    }

    @Override
    public URI uri() {
        return URI.create(super.uri().toString().toLowerCase());
    }

    @Override
    public String path() {
        return uri().getRawPath();
    }

    @Override
    public PathContainer pathContainer() {
        return PathContainer.parsePath(path());
    }
}