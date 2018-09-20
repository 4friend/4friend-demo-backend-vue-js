package com.product.productreview.controller;

import com.product.productreview.dto.ProductDTO;
import com.product.productreview.dto.ProductDTOs;
import com.product.productreview.dto.ReviewDTO;
import com.product.productreview.service.IProductService;
import com.product.productreview.service.IReviewService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ProductController {

    private final IProductService productService;
    private final IReviewService reviewService;


    public ProductController(IProductService productService, IReviewService reviewService) {
        this.productService = productService;
        this.reviewService = reviewService;
    }

    @RequestMapping(path = "/products", method = RequestMethod.GET)
    public ProductDTOs getProductList(@RequestParam("pageIndex") int pageIndex,
                                      @RequestParam("pageSize") int pageSize) {
        return productService.getProductList(pageIndex, pageSize);
    }

    @RequestMapping(path = "/reviews", method = RequestMethod.POST)
    public ReviewDTO getProductList(@RequestBody ReviewDTO reviewDTO) {
        return reviewService.submitReview(reviewDTO);
    }

    @RequestMapping(path = "/productdetail", method = RequestMethod.GET)
    public ProductDTO getProductDetail(@RequestParam("productCode") String productCode) {
        return productService.getProductDetail(productCode);
    }

}
