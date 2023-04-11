package com.gwen.minibolt.service.ServiceInt;

import com.gwen.minibolt.model.Image;
import org.springframework.web.multipart.MultipartFile;

public interface FileManagementService {
    void uploadToLocalDesktop(MultipartFile multipartFile);
    Image saveFileToDB(MultipartFile file);
    Image downLoadFile(String fileId);

    String generateDownLoadUri(Image image);
}
