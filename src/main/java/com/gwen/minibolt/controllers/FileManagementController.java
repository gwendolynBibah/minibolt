package com.gwen.minibolt.controllers;

import com.gwen.minibolt.service.ServiceInt.FileManagementService;
import lombok.RequiredArgsConstructor;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/")
public class FileManagementController {

    private final FileManagementService fileManagementService;
    @GetMapping("download/{fileId}")
    public ResponseEntity<?> download(@PathVariable String fileId){
       var file = fileManagementService.downLoadFile(fileId);
       HttpHeaders headers = new HttpHeaders();
       headers.add(HttpHeaders.CONTENT_DISPOSITION,"attachment: filename "+file.getName());
       return ResponseEntity.ok()
               .contentType(MediaType.parseMediaType(file.getFileType()))
               .headers(headers)
               .body(new ByteArrayResource(file.getContent()));
    }
}
