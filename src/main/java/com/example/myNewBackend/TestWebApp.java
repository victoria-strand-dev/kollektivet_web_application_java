package com.example.myNewBackend;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestWebApp {

    //https://www.geeksforgeeks.org/springboot/how-to-create-a-basic-application-in-java-spring-boot/
    @GetMapping("/")
    public String home()
    {
        String str
                = "<html><body><font color=\"green\">"
                + "<h1>WELCOME To GeeksForGeeks</h1>"
                + "</font>"
                + "<a href='https://www.geeksforgeeks.org/springboot/how-to-create-a-basic-application-in-java-spring-boot/'>Lenke</a></body></html>"; //La inn link selv
        return str;
    }
}
