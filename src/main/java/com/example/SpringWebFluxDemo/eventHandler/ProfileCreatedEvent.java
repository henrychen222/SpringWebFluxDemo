/**
 * 10.8 evening
 * https://developer.okta.com/blog/2018/09/24/reactive-apis-with-spring-webflux#learn-more-about-reactive-programming-spring-webflux-and-oidc
 */
package com.example.SpringWebFluxDemo.eventHandler;

import com.example.SpringWebFluxDemo.domain.Profile;
import org.springframework.context.ApplicationEvent;

public class ProfileCreatedEvent extends ApplicationEvent {

    public ProfileCreatedEvent(Profile source) {
        super(source);
    }

}