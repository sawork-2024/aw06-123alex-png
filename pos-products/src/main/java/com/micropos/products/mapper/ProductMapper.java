package com.micropos.products.mapper;

import com.micropos.dto.ProductDto;
import com.micropos.products.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.context.annotation.Bean;

import java.util.Collection;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    Collection<ProductDto> toProductsDto(Collection<Product> products);

    Collection<Product> toProducts(Collection<ProductDto> products);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "productQuantity", source = "productQuantity")
    @Mapping(target = "price", source = "price")
    @Mapping(target = "image", source = "image")
    Product toProduct(ProductDto productDto);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "productQuantity", source = "productQuantity")
    @Mapping(target = "price", source = "price")
    @Mapping(target = "image", source = "image")
    ProductDto toProductDto(Product pet);
}
