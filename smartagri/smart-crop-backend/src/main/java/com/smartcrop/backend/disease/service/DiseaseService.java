package com.smartcrop.backend.disease.service;

import com.smartcrop.backend.disease.dto.DiseaseRequest;
import com.smartcrop.backend.disease.entity.Disease;
import com.smartcrop.backend.disease.repository.DiseaseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiseaseService {

    private final DiseaseRepository repo;

    public DiseaseService(DiseaseRepository repo) {
        this.repo = repo;
    }

    // 🔍 Predict Disease (Mock AI Logic)
    public Disease predict(DiseaseRequest request) {

        Disease disease = new Disease();
        disease.setCropName(request.getCropName());
        disease.setSymptoms(request.getSymptoms());

        // Mock AI rules
        if (request.getSymptoms().toLowerCase().contains("yellow")) {
            disease.setDiseaseName("Leaf Blight");
            disease.setSeverity("Medium");
            disease.setTreatment(
                "Remove infected leaves. Maintain field hygiene."
            );
            disease.setPesticide(
                "Spray Mancozeb 2g/L water."
            );

        } else if (request.getSymptoms().toLowerCase().contains("spots")) {
            disease.setDiseaseName("Brown Spot");
            disease.setSeverity("High");
            disease.setTreatment(
                "Use resistant varieties. Improve drainage."
            );
            disease.setPesticide(
                "Apply Carbendazim 1g/L water."
            );

        } else {
            disease.setDiseaseName("Healthy / Unknown");
            disease.setSeverity("Low");
            disease.setTreatment(
                "No major disease detected."
            );
            disease.setPesticide("Not required.");
        }

        return repo.save(disease);
    }

    // 📜 Get All Records
    public List<Disease> getAll() {
        return repo.findAll();
    }

    // 🔎 Get By ID
    public Disease getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    // ❌ Delete
    public void delete(Long id) {
        repo.deleteById(id);
    }
}
