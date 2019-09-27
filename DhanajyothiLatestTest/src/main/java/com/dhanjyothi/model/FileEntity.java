package com.dhanjyothi.model;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "FILE")
public class FileEntity {

    @Id
    @GeneratedValue
    @Column(name = "FILE_ID")
    private long id;
    @Column(name = "FILE_NAME")
    private String fileName;
    @Column(name = "FILE_DATA")
    private byte[] data;
 
  
    public long getId() {
        return id;
    }
 
    public void setId(long id) {
        this.id = id;
    }
 
  
    public String getFileName() {
        return fileName;
    }
 
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
 
    
    public byte[] getData() {
        return data;
    }
 
    public void setData(byte[] data) {
        this.data = data;
    }

	@Override
	public String toString() {
		return "FileEntity [id=" + id + ", fileName=" + fileName + ", data=" + Arrays.toString(data) + "]";
	}
}

