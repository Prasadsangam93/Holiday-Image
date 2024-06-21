package com.holidaydemo.controller;

import com.holidaydemo.entity.Holiday;
import com.holidaydemo.service.HolidayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/image")

public class HolidayController {

    @Autowired
    private HolidayService holidayService;

    @PostMapping("/save")
    public String saveImageOrFile(@RequestParam("file") MultipartFile file,
                                  @RequestParam("name") String name,
                                  @RequestParam("description") String description,
                                  @RequestParam("fulldate") String fulldate) throws Exception {


        return holidayService.saveImage(file, name, description, fulldate);

    }

    @GetMapping("get/{id}")
    public Holiday getById(@PathVariable Long id) {
        return holidayService.getByID(id);
    }

    @GetMapping("fetchAll")
    public List<Holiday> getAll() {
        return holidayService.getAll();

    }

    @PutMapping("/update/{id}")
   public Holiday updateHoliday( @PathVariable Long id ,@ModelAttribute Holiday holiday ) throws Exception {
      return  holidayService.updateHoliday(id, holiday);
  }

    @DeleteMapping("/delete/{id}")
   public  void deleteHoliday(@PathVariable Long id){
       holidayService.deleteHoliday(id);
    }
}