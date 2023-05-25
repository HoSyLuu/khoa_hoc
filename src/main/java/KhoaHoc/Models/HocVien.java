package KhoaHoc.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Table(name="hocvien")
public class HocVien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hocvienid")
    private int hocVienId;
    @Column(name = "hoten")
    private  String hoTen;
    @Column(name = "ngaysinh")
    private LocalDate ngaySinh;
    @Column(name = "quequan")
    private String queQuan;
    @Column(name = "diachi")
    private String diaChi;
    @Column(name = "sdt")

    private String sdt;
    @Column(name = "khoahocid",insertable = false,updatable = false)
    private int khoaHocId;
    @ManyToOne()
    @JoinColumn(name = "khoahocid")
    @JsonBackReference
    private KhoaHoc khoaHoc;

    public int getHocVienId() {
        return hocVienId;
    }

    public void setHocVienId(int hocVienId) {
        this.hocVienId = hocVienId;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public LocalDate getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(LocalDate ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getQueQuan() {
        return queQuan;
    }

    public void setQueQuan(String queQuan) {
        this.queQuan = queQuan;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public int getKhoaHocId() {
        return khoaHocId;
    }

    public void setKhoaHocId(int khoaHocId) {
        this.khoaHocId = khoaHocId;
    }

    public KhoaHoc getKhoaHoc() {
        return khoaHoc;
    }

    public void setKhoaHoc(KhoaHoc khoaHoc) {
        this.khoaHoc = khoaHoc;
    }
}
