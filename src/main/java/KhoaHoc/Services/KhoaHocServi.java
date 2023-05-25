package KhoaHoc.Services;

import KhoaHoc.Models.HocVien;
import KhoaHoc.Models.KhoaHoc;
import KhoaHoc.Models.NgayHoc;
import KhoaHoc.Repository.HoVienRepo;
import KhoaHoc.Repository.KhoaHocRepo;
import KhoaHoc.Repository.NgayHocRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
public class KhoaHocServi implements IKhoaHocServi {
    @Autowired
    private KhoaHocRepo khoaHocRepo;
    @Autowired
    private NgayHocRepo ngayHocRepo;
    @Autowired
    private HoVienRepo hoVienRepo;

    @Override
    public NgayHoc them1NgayHoc(NgayHoc nhm) {
        ngayHocRepo.save(nhm);
        return nhm;
    }

    @Override
    public HocVien remakeHocVien(HocVien hsSua) {
        Optional<HocVien> hocVien = hoVienRepo.findById(hsSua.getHocVienId());
        if (hocVien.isEmpty()) {
            return null;
        }
        HocVien hv = hocVien.get();
        hv.setKhoaHocId(hsSua.getKhoaHocId());
        hv.setNgaySinh(hsSua.getNgaySinh());
        hv.setQueQuan(hsSua.getQueQuan());
        hv.setDiaChi(hsSua.getDiaChi());
        hv.setSdt(hsSua.getSdt());
        hoVienRepo.save(hv);
        return hv;
    }

    @Override
    public KhoaHoc removeKhoaHoc(int khoaHocId) {
        Optional<KhoaHoc> khoaHoc = khoaHocRepo.findById(khoaHocId);
        if (khoaHoc.isEmpty()) {
            return null;
        }
        khoaHocRepo.delete(khoaHoc.get());
        return khoaHoc.get();
    }

    @Override
    public List<HocVien> getHocSinhKhoaHoc(String hoTen, int khoaHocId) {
        List<HocVien> hocVienList = new ArrayList<>();
        for (HocVien hv : hoVienRepo.findAll()) {
            if (hv.getHoTen().toLowerCase().contains(hoTen.toLowerCase()) && hv.getKhoaHoc().getKhoaHocId() == khoaHocId) {
                hocVienList.add(hv);
            }
        }
        return hocVienList;
    }

    @Override
    public String tinhdoanhthu() {
        String lst = "";
        for (int  i = 1; i <= 12; i++)
        {
            int doanhthu =0;
            for (KhoaHoc kh: khoaHocRepo.findAll())
            {
                LocalDate nbd = kh.getNgayBatDau();
                if( nbd.getMonthValue() == i)
                {
                    for (HocVien hv:hoVienRepo.findAll())
                    {
                        if (hv.getKhoaHoc() == kh   )
                        {
                            doanhthu += kh.getHocPhi();
                        }
                    }
                }
            }
            lst += "Thang " + String.valueOf(i)+" "+String.valueOf(doanhthu)+"\n";
        }
        return lst;
    }
//        String lst = "";
//        for (int i = 1; i <= 12; i++) {
//            int doanhthu = 0;
//            for (KhoaHoc kh : khoaHocRepo.findAll()) {
//                LocalDate lc = kh.getNgayBatDau();
//                if (lc.getMonthValue() == i) {
//                    for (HocVien hv : hoVienRepo.findAll()) {
//                        if (hv.getKhoaHocId() == kh.getKhoaHocId()) {
//                            doanhthu += kh.getHocPhi();
//                        }
//                    }
//                }
//             }
//            lst += "Thang" + String.valueOf(i) + " " + String.valueOf(doanhthu) + "\n";
//        }
//        return lst;
//    }
}
