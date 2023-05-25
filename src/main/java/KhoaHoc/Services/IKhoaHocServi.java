package KhoaHoc.Services;

import KhoaHoc.Models.HocVien;
import KhoaHoc.Models.KhoaHoc;
import KhoaHoc.Models.NgayHoc;

import java.util.List;

public interface IKhoaHocServi {
    public NgayHoc them1NgayHoc(NgayHoc khm);
    public HocVien remakeHocVien(HocVien hsSua);
    public KhoaHoc removeKhoaHoc(int khoaHocId);
    public List<HocVien> getHocSinhKhoaHoc(String hoTen, int khoaHocId);
    public String tinhdoanhthu();
}
