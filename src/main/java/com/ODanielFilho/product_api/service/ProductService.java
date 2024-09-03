package com.ODanielFilho.product_api.service;

import com.ODanielFilho.product_api.entity.Product;
import com.ODanielFilho.product_api.entity.dto.ProductDTO;
import com.ODanielFilho.product_api.entity.dto.ProductResponseDTO;
import com.ODanielFilho.product_api.exceptions.ProductNotFoundException;
import com.ODanielFilho.product_api.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ProductService {
    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    private ProductResponseDTO convertToDTO(Product product) {
        return new ProductResponseDTO(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getCategory(),
                product.getBrand(),
                product.getQuantityInStock(),
                product.getSku(),
                product.getWeight(),
                product.getDimensions(),
                product.getColor(),
                product.getImageUrl(),
                product.getStatus()
        );
    }

    private Product convertToEntity(ProductDTO dto) {
        Product product = new Product();
        product.setName(dto.name());
        product.setDescription(dto.description());
        product.setPrice(dto.price());
        product.setCategory(dto.category());
        product.setBrand(dto.brand());
        product.setQuantityInStock(dto.quantityInStock());
        product.setSku(dto.sku());
        product.setWeight(dto.weight());
        product.setDimensions(dto.dimensions());
        product.setColor(dto.color());
        product.setImageUrl(dto.imageUrl());
        product.setStatus(dto.status());
        return product;
    }

    public List<ProductResponseDTO> getAllProducts() {
        List<Product> products = repository.findAll();
        return products.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public ProductResponseDTO getProductById(UUID id) {
        Product product = repository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found with id: " + id));
        return convertToDTO(product);
    }

    public ProductResponseDTO createProduct(ProductDTO productDTO) {
        Product product = convertToEntity(productDTO);
        Product savedProduct = repository.save(product);
        return convertToDTO(savedProduct);
    }

    public ProductResponseDTO updateProduct(UUID id, ProductDTO productDTO) {
        Product product = repository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found with id: " + id));

        product.setName(productDTO.name());
        product.setDescription(productDTO.description());
        product.setPrice(productDTO.price());
        product.setCategory(productDTO.category());
        product.setBrand(productDTO.brand());
        product.setQuantityInStock(productDTO.quantityInStock());
        product.setSku(productDTO.sku());
        product.setWeight(productDTO.weight());
        product.setDimensions(productDTO.dimensions());
        product.setColor(productDTO.color());
        product.setImageUrl(productDTO.imageUrl());
        product.setStatus(productDTO.status());

        Product updatedProduct = repository.save(product);
        return convertToDTO(updatedProduct);
    }

    public void deleteProduct(UUID id) {
        Product product = repository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found with id: " + id));
        repository.delete(product);
    }
}
