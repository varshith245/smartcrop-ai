package com.smartcrop.backend.admin.service;

import com.smartcrop.backend.admin.dto.DashboardStats;
import com.smartcrop.backend.user.repository.UserRepository;
import com.smartcrop.backend.farm.repository.FarmRepository;
import com.smartcrop.backend.crop.repository.CropRepository;
import com.smartcrop.backend.disease.repository.DiseaseRepository;
import com.smartcrop.backend.yield.repository.YieldRepository;

import org.springframework.stereotype.Service;

@Service
public class AdminService {

    private final UserRepository userRepo;
    private final FarmRepository farmRepo;
    private final CropRepository cropRepo;
    private final DiseaseRepository diseaseRepo;
    private final YieldRepository yieldRepo;

    public AdminService(
            UserRepository userRepo,
            FarmRepository farmRepo,
            CropRepository cropRepo,
            DiseaseRepository diseaseRepo,
            YieldRepository yieldRepo
    ) {
        this.userRepo = userRepo;
        this.farmRepo = farmRepo;
        this.cropRepo = cropRepo;
        this.diseaseRepo = diseaseRepo;
        this.yieldRepo = yieldRepo;
    }

    // 📊 Dashboard Stats
    public DashboardStats getStats() {

    long yieldCount = yieldRepo.count();

    System.out.println("🔥 Yield Count From JPA = " + yieldCount);

    return new DashboardStats(
            userRepo.count(),
            farmRepo.count(),
            cropRepo.count(),
            diseaseRepo.count(),
            yieldCount
    );
}
}
