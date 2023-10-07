package cn.lzy.Web.mvc.file;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.UUID;

@Controller
public class FileController {
    @GetMapping("/toUpload")
    public String toUpload() {
        return "upload";
    }
// @GetMapping("/toDownload")
// public String toDownload(){
// return "download";
// }


    //文件上传管理
    @PostMapping("/uploadFile")
    public String uploadFile(MultipartFile[] fileUpload, Model model) {
        model.addAttribute("uploadStatus", "上传成功");
        for (MultipartFile file : fileUpload) {
            String fileName = file.getOriginalFilename();//获取文件名及后缀名
            fileName = UUID.randomUUID() + "_" + fileName;//重新生成文件名
            String dirPath = "E:/Study/study";
            File filePath = new File(dirPath);
            if (!filePath.exists()) {
                filePath.mkdirs();
            }
            try {
                file.transferTo(new File(dirPath + fileName));
            } catch (Exception e) {
                e.printStackTrace();
                model.addAttribute("uploadStatus", "上传失败：" + e.getMessage());
            }
        }
        return "upload";
    }
//    @GetMapping("/toDownload")
//public ResponseEntity<byte[]> fileDownload(String filename) {
////指定要下载的文件根路径
//String dirPath = "D:/1/";
//
// //创建文件对象
// File file = new File(dirPath + File.separator + filename);
//
// //设置响应头
//HttpHeaders headers = new HttpHeaders();
//
////通知浏览器以下载方式打开
//headers.setContentDispositionFormData("attachment", filename);
//
////定义以流的形式下载返回文件数据
// headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
// try {
// return new ResponseEntity<>(FileUtil
}