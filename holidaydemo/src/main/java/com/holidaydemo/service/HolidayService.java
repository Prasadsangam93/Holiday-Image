package com.holidaydemo.service;

import com.holidaydemo.entity.Holiday;
import com.holidaydemo.repository.HolidayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@Service
public class HolidayService {
    @Autowired
    private HolidayRepository holidayRepository;

    public String saveImage(MultipartFile file, String name, String description, String fullDate) throws Exception {
        Holiday holiday = new Holiday();
        holiday.setName(name);
        holiday.setDescription(description);
        holiday.setFulldate(fullDate);
        holiday.setImage((file.getBytes()));
        holidayRepository.save(holiday);
        return " image save in db";

    }

    public Holiday getByID(Long id) {
        Optional<Holiday> h = holidayRepository.findById(id);
        return h.get();
    }

    //this is for get all images
    public List<Holiday> getAll() {
        return holidayRepository.findAll();

    }

   public Holiday updateHoliday(Long id, Holiday holiday) {
        Optional<Holiday> h = holidayRepository.findById(id);
       if (h.isPresent()) {
            Holiday h1 = h.get();
            h1.setName(holiday.getName());
            h1.setDescription(holiday.getDescription());
           h1.setFulldate(holiday.getFulldate());
           holiday.setImage(holiday.getImage());
          return holidayRepository.save(h1);

        } else
            return null;

    }

 public void deleteHoliday(Long id) {
       this.holidayRepository.deleteById(id);
    }
}