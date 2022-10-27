package com.toko.online.controller;

import com.toko.online.model.entity.Product;
import com.toko.online.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/product")
    public ResponseEntity<List<Product>> getProduct() {
        List<Product> product = productService.getProduct();
        return ResponseEntity.ok(product);
    }

    @PostMapping("/product")
    public String addProduct(@RequestBody Product product) {
        productService.saveProduct(product);
        return "Data berhasil disimpan!";
    }

    @PutMapping("/product")
    public String updateProduct(@RequestBody Product product, @RequestParam("id") int id){
        productService.updateProduct(product, id);
        return "Data berhasil di update!";
    }

    @DeleteMapping("/product")
    public String deleteProduct(@RequestParam("id") int id) {
        productService.deleteProduct(id);
        return "Data berhasil di hapus!";
    }

}
