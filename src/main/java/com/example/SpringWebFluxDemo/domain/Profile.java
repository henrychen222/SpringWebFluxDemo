/**
 * 10.8 evening
 * https://developer.okta.com/blog/2018/09/24/reactive-apis-with-spring-webflux#learn-more-about-reactive-programming-spring-webflux-and-oidc
 */
package com.example.SpringWebFluxDemo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Profile {
    @Id
    private String id;

    private String email;
}
