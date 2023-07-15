package com.example.photoclone.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("PHOTOZ")
public class Photo {

    @Id
    private Integer id;

    @NotEmpty
    private String fileName;

    private String contentType;
    // Moar stuff later

    @JsonIgnore
    private byte[] data;

    public Photo() {
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }


    public Integer getId() {
        return id;
    }

    public Integer setId(Integer id) {
        return id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }
}
