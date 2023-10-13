package utils;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Component
public class ImageUpload {
    private static final String UPLOAD_FOLDER = "C:\\Users\\ADMIN\\OneDrive\\Documents\\GitHub\\SWP390\\SWP390\\SpringBoot\\Library\\src\\main\\resources\\static\\img";
    public static boolean uploadFile(MultipartFile file) {
        boolean isUpload = false;
        try {
            Files.copy(file.getInputStream(), Paths.get(UPLOAD_FOLDER + File.separator + file.getOriginalFilename()) , StandardCopyOption.REPLACE_EXISTING);
            isUpload = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isUpload;
    }

    public static boolean checkExist(MultipartFile multipartFile){
        boolean isExist = false;
        try {
           File file = new File(UPLOAD_FOLDER +"\\" + multipartFile.getOriginalFilename());
           isExist = file.exists();
        }catch (Exception e){
            e.printStackTrace();
        }
        return isExist;
    }
}
