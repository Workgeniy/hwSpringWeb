package org.example.hwspringweb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;

@Controller
public class PageController {

    @Autowired
    private ShopService shopService;

    UserDto userDto;

    @GetMapping("/addedPurchase")
    public String addedPurchase() {
        return "addedPurchase";
    }

    @GetMapping ("/allPurchase")
        public String allPurchase(
                @RequestParam(name="my_param",required=false,defaultValue="absent") String from_url, Model model)
    {
                model.addAttribute("my_param", from_url);
                model.addAttribute("products", shopService.getAllProducts());
                return "allPurchase";
    }

    @GetMapping("/main")
    public String main() {
        return "index";
    }

    @PostMapping("/addingOnePurchase")
    public String addingOnePurchase(@ModelAttribute Product product, Model model) {
        model.addAttribute("Purchase", product);

        shopService.saveDB(product);

        return "index";
    }

    @GetMapping("/registration")
    public String showRegistrationForm(
            WebRequest request,
            Model model) {
        UserDto user = new UserDto();
        model.addAttribute("user", user);
        return "registration";
    }

    @GetMapping("/login")
    public String showLoginForm(){
        return "login";
    }

    @PostMapping("/postRegistr")
    public String createNewUser(@ModelAttribute UserDto user, Model model) {
        //model.addAttribute("myUser", newUser);
        shopService.saveUserToDB(user);

        userDto = user;

        return "index";
    }

    @PostMapping("/postLogin")
    public String postLogin(@ModelAttribute UserDto userDto, Model model) {

        System.out.println(userDto);

        UserDto user = shopService.findByEmail(userDto.getEmail());

        userDto.setFirstName(" ");
        userDto.setLastName(" ");

        System.out.println(user);

        if(user == null) {
            System.out.println("NULL");
            model.addAttribute("myUser", userDto);
            return "registration";
        }

        if(userDto.getPassword().equals(user.getPassword())) {
            System.out.println("MATCH");
            userDto = user;
            return "index";
        }
        else{
            System.out.println("NOT MATCH");
            return "login";
        }
    }


    @GetMapping("/logout")
    public String logout() {
        userDto = null;
        return "index";
    }
}


