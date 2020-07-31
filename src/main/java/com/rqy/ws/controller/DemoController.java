package com.rqy.ws.controller;

import com.rqy.ws.service.WebSocketServer;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

/**
 * @Author renqingyang
 * @create 2020/5/28 2:32 PM
 */

@Controller
public class DemoController {

    @GetMapping("index")
    public ResponseEntity<String> index(){
        return ResponseEntity.ok("请求成功");
    }

    @RequestMapping("page")
    public String page(){
        return "chat";
    }

    @RequestMapping("/push/{toUserId}")
    public ResponseEntity<String> pushToWeb(String message, @PathVariable String toUserId) throws IOException {
        WebSocketServer.sendInfo(message,toUserId);
        return ResponseEntity.ok("MSG SEND SUCCESS");
    }
}
