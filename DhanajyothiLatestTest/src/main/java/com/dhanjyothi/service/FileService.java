package com.dhanjyothi.service;

import java.util.List;

import com.dhanjyothi.model.FileEntity;

public interface FileService {
	public void saveFileUpload(FileEntity fileEntity);

	public List<FileEntity> viewAllFiles();

	public List<FileEntity> findByName(String fileName);
}
