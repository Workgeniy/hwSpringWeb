package org.example.hwspringweb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageController {

    @Autowired
    private ShopService shopService;

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
}


