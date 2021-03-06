package com.service.jmshop.product.controller.rest;

import com.service.jmshop.product.domain.Product;
import com.service.jmshop.product.dto.ProductMainDto;
import com.service.jmshop.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/product")
public class ProductController {
    private final ProductService productService;

    @GetMapping("/top")
    public ResponseEntity<List<Product>> getTopProduct(
            @RequestParam(value = "page", required = false, defaultValue = "0") int page,
            @RequestParam(value = "size", required = false, defaultValue = "20") int size
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(productService.findTopProduct(PageRequest.of(page, size, Sort.by("createdDate").descending())));
    }

    @GetMapping("/category")
    public ResponseEntity<List<ProductMainDto>> getProductByCategory(
            @RequestParam(value = "categoryId", required = false, defaultValue = "0") long categoryId,
            @RequestParam(value = "page", required = false, defaultValue = "0") int page,
            @RequestParam(value = "size", required = false, defaultValue = "6") int size
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(productService.findProductByCategoryId(categoryId, PageRequest.of(page, size, Sort.by("createdDate").descending())));
    }

    @GetMapping("/search")
    public ResponseEntity<List<Product>> getProductByKeyword(
            @RequestParam(value = "keyword", required = false, defaultValue = "") String keyword,
            @RequestParam(value = "page", required = false, defaultValue = "0") int page,
            @RequestParam(value = "size", required = false, defaultValue = "15") int size
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(productService.findProductByKeyword(keyword, PageRequest.of(page, size, Sort.by("createdDate").descending())));
    }
}
