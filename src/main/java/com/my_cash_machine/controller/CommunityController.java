package com.my_cash_machine.controller;

import com.my_cash_machine.domen.Community;
import com.my_cash_machine.domen.User;
import com.my_cash_machine.service.CommunityService;
import com.my_cash_machine.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.Collection;

@Controller
public class CommunityController {

    @Autowired
    private CommunityService communityService;


    @Autowired
    private UserService userService;





    //ToDO save bill (idBill)  in session
    @PostMapping("community/new_community")
    public String newBill(Model model) {
        Collection<Community> communities = communityService.findAll();
        model.addAttribute("communities", communities);
        return "community";
    }

    @PostMapping("community/add_community")
    public String addCommunity(Model model, @RequestParam(name = "idCommunity") Integer idCommunity, Principal principal) {
        System.out.println("I'm here!!!!!!!!");
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println(userDetails.getUsername());
        User user = userService.findByEmail(userDetails.getUsername());
        System.out.println(user.getEmail());
        user.setCommunities(communityService.findById(idCommunity));
        userService.save(user);
        return "home";
    }

    @PostMapping("info")
    public String info(Model model) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userService.findByEmail(userDetails.getUsername());
        model.addAttribute("user", user);
        return "info";
    }

    @PostMapping("info/save")
    public String saveInfo(Model model, @RequestParam(name = "namee") String name, @RequestParam(name = "surnamee") String surname) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userService.findByEmail(userDetails.getUsername());
        user.setName(name);
        user.setSurname(surname);
        userService.save(user);
        model.addAttribute("user", user);
        return "info";
    }






//    @PostMapping("bill/add_product")
//    public String addProductToCart(HttpSession session, @RequestParam(name = "idProduct") Integer idProduct,
//                                   @RequestParam(name = "quantity") Integer quantity, Model model) {
//        Bill bill = (Bill) session.getAttribute("bill");
//        System.out.println(idProduct);
//        System.out.println(quantity);
//        List<Product> products = productService.getAllProducts();
//        model.addAttribute("products", products);
//        Payment payment = Payment.builder()
//                .bill(billService.findById(bill.getIdBill()))
//                .product(productService.findById(idProduct))
//                .quantity(quantity)
//                .build();
//        paymentService.addProductToBill(payment);
//        return "bill";
//    }
//
//    @PostMapping("/bill/showBill")
//    public String showPaymentsInBill(HttpSession session, Model model) {
//        Bill bill = (Bill) session.getAttribute("bill");
//        List<Payment> payments = paymentService.findPaymentsByBill(bill.getIdBill());
//        model.addAttribute("payments", payments);
//        return "view_bill";
//    }
//
//    @PostMapping("/bill/deleteProduct")
//    public String deleteProduct(@RequestParam(name = "payment") Integer idPayment, Model model, HttpSession session) {
//        paymentService.deleteProductFromBill(paymentService.findById(idPayment));
//        List<Payment> payments = paymentService.findPaymentsByBill(((Bill)session.getAttribute("bill")).getIdBill());
//        model.addAttribute("payments", payments);
//        return "view_bill";
//    }
//
//    @GetMapping("bill/showBill/close_bill")
//    public String closeBill(HttpSession session) {
//        Optional<Bill> optionalBill = Optional.ofNullable((Bill) session.getAttribute("bill"));
//        optionalBill.ifPresent(bill -> {
//            bill.setBillStatus(Status.FINISHED);
//            billService.update(bill);
//        });
//        session.removeAttribute("bill");
//        return "redirect:/home";
//    }
//
//    @PostMapping("bill/viw_open_bill_page")
//    public String openBillPage(Model model) {
//        Collection<Bill> bills =  billService.findAll();
//        model.addAttribute("bills", bills);
//        return "open_bill";
//    }
//
//    @PostMapping("/bill/open_bill")
//    public String openBill(@RequestParam(name = "idBill") Integer idBill, HttpSession session, Model model) {
//        Bill bill = billService.findById(idBill);
//        session.setAttribute("bill", bill);
//        List<Product> products = productService.getAllProducts();
//        model.addAttribute("products", products);
//        return "bill";
//    }
}
