package com.product.productreview.service;

import com.product.productreview.dto.ProductDTO;
import com.product.productreview.dto.ProductDTOs;

public interface IProductService {
    ProductDTOs getProductList(int pageIndex, int pageSize);
    ProductDTO getProductDetail(String productCode);
}
