package sec.oauth.login_oauth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServerPageController {

    @GetMapping("/")
    public String ServerPage(){
        return "Server Page!";
    }

    @GetMapping("/secured")
    public String SecuredServerPage(){
        return "Secured Server Page";
    }
}
