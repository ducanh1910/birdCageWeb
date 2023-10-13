package controller;

import dto.CustomerDto;
import model.Address;
import model.Customer;
import model.OrderTable;
import model.ShoppingCart;
import service.AddressService;
import service.CustomerService;
import service.OrderTableService;
import service.ShoppingCartService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class OrderController {
    private final CustomerService customerService;
    private final OrderTableService orderService;
    private final ShoppingCartService cartService;
    private final AddressService addressService;

    @GetMapping("/check-out")
    public String checkOut(Principal principal, Model model) {
        if (principal == null) {
            return "redirect:/login";
        } else {
            CustomerDto customer = customerService.getCustomer(principal.getName());
            if ( customer.getPhoneNumber() == null) {
                model.addAttribute("information", "You need update your information before check out");
                List<Address> countryList = addressService.findAll();
                model.addAttribute("customer", customer);
                model.addAttribute("title", "Profile");
                model.addAttribute("page", "Profile");
                return "customer-information";
            } else {
                ShoppingCart cart = customerService.findByUsername(principal.getName()).getShoppingCart();
                model.addAttribute("customer", customer);
                model.addAttribute("title", "Check-Out");
                model.addAttribute("page", "Check-Out");
                model.addAttribute("shoppingCart", cart);
                model.addAttribute("grandTotal", cart.getTotalItems());
                return "checkout";
            }
        }
    }

    @GetMapping("/orderTables")
    public String getOrders(Model model, Principal principal) {
        if (principal == null) {
            return "redirect:/login";
        } else {
            Customer customer = customerService.findByUsername(principal.getName());
            List<OrderTable> orderList = customer.getOrderTables();
            model.addAttribute("orders", orderList);
            model.addAttribute("title", "OrderTable");
            model.addAttribute("page", "OrderTable");
            return "orderTable";
        }
    }

    @RequestMapping(value = "/cancel-order", method = {RequestMethod.PUT, RequestMethod.GET})
    public String cancelOrder(Long id, RedirectAttributes attributes) {
        orderService.cancelOrder(id);
        attributes.addFlashAttribute("success", "Cancel order successfully!");
        return "redirect:/orderTables";
    }


    @RequestMapping(value = "/add-order", method = {RequestMethod.POST})
    public String createOrder(Principal principal,
                              Model model,
                              HttpSession session) {
        if (principal == null) {
            return "redirect:/login";
        } else {
            Customer customer = customerService.findByUsername(principal.getName());
            ShoppingCart cart = customer.getShoppingCart();
            OrderTable orderTable = orderService.save(cart);
            session.removeAttribute("totalItems");
            model.addAttribute("orderTable", orderTable);
            model.addAttribute("title", "Order Detail");
            model.addAttribute("page", "Order Detail");
            model.addAttribute("success", "Add order successfully");
            return "order-detail";
        }
    }

}
