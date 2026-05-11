package ed.lab.ed1labo04.service;

import ed.lab.ed1labo04.entity.ProductEntity;
import ed.lab.ed1labo04.model.CreateProductRequest;
import ed.lab.ed1labo04.model.UpdateProductRequest;
import ed.lab.ed1labo04.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    public ProductEntity createProduct(CreateProductRequest createProductRequest) {
        if (createProductRequest.getPrice() == null || createProductRequest.getPrice().doubleValue() <= 0) {
            throw new IllegalArgumentException("Price must be greater than zero.");
        }

        ProductEntity productEntity = new ProductEntity();
        productEntity.setName(createProductRequest.getName());
        productEntity.setPrice(createProductRequest.getPrice());
        productEntity.setQuantity(0);

        return productRepository.save(productEntity);
    }

    public ProductEntity updateProduct(long id, UpdateProductRequest updateProductRequest){
        if(updateProductRequest.getPrice() == null || updateProductRequest.getPrice().doubleValue() <= 0){
            throw new IllegalArgumentException("Price must be greater than zero.");
        }

        if(updateProductRequest.getQuantity() < 0){
            throw new IllegalArgumentException("Quantity must be greater than zero.");
        }

        ProductEntity productEntity = productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Product not found"));
        productEntity.setPrice(updateProductRequest.getPrice());
        productEntity.setQuantity(updateProductRequest.getQuantity());

        return productRepository.save(productEntity);
    }

    public List<ProductEntity> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<ProductEntity> getProductById(long id) {
        return productRepository.findById(id);
    }
}
