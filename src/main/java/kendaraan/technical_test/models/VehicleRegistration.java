package kendaraan.technical_test.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import kendaraan.technical_test.enums.FuelType;
import kendaraan.technical_test.enums.VechileColor;
import lombok.Data;

@Entity
@Table(name = "vehicle_registration")
@Data
public class VehicleRegistration {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nomor registrasi kendaraan tidak boleh kosong")
    @Column(unique = true, nullable = false)
    private String nomorRegistrasiKendaraan;

    @NotBlank(message = "Nama pemilki tidak boleh kosong")
    private String namaPemilik;

    @NotBlank(message = "Alamat tidak boleh kosong")
    @Size(min = 10, max = 100, message="Minimal 10 Karakter dan maksimal 100 Karakter")
    private String alamat;

    @NotBlank(message = "Merek kendaraan tidak boleh kosong")
    @Size(min = 3, max = 20, message="Minimal 3 karakter dan maksimal 20 karakter")
    private String merkKendaraan;

    @NotNull(message = "Tahun pembuatan tidak boleh kosong")
    @Min(value = 2010, message = "Tahun pembuatan tidak boleh lebih rendah dari 2010")
    @Max(value = 2025, message = "Tahun pembuatan tidak boleh lebih tinggi dari 2025")
    private Integer tahunPembuatan;

    @NotNull(message = "Kapasitas silinder tidak boleh kosong")
    private Integer kapasitasSilinder;

    @NotNull(message = "Warna kendaraan tidak boleh kosong")
    private VechileColor warnaKendaraan;

    @NotNull(message = "Bahan bakar tidak boleh kosong")
    private FuelType bahanBakar;
    
}
