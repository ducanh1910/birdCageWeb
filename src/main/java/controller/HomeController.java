package controller;

import model.Customer;
import model.ShoppingCart;
import service.CustomerService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class HomeController {
    private final CustomerService customerService;

    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public String home(Model model, Principal principal, HttpSession session) {
        model.addAttribute("title", "Home");
        model.addAttribute("page", "Home");
        if (principal != null) {
            Customer customer = customerService.findByUsername(principal.getName());
            session.setAttribute("username", customer.getFirstName() + " " + customer.getLastName());
            ShoppingCart shoppingCart = customer.getShoppingCart();
            if (shoppingCart != null) {
                session.setAttribute("totalItems", shoppingCart.getTotalItems());
            }
        }
        return "home";
    }
}
