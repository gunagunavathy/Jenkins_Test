package com.dhanjyothi.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.dhanjyothi.dao.FileDao;
import com.dhanjyothi.model.FileEntity;

@Repository("FileDao")
public class FileDaoImpl implements FileDao {
	@Autowired
	//@Qualifier("hibernateTemplate")
	private HibernateTemplate hibernateTemplate;

	public void saveFileUpload(FileEntity fileEntity) {
		hibernateTemplate.save(fileEntity);
	}

	public List<FileEntity> viewAllFiles() {
		return hibernateTemplate.loadAll(FileEntity.class);
	}

	public List<FileEntity> findByName(String fileName) {
		List<FileEntity> list = (List<FileEntity>) hibernateTemplate.find(
				"from FileEntity where fileName=:fileName", fileName);
		System.out.println(list);
		return list;
	}

}
