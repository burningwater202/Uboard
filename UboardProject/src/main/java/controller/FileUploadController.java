/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FileUploadController {

    //Save the uploaded file to this folder
    private static final String UPLOADED_FOLDER = "C:\\Users\\qtown\\OneDrive\\Documents\\NetBeansProjects\\UboardProject\\src\\main\\webapp\\resources\\sounds\\";

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
    
        public ArrayList<Sound> TraverseSounds()
        {
            Sound mySound = new Sound();
            ArrayList<Sound> mySoundList = new ArrayList();
            soundRepository.findAll().forEach(Sound -> mySoundList.add(Sound));
            return mySoundList;
            
        }
        
        @RequestMapping("/sounds/{fileName}")
    public void downloadPDFResource( HttpServletRequest request,
                                     HttpServletResponse response,
                                     @PathVariable("fileName") String fileName)
    {
        String dataDirectory = request.getServletContext().getRealPath("/resources/sounds/");
        System.out.println(dataDirectory);
        Path file = Paths.get(dataDirectory, fileName);
        if (Files.exists(file))
        {
            InputStream in = getClass().getResourceAsStream(file.toString());
            
            response.setContentType("audio/mpeg");
            response.addHeader("Content-Disposition", "attachment; filename="+fileName);
            try
            {
                Files.copy(file, response.getOutputStream());
                response.getOutputStream().flush();
            }
            catch (IOException ex) {
                ex.printStackTrace();
            }
        }
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