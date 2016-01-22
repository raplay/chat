package com.lrwin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * Created by dulei on 1/14/16.
 * Email:codingbaby@gmail.com
 * Site:http:lrwin.leanote.com
 * Github:https://github.com/raplay
 * Author:Lrwin
 * Description: Using main method of the file to run application.
 */
@EnableCaching
@SpringBootApplication
public class ApplicationRoot {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationRoot.class,args);
    }
}
