//package fr.formation.matieres.controller;
//
//import javax.servlet.http.HttpServletRequest;
//
// 
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.multipart.commons.CommonsMultipartFile;
//
//import fr.formation.matieres.dao.FileUploadDAO;
//import fr.formation.matieres.model.UploadFile;
// 
///**
// * Handles requests for the file upload page.
// */
//@Controller
//public class UploadController {
//    @Autowired
//    private FileUploadDAO fileUploadDao;
// 
//    @RequestMapping(value = "/upload", method = RequestMethod.GET)
//    public String showUploadForm(HttpServletRequest request) {
//        return "Upload";
//    }
//     
//    @RequestMapping(value = "/doUpload", method = RequestMethod.POST)
//    public String handleFileUpload(HttpServletRequest request,
//            @RequestParam CommonsMultipartFile[] fileUpload) throws Exception {
//          
//        if (fileUpload != null && fileUpload.length > 0) {
//            for (CommonsMultipartFile aFile : fileUpload){
//                  
//                System.out.println("Saving file: " + aFile.getOriginalFilename());
//                 
//                UploadFile uploadFile = new UploadFile();
//                uploadFile.setFileName(aFile.getOriginalFilename());
//                uploadFile.setData(aFile.getBytes());
//                fileUploadDao.save(uploadFile);               
//            }
//        }
//  
//        return "Success";
//    }  
//}