package cn.lzy.Web.mvc.file;


import org.apache.commons.io.FileUtils;
import org.aspectj.util.FileUtil;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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

//    @GetMapping("/toDownload")
//    public String toDownload() {
//        return "download";
//    }


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

    @GetMapping("/toDownload") // http://localhost:8092/toDownload
    public String toDownload() {
        return "download";
    }

    @GetMapping("/download")
    public ResponseEntity<byte[]> fileDownload(HttpServletRequest request, String filename) throws Exception {
// 指定要下载的文件根路径
        String dirPath = "D:/1/";
// 创建该文件对象
        File file = new File(dirPath + File.separator + filename);

// 设置响应头
        HttpHeaders headers = new HttpHeaders();
        filename=getFilename(request,filename);
// 通知浏览器以下载方式打开
        headers.setContentDispositionFormData("attachment", filename);
// 定义以流的形式下载返回文件数据
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        try {
            return new ResponseEntity<>(FileUtils.readFileToByteArray(file), headers, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<byte[]>(e.getMessage().getBytes(), HttpStatus.EXPECTATION_FAILED);
        }
    }
    private String getFilename(HttpServletRequest request, String filename)
            throws Exception {
// IE不同版本User-Agent中出现的关键词
        String[] IEBrowserKeyWords = {"MSIE", "Trident", "Edge"};
// 获取请求头代理信息
        String userAgent = request.getHeader("User-Agent");
        for (String keyWord : IEBrowserKeyWords) {
            if (userAgent.contains(keyWord)) {
//IE内核浏览器，统一为UTF-8编码显示，并对转换的+进行更正
                return URLEncoder.encode(filename, "UTF-8").replace("+"," ");
            }
        }
//火狐等其它浏览器统一为ISO-8859-1编码显示
        return new String(filename.getBytes("UTF-8"), "ISO-8859-1");
    }
}