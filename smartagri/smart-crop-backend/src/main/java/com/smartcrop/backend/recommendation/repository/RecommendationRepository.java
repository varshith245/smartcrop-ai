
package com.smartcrop.backend.recommendation.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.smartcrop.backend.recommendation.entity.Recommendation;
public interface RecommendationRepository extends JpaRepository<Recommendation,Long>{}
