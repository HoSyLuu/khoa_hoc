package KhoaHoc.Controller;

import KhoaHoc.Models.HocVien;
import KhoaHoc.Models.KhoaHoc;
import KhoaHoc.Models.NgayHoc;
import KhoaHoc.Repository.NgayHocRepo;
import KhoaHoc.Services.KhoaHocServi;
import com.google.gson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(value = "api/version1.0")
public class KhoaHocControll {
    @Autowired
    private KhoaHocServi khoaHocServi;

    @RequestMapping(value = "themngayhoc", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public NgayHoc addNewNgayHoc(@RequestBody String ngayHoc){
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new JsonDeserializer<LocalDate>() {
            @Override
            public LocalDate deserialize(JsonElement json, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
                return LocalDate.parse(json.getAsJsonPrimitive().getAsString());
            }
        }).create();
        NgayHoc nh = gson.fromJson(ngayHoc, NgayHoc.class);
        return khoaHocServi.them1NgayHoc(nh);
    }
    @RequestMapping(value = "sua1hocvien",method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public HocVien remakeHocVien(@RequestBody String hvSua){
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new JsonDeserializer<LocalDate>() {
            @Override
            public LocalDate deserialize(JsonElement json, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
                return LocalDate.parse(json.getAsJsonPrimitive().getAsString());
            }
        }).create();
        HocVien hv = gson.fromJson(hvSua, HocVien.class);
        return khoaHocServi.remakeHocVien(hv);
    }
    @RequestMapping(value = "xoakhoahoc", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public KhoaHoc removeKhoaHoc(@RequestParam int khoaHocId){
        return khoaHocServi.removeKhoaHoc(khoaHocId);
    }
    @RequestMapping(value = "timtenvakhoahoc", method = RequestMethod.GET)
    public List<HocVien> getHocSinhKhoaHoc(@RequestParam String hoTen,  int khoaHocId){
        return khoaHocServi.getHocSinhKhoaHoc(hoTen,khoaHocId);
    }
    @RequestMapping(value = "doanhthu", method = RequestMethod.GET)
    public String tinhdoanhthu(){
        return khoaHocServi.tinhdoanhthu();
    }
}
