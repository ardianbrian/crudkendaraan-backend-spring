package kendaraan.technical_test.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kendaraan.technical_test.models.VehicleRegistration;
import kendaraan.technical_test.repositories.VehicleRegistrationRepository;

@Service
public class VehicleRegistrationService {
    
    @Autowired
    private VehicleRegistrationRepository repository;

    public List<VehicleRegistration> findAll() {
        return repository.findAll();
    }

    public Optional<VehicleRegistration> findById(String id) {
        return repository.findById(id);
    }

    public VehicleRegistration save(VehicleRegistration vehicleRegistration) {
        return repository.save(vehicleRegistration);
    }

    public void deleteById(String id) {
        repository.deleteById(id);
    }
}
