package org.meta.crew.endpoints;

import org.apache.catalina.User;
import org.meta.crew.dataAccess.UserRepository;
import org.meta.crew.entities.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("home")
public class HomeController {

    @Value("${spring.application.name}")
    private String appName;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("")
    public String homePage(Model model) {
        model.addAttribute("appName", appName);
        return "home";
    }

    @GetMapping("/next")
    public String nextPage(Model model) {
        model.addAttribute("appName", appName);
        UserEntity user = new UserEntity();
        user.setFirstName("Randul");
        user.setLastName("Malinhara");
        user.setEmail("randul@gmail.com");
        userRepository.save(user);
        return "home";
    }


}
