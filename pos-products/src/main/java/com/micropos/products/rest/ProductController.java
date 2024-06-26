package com.micropos.products.rest;

import com.micropos.api.ProductsApi;
import com.micropos.dto.ProductDto;
import com.micropos.dto.InlineObjectDto;
import com.micropos.products.mapper.ProductMapper;
import com.micropos.products.model.Product;
import com.micropos.products.service.ProductService;

import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController implements ProductsApi {

    @Autowired
    private final ProductMapper productMapper;

    @Autowired
    private final ProductService productService;

   
    public ProductController(ProductService productService, ProductMapper productMapper) {
        this.productMapper = productMapper;
        this.productService = productService;
    }

    @GetMapping("/products")
    @Override
    public ResponseEntity<List<ProductDto>> listProducts(){
        List<ProductDto> products = new ArrayList<>(productMapper.toProductsDto(this.productService.products()));
        if (products.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/products/{productId}")
    @Override
    public ResponseEntity<ProductDto> getProductById(@PathVariable Integer productId){
        ProductDto product = productMapper.toProductDto(this.productService.getProduct(productId));
        if(product==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @PatchMapping("/products/{productId}")
    @Override
    public ResponseEntity<ProductDto> updateProductQuantity(
            @PathVariable Integer productId,
            @RequestBody InlineObjectDto inlineObjectDto
    ) {
        Product product = productMapper.toProduct(getProductById(productId).getBody());
//        product.setProductQuantity(inlineObjectDto.getQuantity());
        this.productService.updateProductQuantity(product, inlineObjectDto.getQuantity());
        return new ResponseEntity<>(productMapper.toProductDto(product), HttpStatus.OK);
    }
    

}
