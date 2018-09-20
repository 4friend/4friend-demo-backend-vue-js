package com.product.productreview.service.Impl;

import com.product.productreview.dto.ReviewDTO;
import com.product.productreview.model.ProductReview;
import com.product.productreview.repo.ProductReviewRepository;
import com.product.productreview.service.IReviewService;
import ma.glasnost.orika.MapperFacade;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class ReviewService implements IReviewService {

    private final ProductReviewRepository productReviewRepository;
    private final MapperFacade objectMapper;

    public ReviewService(ProductReviewRepository productReviewRepository, MapperFacade objectMapper) {
        this.productReviewRepository = productReviewRepository;
        this.objectMapper = objectMapper;
    }

    @Override
    public ReviewDTO submitReview(ReviewDTO reviewDTO) {
        ProductReview productReview = objectMapper.map(reviewDTO, ProductReview.class);
        productReview = productReviewRepository.save(productReview);
        return objectMapper.map(productReview, ReviewDTO.class);
    }
}
