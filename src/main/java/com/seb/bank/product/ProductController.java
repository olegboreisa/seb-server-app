package com.seb.bank.product;

import com.seb.bank.product.model.IncomeForm;
import com.seb.bank.product.model.ProductData;
import com.seb.bank.product.model.ProductForm;
import com.seb.bank.product.model.IProduct;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public List<IProduct> getApplicableProducts(@RequestBody IncomeForm form) {
        return productService.getApplicableProducts(form);
    }

    @PostMapping("/new")
    public void upsert(@RequestBody ProductForm form) {
        productService.upsert(form);
    }

    @GetMapping("/all")
    public List<ProductData> getAll() {
        return productService.getAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        productService.delete(id);
    }

    @GetMapping("/{id}")
    public ProductForm getOne(@PathVariable long id) {
        return productService.getOne(id);
    }
}
