package com.nimap.productapp.controller;

import com.nimap.productapp.entity.Product;
import com.nimap.productapp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public Page<Product> getAll(@RequestParam(defaultValue = "0") int page) {
        return productRepository.findAll(PageRequest.of(page, 5));
    }

    @PostMapping
    public ResponseEntity<Product> create(@RequestBody Product product) {
        // Optional: Check if category exists or set to null before saving
        if(product.getCategory() != null && product.getCategory().getId() == null) {
            product.setCategory(null);
        }
        Product saved = productRepository.save(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getById(@PathVariable Long id) {
        return productRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@PathVariable Long id, @RequestBody Product newProduct) {
        Optional<Product> prod = productRepository.findById(id);
        if (prod.isPresent()) {
            Product p = prod.get();
            p.setName(newProduct.getName());
            p.setCategory(newProduct.getCategory());
            return ResponseEntity.ok(productRepository.save(p));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
