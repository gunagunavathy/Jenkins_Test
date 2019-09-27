package com.dhanjyothi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dhanjyothi.dao.impl.FileDaoImpl;
import com.dhanjyothi.model.FileEntity;
import com.dhanjyothi.service.FileService;

@Service("FileService")
public class FileServiceImpl implements FileService {
	@Autowired
	public FileDaoImpl fileDaoImpl;

	@Transactional
	public void saveFileUpload(FileEntity fileEntity) {
		fileDaoImpl.saveFileUpload(fileEntity);
	}

	public List<FileEntity> viewAllFiles() {
		return fileDaoImpl.viewAllFiles();
	}

	public List<FileEntity> findByName(String fileName) {
		return fileDaoImpl.findByName(fileName);
	}

}
