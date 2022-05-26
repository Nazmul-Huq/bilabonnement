package com.kea.bilabonnement.utility;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Author Nazmul
 */
public class FileHandler {

    /**
     * save a file in the respected folder
     * @param fileName
     * @param multipartFile
     * @return
     */
    public static boolean saveFile(String fileName, MultipartFile multipartFile) {
        Path uploadPath = Paths.get("src/main/resources/static/stylesheets/reg-certificate");
        try {
            Files.copy(multipartFile.getInputStream(), uploadPath.resolve(fileName));
            return true;
        } catch (IOException ioe) {
           return false;
        }
    }


}
