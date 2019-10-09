/**
 * 10.8 evening
 * https://thepracticaldeveloper.com/2017/11/04/full-reactive-stack-with-spring-webflux-and-angularjs/
 */
package com.example.SpringWebFluxDemo.controller;

import com.example.SpringWebFluxDemo.domain.Quote;
import com.example.SpringWebFluxDemo.repository.QuoteMongoBlockingRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuoteBlockingController {

    private static final int DELAY_PER_ITEM_MS = 100;

    private QuoteMongoBlockingRepository quoteMongoBlockingRepository;

    protected QuoteBlockingController(final QuoteMongoBlockingRepository quoteMongoBlockingRepository) {
        this.quoteMongoBlockingRepository = quoteMongoBlockingRepository;
    }

    @GetMapping("/quotes-blocking")
    public Iterable<Quote> getQuotesBlocking() throws Exception {
        Thread.sleep(DELAY_PER_ITEM_MS * quoteMongoBlockingRepository.count());
        return quoteMongoBlockingRepository.findAll();
    }

    @GetMapping("/quotes-blocking-paged")
    public Iterable<Quote> getQuotesBlocking(final @RequestParam(name = "page") int page,
                                             final @RequestParam(name = "size") int size) throws Exception {
        Thread.sleep(DELAY_PER_ITEM_MS * size);
        return quoteMongoBlockingRepository.retrieveAllQuotesPaged(PageRequest.of(page, size));
    }
}