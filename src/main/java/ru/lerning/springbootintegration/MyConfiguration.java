package ru.lerning.springbootintegration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.channel.ExecutorChannel;
import org.springframework.messaging.MessageChannel;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@Configuration
public class MyConfiguration {
    private static final Executor EXECUTOR = Executors.newFixedThreadPool(10);

    @Bean
    public MessageChannel channel1(){
        return new ExecutorChannel(EXECUTOR);
    }

    @Bean
    public MessageChannel channel2(){
        return new ExecutorChannel(EXECUTOR);
    }

    @Bean
    public MessageChannel channel3(){
        return new DirectChannel();
    }

    @Bean
    public MessageChannel channel4(){
        return new DirectChannel();
    }

//    @Bean
//    public MessageHandler distributor() {
//        RecipientListRouter router = new RecipientListRouter();
//        router.setApplySequence(true);
//        router.setChannels(Arrays.asList(channel4()));
//        return router;
//    }
////
//    @Bean
//    public MessageHandler gatherer() {
//        return new AggregatingMessageHandler(
//                new ExpressionEvaluatingMessageGroupProcessor("^[payload gt 5] ?: -1D"),
//                new SimpleMessageStore(),
//                new HeaderAttributeCorrelationStrategy(
//                        IntegrationMessageHeaderAccessor.CORRELATION_ID),
//                new ExpressionEvaluatingReleaseStrategy("size() == 2"));
//    }

//    @Bean
//    @ServiceActivator
//    public MessageHandler scatterGatherDistribution() {
//        ScatterGatherHandler handler = new ScatterGatherHandler(distributor(), gatherer());
//        handler.setOutputChannel(channel4());
//        return handler;
//    }


//    @ServiceActivator(inputChannel="channel3")
//    @Bean
//    public BarrierMessageHandler barrier() {
//        BarrierMessageHandler barrier = new BarrierMessageHandler(10000);
//        barrier.setOutputChannel(channel4
//                ());
//        barrier.setDiscardChannel(lateTriggers());
//
//        return barrier;
//    }
//
//    @ServiceActivator(inputChannel="release")
//    @Bean
//    public MessageHandler releaser() {
//        return new MessageHandler() {
//
//            @Override
//            public void handleMessage(Message<?> message) throws MessagingException {
//                barrier().trigger(message);
//            }
//
//        };
//    }
}
