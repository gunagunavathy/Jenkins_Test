package com.dhanjyothi.controller;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.dhanjyothi.model.FileEntity;
import com.dhanjyothi.service.FileService;

@Controller
public class FileController {
	@Autowired
	public FileService fileService;

	@GetMapping("/showuploadpage")
	public ModelAndView showUploadPage() {
		System.out.println("showuploadpage");
		return new ModelAndView("uploadfiledb");
	}

	@PostMapping(value = "/doUpload")
	public ModelAndView saveFileUpload(HttpServletRequest request, @RequestParam CommonsMultipartFile[] fileUpload)
			throws Exception {
		if (fileUpload != null && fileUpload.length > 0) {
			for (CommonsMultipartFile newfile : fileUpload) {
				System.out.println("saving file :" + newfile.getOriginalFilename());
				FileEntity fileEntity = new FileEntity();
				fileEntity.setFileName(newfile.getOriginalFilename());
				fileEntity.setData(newfile.getBytes());
				fileService.saveFileUpload(fileEntity);
			}
		}

		return new ModelAndView("redirect:/viewall");
	}

	@GetMapping("/viewall")
	public ModelAndView viewAllFiles() {
		List<FileEntity> list = fileService.viewAllFiles();
		return new ModelAndView("getall_files", "li", list);
	}

	@GetMapping("/doDownload/{fileName}")
	public ModelAndView downloadFile(@PathVariable("fileName") String fileName, HttpServletResponse response)
			throws IOException {
		System.out.println("download page");
		List<FileEntity> list = fileService.findByName(fileName);
		for (FileEntity fileEntity : list) {
			System.out.println(fileEntity);
			response.setContentLength(fileEntity.getData().length);
			response.setHeader("Content-Disposition", "attachment; filename=\"" + fileEntity.getFileName() + "\"");
			FileCopyUtils.copy(fileEntity.getData(), response.getOutputStream());
		}
		return new ModelAndView("uploadfiledbsuccess");

	}

}
