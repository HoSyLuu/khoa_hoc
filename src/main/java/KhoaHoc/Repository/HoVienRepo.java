package KhoaHoc.Repository;

import KhoaHoc.Models.HocVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HoVienRepo extends JpaRepository<HocVien,Integer> {
}
