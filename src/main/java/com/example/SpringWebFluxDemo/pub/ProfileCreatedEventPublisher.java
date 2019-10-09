/**
 * 10.8 evening
 * https://developer.okta.com/blog/2018/09/24/reactive-apis-with-spring-webflux#learn-more-about-reactive-programming-spring-webflux-and-oidc
 */
package com.example.SpringWebFluxDemo.pub;

import com.example.SpringWebFluxDemo.eventHandler.ProfileCreatedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;
import reactor.core.publisher.FluxSink;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.function.Consumer;

@Component
public
class ProfileCreatedEventPublisher implements
        ApplicationListener<ProfileCreatedEvent>,
        Consumer<FluxSink<ProfileCreatedEvent>> {

    private final Executor executor;
    private final BlockingQueue<ProfileCreatedEvent> queue =
            new LinkedBlockingQueue<>();

    ProfileCreatedEventPublisher(Executor executor) {
        this.executor = executor;
    }


    @Override
    public void onApplicationEvent(ProfileCreatedEvent event) {
        this.queue.offer(event);
    }

    @Override
    public void accept(FluxSink<ProfileCreatedEvent> sink) {
        this.executor.execute(() -> {
            while (true)
                try {
                    ProfileCreatedEvent event = queue.take();
                    sink.next(event);
                } catch (InterruptedException e) {
                    ReflectionUtils.rethrowRuntimeException(e);
                }
        });
    }
}