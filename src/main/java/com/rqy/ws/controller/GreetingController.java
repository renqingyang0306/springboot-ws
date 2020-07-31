package com.rqy.ws.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * @Author renqingyang
 * @create 2020/5/27 4:59 PM
 */
@Controller
public class GreetingController {

    @Resource
    private SimpMessagingTemplate simpMessagingTemplate;


    @RequestMapping("/hello")
    public String index(){
        return "ws";
    }

    @RequestMapping("/hello1")
    public String index1(){
        return "over";
    }

    @MessageMapping("/change-notice")
    public void greeting(String value){
        this.simpMessagingTemplate.convertAndSend("/topic/notice", value);//等价于@SendTo("/topic/notice")
        //@SendTo定义了消息的目的地。结合例子解释就是“接收/app/change-notice发来的value，然后将value转发到/topic/notice客户端。
    }
    @MessageMapping("/change-notice2")
    public void greeting1(String value){
        this.simpMessagingTemplate.convertAndSend("/topic/notice2", value);//等价于@SendTo("/topic/notice")
        //@SendTo定义了消息的目的地。结合例子解释就是“接收/app/change-notice发来的value，然后将value转发到/topic/notice客户端。
    }
}
