package com.chat.web.api.test;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 */
@RestController
public class TestController {
    @RequestMapping("/api/test/hello")
    public HelloAnswer hello (@RequestParam(value="userName") String userName){
        System.out.println("***Request from: "+ userName);
        HelloAnswer answer = new HelloAnswer();
        answer.setUserName(userName);
        answer.setServerTime(System.currentTimeMillis());
        return answer;
    }
    public static class HelloAnswer{
        private long serverTime;
        private String userName;

        public long getServerTime() {
            return serverTime;
        }

        public void setServerTime(long serverTime) {
            this.serverTime = serverTime;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }
    }
}
