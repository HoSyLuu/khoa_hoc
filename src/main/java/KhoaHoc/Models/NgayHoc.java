package KhoaHoc.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "ngayhoc")
public class NgayHoc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ngayhocid")
    private int ngayHocId;
    @Column(name = "noidung")
    private String noiDung;
    @Column(name = "ghichu")
    private String ghiChu;
    @Column(name = "khoahocid",insertable = false,updatable = false)
    private int khoaHocId;
    @ManyToOne()
    @JoinColumn(name = "khoahocid")
    @JsonBackReference
    private KhoaHoc khoaHoc;

    public int getNgayHocId() {
        return ngayHocId;
    }

    public void setNgayHocId(int ngayHocId) {
        this.ngayHocId = ngayHocId;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
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
