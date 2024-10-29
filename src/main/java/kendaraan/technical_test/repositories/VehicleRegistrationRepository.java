package kendaraan.technical_test.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import kendaraan.technical_test.models.VehicleRegistration;

public interface VehicleRegistrationRepository extends JpaRepository<VehicleRegistration, String> {
    //
}
