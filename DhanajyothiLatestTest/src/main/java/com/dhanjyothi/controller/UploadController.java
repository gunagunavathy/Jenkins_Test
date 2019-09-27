package com.dhanjyothi.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import org.springframework.core.io.ByteArrayResource;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.dhanjyothi.model.UploadFile;

@Controller
public class UploadController {
	@RequestMapping(value = "/show", method = RequestMethod.GET)
	public ModelAndView showUpload() {
		System.out.println("show upload ");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("uploadfile", new UploadFile());
		modelAndView.setViewName("upload_file");
		return modelAndView;

	}

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public ModelAndView fileUploadPage(UploadFile uploadFile) throws IOException {
		System.out.println("file upload");
		MultipartFile multipartFile = uploadFile.getFile();
		String uploadPath = "C://Users//jason.d//Downloads//files//"; 
		FileCopyUtils.copy(uploadFile.getFile().getBytes(),
				new File(uploadPath + uploadFile.getFile().getOriginalFilename()));
		String filename = multipartFile.getOriginalFilename();
		return new ModelAndView("upload_success", "filename", filename);

	}

	@RequestMapping(value = "/download", method = RequestMethod.GET)
	public ModelAndView fileDownloadPage(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("file download");
		File file = new File("C://Users//jason.d//Downloads//files//");

		response.setHeader("Content-Disposition", "attachment;filename=" + file.getName());
		BufferedInputStream inStrem = new BufferedInputStream(new FileInputStream(file));
		BufferedOutputStream outStream = new BufferedOutputStream(response.getOutputStream());

		byte[] buffer = new byte[1024];
		int bytesRead = 0;
		while ((bytesRead = inStrem.read(buffer)) != -1) {
			outStream.write(buffer, 0, bytesRead);
		}
		outStream.flush();
		inStrem.close();

		return new ModelAndView("download_success");
	}
}
