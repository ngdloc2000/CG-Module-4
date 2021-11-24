package controller;

import model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

//                           --------  1
//    MODEL

//    @RequestParam: là annotation đánh dấu tham số truyền vào
//    model: là đối tượng để truyền dữ liệu sang view
//    model.addAttribute: phương thức truyền 1 dữ liệu từ controller sang view

//    @GetMapping("/product")
//    public String demoModel(@RequestParam String name, @RequestParam String des, @RequestParam int price, Model model) {
//        Product product = new Product(name, des, price);
//        model.addAttribute("product", product);
//        return "list";
//    }



//                         --------------  2

//    MODEL LÀM FORM VỚI MODELMAP

    @GetMapping("/product")
    public String showFormAdd(Model model) {
        model.addAttribute("product", new Product());
        return "showFormAdd";
    }

//    MODELMAP
//
//    @ModelAttribute: là trả kết quả dưới tên được chỉ định
    @PostMapping("/addProduct")
    public String addProduct(@ModelAttribute("product") Product product, ModelMap modelMap) {
        modelMap.addAttribute("productView", product);
        return "viewProduct";
    }




//                         ----------------- 3

    //    MODELANDVIEW không dùng RequestParam
//    @GetMapping("/product")
//    public ModelAndView showProduct() {
//        Product product = new Product("Keo", "Keo ngon", 10000);
//        ModelAndView modelAndView = new ModelAndView("/list");
//        modelAndView.addObject("product", product);
//        return modelAndView;
//    }
//
////        MODELANDVIEW có RequestParam
//    @GetMapping("/product")
//    public ModelAndView showProduct(@RequestParam String name, @RequestParam String des, @RequestParam int price, Model model) {
//        Product product = new Product(name, des, price);
//        ModelAndView modelAndView = new ModelAndView("/list");
//        modelAndView.addObject("product", product);
//        return modelAndView;
//    }
}
