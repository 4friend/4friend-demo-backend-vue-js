package com.product.productreview.service.Impl;

import com.product.productreview.dto.ProductDTO;
import com.product.productreview.dto.ProductDTOs;
import com.product.productreview.model.Product;
import com.product.productreview.repo.ProductRepository;
import com.product.productreview.service.IProductService;
import ma.glasnost.orika.MapperFacade;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(rollbackFor = Exception.class)
public class ProductService implements IProductService {

    private final ProductRepository productRepository;
    private final MapperFacade objectMapper;

    public ProductService(ProductRepository productRepository, MapperFacade objectMapper) {
        this.productRepository = productRepository;
        this.objectMapper = objectMapper;
    }


    @Override
    public ProductDTOs getProductList(int pageIndex, int pageSize) {

        ProductDTOs productDTOs = new ProductDTOs();

        final PageRequest pageRequest = new PageRequest(pageIndex - 1, pageSize, new Sort(Sort.Direction.ASC, "productName"));
        Page<Product> productPage = productRepository.findAll(pageRequest);


        if (!CollectionUtils.isEmpty(productPage.getContent())) {
            List<Product> productList = productPage.getContent();
            List<ProductDTO> productDTOList = objectMapper.mapAsList(productList, ProductDTO.class);
            productDTOs.setProductDTOList(productDTOList);
        }



        Long totalItem = productRepository.count();
        productDTOs.setTotalItems(totalItem);


        return productDTOs;
    }

    @Override
    public ProductDTO getProductDetail(String productCode) {
        Optional<Product> product = productRepository.findById(productCode);
        ProductDTO productDTO = new ProductDTO();
        if(product.isPresent()) {
            productDTO = objectMapper.map(product.get(), ProductDTO.class);
        }
        return productDTO;
    }
}
