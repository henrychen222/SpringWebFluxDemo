/**
 * 10.8 evening
 * https://thepracticaldeveloper.com/2017/11/04/full-reactive-stack-with-spring-webflux-and-angularjs/
 */
package com.example.SpringWebFluxDemo.repository;

import com.example.SpringWebFluxDemo.domain.Quote;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface QuoteMongoBlockingRepository extends CrudRepository<Quote, String> {

    @Query("{ id: { $exists: true }}")
    List<Quote> retrieveAllQuotesPaged(final Pageable page);
}
