package com.gwen.minibolt.service.serviceImp;

import com.gwen.minibolt.model.Image;
import com.gwen.minibolt.repository.ImageRepository;
import com.gwen.minibolt.service.ServiceInt.FileManagementService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
@RequiredArgsConstructor
@Service
public class FileManagementServiceImpl implements FileManagementService {
    private String uploadFolderPath = "C:/Users/Gracias/Documents/mini_bolt_file";
    private final ImageRepository imageRepository;
    /**
     * @param file
     */
    @Override
    public void uploadToLocalDesktop(MultipartFile file) {

        try {
            byte[] data = file.getBytes();
            Path path = Paths.get(uploadFolderPath+ file.getOriginalFilename());
            Files.write(path,data);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    /**
     * @param file
     * @return
     */
    @Override
    public Image saveFileToDB(MultipartFile file) {

        try {
            Image imageFile = new Image();
            imageFile.setContent(file.getBytes());
            imageFile.setFileType(file.getContentType());
            imageFile.setName(file.getName());
            return imageRepository.save(imageFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * @param fileId
     * @return
     */
    @Override
    public Image downLoadFile(String fileId) {
    return imageRepository.findById(fileId).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public String generateDownLoadUri(Image image) {
        return ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/api/v1/download/").path(image.getId()).toUriString();
    }
}
