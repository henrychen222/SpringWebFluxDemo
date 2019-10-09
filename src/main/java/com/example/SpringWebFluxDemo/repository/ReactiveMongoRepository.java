/**
 * 10.8 evening
 * https://developer.okta.com/blog/2018/09/24/reactive-apis-with-spring-webflux#learn-more-about-reactive-programming-spring-webflux-and-oidc
 */
package com.example.SpringWebFluxDemo.repository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import org.reactivestreams.Publisher;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;
import org.springframework.data.repository.reactive.ReactiveSortingRepository;

@NoRepositoryBean
public interface ReactiveMongoRepository<T, ID> extends ReactiveSortingRepository<T, ID>, ReactiveQueryByExampleExecutor<T> {

    <S extends T> Mono<S> insert(S entity);

    <S extends T> Flux<S> insert(Iterable<S> entities);

    <S extends T> Flux<S> insert(Publisher<S> entities);

    <S extends T> Flux<S> findAll(Example<S> example);

    <S extends T> Flux<S> findAll(Example<S> example, Sort sort);

}