package com.product.productreview.dto;

import java.util.ArrayList;
import java.util.List;

public class ProductDTOs {
    private List<ProductDTO> productDTOList = new ArrayList<>();
    private Long totalItems;

    public ProductDTOs() {
    }

    public List<ProductDTO> getProductDTOList() {
        return productDTOList;
    }

    public void setProductDTOList(List<ProductDTO> productDTOList) {
        this.productDTOList = productDTOList;
    }

    public Long getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(Long totalItems) {
        this.totalItems = totalItems;
    }
}
