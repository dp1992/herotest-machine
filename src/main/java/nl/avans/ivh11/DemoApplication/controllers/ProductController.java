package nl.avans.ivh11.DemoApplication.controllers;

import nl.avans.ivh11.DemoApplication.domain.Product;
import nl.avans.ivh11.DemoApplication.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@RequestMapping("/product")
public class ProductController {

    private final Logger logger = LoggerFactory.getLogger(ProductController.class);
    private ArrayList<Product> products = new ArrayList<>();

    @Autowired
    private ProductRepository repository;

    public ProductController(ProductRepository repository){
        this.repository = repository;
    }

    @GetMapping(value = "/")
    public String getProducts(Model model) {
        logger.trace("getProducts was called.");

        model.addAttribute("products", products);
        return "views/home/index";
    }

    @PostMapping(value = "/")
    ArrayList<Product> createProduct(@RequestBody Product product) {
        logger.trace("createProduct was called.");
        products.add(product);
        return products;

    }
}
