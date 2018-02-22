package fr.formation.matieres.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import fr.formation.matieres.dao.IUploadFileDAO;
import fr.formation.matieres.model.UploadFile;

/**
 * Handles requests for the file upload page.
 */
@Controller
public class UploadController {
	@Autowired
	private IUploadFileDAO fileUploadDao;

	@GetMapping("/upload")
	public String showUploadForm(HttpServletRequest request) {
		return "Upload";
	}

	@PostMapping("/upload/doUpload")
	public String handleFileUpload(HttpServletRequest request, @RequestParam CommonsMultipartFile[] fileUpload)
			throws Exception {

		if (fileUpload != null && fileUpload.length > 0) {
			for (CommonsMultipartFile aFile : fileUpload) {

				System.out.println("Saving file: " + aFile.getOriginalFilename());

				UploadFile uploadFile = new UploadFile();
				uploadFile.setFileName(aFile.getOriginalFilename());
				uploadFile.setData(aFile.getBytes());
				fileUploadDao.save(uploadFile);
			}
		}

		return "Success";
	}

	@GetMapping("/upload/download")
	public String findAll(Model model) {
		model.addAttribute("fichiers", fileUploadDao.findAll());
		return "Download";
	}

	@GetMapping("/upload/download/supprimer")
	public String supprimer(@RequestParam("id") long id) {
		fileUploadDao.deleteById(id);
		return "redirect:./";
	}

//	@RequestMapping("/upload/download/{documentId}")
//	public String download(@PathVariable("documentId")
//			Long documentId, HttpServletResponse response) {
//		
//		Optional<UploadFile> doc = fileUploadDao.findById(documentId);
//				//get(documentId);
//		try {
//			response.setHeader("Content-Disposition", "inline;filename=\"" +doc.getFilename()+ "\"");
//			OutputStream out = response.getOutputStream();
//			response.setContentType(doc.getContentType());
//			IOUtils.copy(doc.getContent().getBinaryStream(), out);
//			out.flush();
//			out.close();
//		
//		} catch (IOException e) {
//			e.printStackTrace();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//		return "redirect:./";
//	}
	
//	@GetMapping(value = "/upload/download/doDownload", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
//	public @ResponseBody byte[] getFile() throws IOException {
//		InputStream in = getClass().getResourceAsStream("/com/baeldung/produceimage/data.txt");
//		return IOUtils.toByteArray(in);
//	}

}