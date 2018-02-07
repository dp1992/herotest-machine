package nl.avans.ivh11.DemoApplication.controllers.api;

import nl.avans.ivh11.DemoApplication.domain.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1")
public class ApiProductController {

    private final Logger logger = LoggerFactory.getLogger(ApiProductController.class);

    private ArrayList<Product> products = new ArrayList<>();

    @GetMapping(value = "/products")
    ArrayList<Product> getProducts() {
        logger.trace("getProducts was called.");
        return products;
    }

    @PostMapping(value = "/products")
    ArrayList<Product> createProduct(@RequestBody Product product) {
        logger.trace("createProduct was called.");
        products.add(product);
        return products;

    }
}
