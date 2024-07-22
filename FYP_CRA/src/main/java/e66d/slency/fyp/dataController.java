package e66d.slency.fyp;

/**
 * @author slenc
 *
 */

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.nio.file.StandardCopyOption; 


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.validation.Valid;

@Controller 
public class dataController {

    @Autowired
    private dataRepository dataRepository;

    @GetMapping("/data")
    public String viewData(Model model) {
        List<data> listData = dataRepository.findAll();
        model.addAttribute("listData", listData);
        return "view_data";
    }

    // Add data
    @GetMapping("/data/add")
    public String addData(Model model) {
        model.addAttribute("data", new data());
        return "add_data";
    }

    @PostMapping("/data/save")
    public String saveData(@RequestParam("file") MultipartFile excelFile, RedirectAttributes redirectAttribute, @Valid data data, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) { //checks if theres no error
            return "add_data";
        }

        String excelFileName = excelFile.getOriginalFilename();
        data.setExcelFileName(excelFileName);
        data savedData = dataRepository.save(data);

        try {
            String uploadDir = "uploads/data/" + savedData.getId();
            Path uploadPath = Paths.get(uploadDir);

            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }

            Path fileToCreatePath = uploadPath.resolve(excelFileName);
            Files.copy(excelFile.getInputStream(), fileToCreatePath, StandardCopyOption.REPLACE_EXISTING);            

        } catch (IOException e) {
            e.printStackTrace();
        }

        redirectAttribute.addFlashAttribute("success", "Data has been successfully added!");
        return "redirect:/data";
    }

    // Edit data
    @GetMapping("/data/edit/{id}")
    public String editData(@PathVariable("id") Integer id, Model model, RedirectAttributes redirectAttribute) {
        Optional<data> dataOpt = dataRepository.findById(id);
        if (!dataOpt.isPresent()) {
            redirectAttribute.addFlashAttribute("error", "Data not found!");
            return "redirect:/data";
        }

        model.addAttribute("data", dataOpt.get());
        return "edit_data";
    }

    @PostMapping("/data/edit/{id}")
    public String saveUpdatedData(@PathVariable("id") Integer id, @Valid data data, BindingResult bindingResult, RedirectAttributes redirectAttribute) {
        if (bindingResult.hasErrors()) {
            return "edit_data";
        }

        Optional<data> existingDataOpt = dataRepository.findById(id);
        if (!existingDataOpt.isPresent()) {
            redirectAttribute.addFlashAttribute("error", "Data not found!");
            return "redirect:/data";
        }

        data.setId(id); // Ensure the ID is set to the existing entity ID
        dataRepository.save(data);
        redirectAttribute.addFlashAttribute("success", "Data updated!");
        return "redirect:/data";
    }

    // Delete data
    @GetMapping("/data/delete/{id}")
    public String deleteData(@PathVariable("id") Integer id, RedirectAttributes redirectAttribute) {
        if (!dataRepository.existsById(id)) {
            redirectAttribute.addFlashAttribute("error", "Data not found!");
            return "redirect:/data";
        }

        dataRepository.deleteById(id);
        redirectAttribute.addFlashAttribute("success", "Data deleted!");
        return "redirect:/data";
    }
}

