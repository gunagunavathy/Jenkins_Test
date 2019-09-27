package com.dhanjyothi.dao;

import java.util.List;

import com.dhanjyothi.model.FileEntity;

public interface FileDao {
	public void saveFileUpload(FileEntity fileEntity);

	public List<FileEntity> viewAllFiles();

	public List<FileEntity> findByName(String fileName);
}
