package com.product.productreview.service;

import com.product.productreview.dto.ReviewDTO;

public interface IReviewService {
    ReviewDTO submitReview(ReviewDTO reviewDTO);
}
