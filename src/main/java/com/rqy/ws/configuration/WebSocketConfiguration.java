package com.rqy.ws.configuration;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.messaging.simp.config.ChannelRegistration;
//import org.springframework.messaging.simp.config.MessageBrokerRegistry;
//import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
//import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
//import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
//import org.springframework.web.socket.config.annotation.WebSocketTransportRegistration;
//
///**
// * @Author renqingyang
// * @create 2020/5/27 4:45 PM
// */
//@Configuration
//@EnableWebSocketMessageBroker
//public class WebSocketConfiguration implements WebSocketMessageBrokerConfigurer {
//
//    /**
//     * 这个方法的作用是添加一个服务端点，来接收客户端的连接
//     * registry.addEndpoint("/socket")表示添加了一个/socket端点，客户端就可以通过这个端点来进行连接
//     * withSockJS()的作用是开启SockJS支持
//     * @param registry
//     */
//    @Override
//    public void registerStompEndpoints(StompEndpointRegistry registry) {
//        registry.addEndpoint("/imserver/10").withSockJS();
//    }
//
//    /**
//     * 这个方法的作用是定义消息代理，通俗一点讲就是设置消息连接请求的各种规范信息
//     * registry.enableSimpleBroker("/topic")表示客户端订阅地址的前缀信息，也就是客户端接收服务端消息的地址的前缀信息
//     * registry.setApplicationDestinationPrefixes("/app")指服务端接收地址的前缀，意思就是说客户端给服务端发消息的地址的前缀
//     * @param registry
//     */
//    @Override
//    public void configureMessageBroker(MessageBrokerRegistry registry) {
//        registry.enableSimpleBroker("/topic");//客户端接收服务端消息的地址的前缀信息
//        registry.setApplicationDestinationPrefixes("/app");//客户端给服务端发消息的地址的前缀
//    }
//
//    @Override
//    public void configureClientInboundChannel(ChannelRegistration registration) {
//        registration.taskExecutor().corePoolSize(100);
//    }
//
//    @Override
//    public void configureClientOutboundChannel(ChannelRegistration registration) {
//        registration.taskExecutor().corePoolSize(100);
//    }
//
//    @Override
//    public void configureWebSocketTransport(WebSocketTransportRegistration registration) {
//        registration.setSendTimeLimit(10 * 1000);
//        registration.setSendBufferSizeLimit(128 * 1024);
//        registration.setMessageSizeLimit(16 * 1024);
//    }
//
//
//}


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * 开启WebSocket支持
 *
 */
@Configuration
public class WebSocketConfiguration {
    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }
}
