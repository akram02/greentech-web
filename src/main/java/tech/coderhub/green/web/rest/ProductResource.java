package tech.coderhub.green.web.rest;

import tech.coderhub.green.domain.Product;
import tech.coderhub.green.domain.User;
import tech.coderhub.green.repository.ProductRepository;
import tech.coderhub.green.repository.UserRepository;
import tech.coderhub.green.service.dto.ProductDTO;
import tech.coderhub.green.web.rest.errors.BadRequestAlertException;

import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing {@link tech.coderhub.green.domain.Product}.
 */
@RestController
@RequestMapping("/api")
@Transactional
public class ProductResource {

    private final Logger log = LoggerFactory.getLogger(ProductResource.class);

    private static final String ENTITY_NAME = "product";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final ProductRepository productRepository;

    private final UserRepository userRepository;

    public ProductResource(ProductRepository productRepository, UserRepository userRepository) {
        this.productRepository = productRepository;
        this.userRepository = userRepository;
    }

    @PostMapping("/products")
    public ResponseEntity<Product> createProduct(@RequestBody Product product) throws URISyntaxException {
        log.debug("REST request to save Product : {}", product);
        if (product.getId() != null) {
            throw new BadRequestAlertException("A new product cannot already have an ID", ENTITY_NAME, "idexists");
        }
        Product result = productRepository.save(product);
        return ResponseEntity.created(new URI("/api/products/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    @PutMapping("/products")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product) throws URISyntaxException {
        log.debug("REST request to update Product : {}", product);
        if (product.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        Product result = productRepository.save(product);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, product.getId().toString()))
            .body(result);
    }

    @GetMapping("/products")
    public List<ProductDTO> getAllProducts() {
        log.debug("REST request to get all Products");
        List<ProductDTO> products = new ArrayList<>();
        List<Product> lists = productRepository.findAll();
        for (Product product : lists) {
            userRepository.findOneWithAuthoritiesById(product.getUserId())
                    .ifPresent(user ->
                    products.add(new ProductDTO(product.getId(), product.getName(), user.getFirstName() + " " + user.getLastName(), product.getLocation(), product.getCategory()))
            );
        }
        return products;
    }

    @GetMapping("/products-for-mobile-by-category/{category}")
    public List<ProductDTO> getAllProductsByCategory(@PathVariable String category) {
        log.debug("REST request to get all Products By Category");
        List<ProductDTO> products = new ArrayList<>();
        List<Product> lists = productRepository.findByCategory(category);
        for (Product product : lists) {
            userRepository.findOneWithAuthoritiesById(product.getUserId())
                    .ifPresent(user ->
                            products.add(new ProductDTO(product.getId(), product.getName(), user.getFirstName() + " " + user.getLastName(), product.getLocation(), product.getCategory()))
                    );
        }
        return products;
    }


    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable Long id) {
        log.debug("REST request to get Product : {}", id);
        Optional<Product> product = productRepository.findById(id);
        return ResponseUtil.wrapOrNotFound(product);
    }

    @GetMapping("/products-for-mobile/{id}")
    public ResponseEntity<ProductDTO> getProductForMobile(@PathVariable Long id) {
        log.debug("REST request to get Product : {}", id);
        Product product = productRepository.findById(id).get();
        final ProductDTO[] productDTO = {new ProductDTO()};
        userRepository.findOneWithAuthoritiesById(product.getUserId())
                .ifPresent(user ->
                        productDTO[0] = new ProductDTO(product.getId(), product.getName(), user.getFirstName() + " " + user.getLastName(), product.getLocation(), product.getCategory())
                );
        return ResponseUtil.wrapOrNotFound(Optional.of(productDTO[0]));
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        log.debug("REST request to delete Product : {}", id);
        productRepository.deleteById(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
