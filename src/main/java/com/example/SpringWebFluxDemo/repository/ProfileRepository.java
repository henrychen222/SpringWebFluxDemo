/**
 * 10.8 evening
 * https://developer.okta.com/blog/2018/09/24/reactive-apis-with-spring-webflux#learn-more-about-reactive-programming-spring-webflux-and-oidc
 */
package com.example.SpringWebFluxDemo.repository;

import com.example.SpringWebFluxDemo.domain.Profile;

public interface ProfileRepository extends ReactiveMongoRepository<Profile, String> {
}