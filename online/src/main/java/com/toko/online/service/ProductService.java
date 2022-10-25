package com.toko.online.service;

import com.toko.online.model.entity.Product;
import com.toko.online.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    // field
    @Autowired
    private ProductRepository productRepository;
    public List<Product> getProduct() {
        return productRepository.findAll();
    }

    public void saveProduct(Product product) {
        productRepository.save(product);
    }

    public void updateProduct(Product product, int id) {
        Optional<Product> dataProduct = productRepository.findById(id);
        if(dataProduct.isPresent()) {
            dataProduct.get().setProductName(product.getProductName());
            productRepository.save(dataProduct.get());
        }

    }

    public void deleteProduct(int id) {
        Optional<Product> dataProduct = productRepository.findById(id);
        dataProduct.ifPresent(product -> productRepository.delete(product));
    }
}
