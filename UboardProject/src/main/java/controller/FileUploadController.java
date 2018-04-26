/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.File;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.file.Files;
import static java.nio.file.Files.list;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.rmi.Naming.list;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FileUploadController {

    //Save the uploaded file to this folder
    private static String UPLOADED_FOLDER = "C:\\Users\\qtown\\OneDrive\\Documents\\NetBeansProjects\\UboardProject\\src\\main\\resources\\templates\\sounds\\";

    @GetMapping("/upload")
    public String index(@RequestParam(value="id") String id, Model m) {
        m.addAttribute("soundid", id);
        return "upload";
    }
        
    @Autowired
    private SoundRepository soundRepository;
    @PostMapping("/upload") // //new annotation since 4.3
    public String singleFileUpload(@RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes, @RequestParam Integer buttonNumber
			, @RequestParam String color) {
        
                
        
        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            return "redirect:uploadStatus";
        }

        try {

            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);
            Sound n = new Sound();
            n.setButtonNumber(buttonNumber);
            n.setFileName(file.getOriginalFilename());
            n.setColor(color);
            soundRepository.save(n);
            redirectAttributes.addFlashAttribute("message",
                    "You successfully uploaded '" + file.getOriginalFilename() + "'");

        } catch (IOException e) {
            e.printStackTrace();
        }

        return "redirect:/uploadStatus";
    }

       /* public String getFileNameByNumber(Integer number)
        {
            return soundRepository.findByNumber(number).getFileName();
        }*/
   // @GetMapping(path="/all")
	public void getSoundFile(Integer number) {
		
                System.out.println(soundRepository.findAll());
           /* String fileName = getFileNameByNumber(number);
            try {
                    File file = new ClassPathResource(fileName).getFile();
                    return file;
                } 
            catch (IOException ex) 
            {
                Logger.getLogger(FileUploadController.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }*/
              
	}
        
        
        public ArrayList<Sound> TraverseSounds()
        {
            Sound mySound = new Sound();
            ArrayList<Sound> mySoundList = new ArrayList();
            soundRepository.findAll().forEach(Sound -> mySoundList.add(Sound));
            return mySoundList;
            
        }
        
        
        
        @GetMapping(path="/all")
        public @ResponseBody Iterable<Sound> getAll()
        {
            return soundRepository.findAll();
        }
    @GetMapping(path="/soundboard")
        public String soundBoard(Model model)
        {
            List<Integer> numberlist = new ArrayList();
            List<String> fileList = new ArrayList();
            List<String> colorList = new ArrayList();
            ArrayList<Sound> mySounds = TraverseSounds();
            for(int i = 0; i < mySounds.size(); i++)
            {
                numberlist.add(mySounds.get(i).getButtonNumber());
                fileList.add(mySounds.get(i).getFileName());
                colorList.add(mySounds.get(i).getColor());
                
            }
            model.addAttribute("soundlist", mySounds);
            model.addAttribute("numbers", numberlist);
            model.addAttribute("filenames", fileList);
            model.addAttribute("colors", colorList);
            
            return "soundboard";
        }
        
    @GetMapping("/uploadStatus")
    public String uploadStatus() {
        return "uploadStatus";
    }

}