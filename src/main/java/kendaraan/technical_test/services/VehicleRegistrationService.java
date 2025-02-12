package kendaraan.technical_test.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import kendaraan.technical_test.exceptions.DuplicateRegistrationException;
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
        try {
            return repository.save(vehicleRegistration);
        } catch (DataIntegrityViolationException e) {
            throw new DuplicateRegistrationException("Nomor registrasi kendaraan sudah ada");
        }
    }

    public void deleteById(String id) {
        repository.deleteById(id);
    }
}
