package com.sonal.demosvc.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sonal.demosvc.vo.CreateProductRequestVO;
import com.sonal.demosvc.vo.CreateProductResponseVO;
import com.sonal.demosvc.vo.UpdateProductRequestVO;
import com.sonal.demosvc.vo.UpdateProductResponseVO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/v1/products")
@Tag(name = "Product", description = "the product Api")
public class ProductsController {

    @Operation(summary = "This web method is used to get all products.")
    @GetMapping
    public ResponseEntity<List<String>> getProducts() {
        return ResponseEntity.ok(Arrays.asList("Bats", "Balls", "Stumps"));
    }
    
    @Operation(summary = "This web method is used to product by porductId")
    @GetMapping("/{productId}")
    public ResponseEntity<String> getProducts(@PathVariable (value = "productId") String productId) {
        return ResponseEntity.ok("Product-" + productId);
    }
    
    @Operation(summary = "This web method is used to cerate a product.")
    @PostMapping("/{productId}")
    public ResponseEntity<CreateProductResponseVO> createProduct(@PathVariable(value = "productId") String productId, @RequestBody CreateProductRequestVO productRequestVO) {
        return ResponseEntity.ok(CreateProductResponseVO.builder()
        												.result(productRequestVO.getProductName() + " Created.")
        												.build());
    }
    
    @Operation(summary = "This web method is used to update a products")
    @PutMapping("/{productId}")
    public ResponseEntity<UpdateProductResponseVO> updateProduct(@PathVariable(value = "productId") String productId, @RequestBody UpdateProductRequestVO productRequestVO) {
        return ResponseEntity.ok(UpdateProductResponseVO.builder()
        												.result(productRequestVO.getProductName() + " Updated.")
        												.build());
    }
    
    @Operation(summary = "This web method is used to delete product by ProductId.")
    @DeleteMapping("/{productId}")
    public ResponseEntity<UpdateProductResponseVO> deleteProduct(@PathVariable(value = "productId") String productId) {
        return ResponseEntity.ok(UpdateProductResponseVO.builder()
        												.result(productId + " Deleted.")
        												.build());
    }

}
