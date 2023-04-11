package com.gwen.minibolt.export_data;

import lombok.Data;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;

@Data
public class ResourceDto {
    private Resource resource;
    private MediaType mediaType;
    private String filename;
}
