package com.ayush.School.Controller;

import com.ayush.School.Model.Holiday;
import com.ayush.School.repository.HolidaysRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Controller
public class HolidayController {

    @Autowired
    private HolidaysRepository holidaysRepository;

    @GetMapping(value= "/holidays/{display}")
    public String displayHolidays(@PathVariable String display , Model model){

        if ("all".equals(display)) {
            model.addAttribute("festival", true);
            model.addAttribute("federal", true);
        } else if ("federal".equals(display)) {
            model.addAttribute("federal", true);
        } else if ("festival".equals(display)) {
            model.addAttribute("festival", true);
        }

        List<Holiday> holidays = holidaysRepository.findAll();

        Holiday.Type[] types = Holiday.Type.values();
        for (Holiday.Type type : types) {
            model.addAttribute(
                    type.toString(),
                    holidays.stream()
                            .filter(holiday -> type.equals(holiday.getType()))  // SAFE
                            .collect(Collectors.toList())
            );
        }

        return "holidays.html";
    }
}



//    @GetMapping(value = "/holidays")
//    public String displayHolidays(@RequestParam(required = false) boolean festival,
//                                  @RequestParam(required = false) boolean federal, Model model){
//        model.addAttribute("festival", festival);
//        model.addAttribute("federal", federal);
//        List<Holiday> holidays = Arrays.asList(
//                new Holiday(" Jan 1 ","New Year's Day", Holiday.Type.FESTIVAL),
//                new Holiday(" Oct 31 ","Halloween", Holiday.Type.FESTIVAL),
//                new Holiday(" Nov 24 ","Thanksgiving Day", Holiday.Type.FESTIVAL),
//                new Holiday(" Dec 25 ","Christmas", Holiday.Type.FESTIVAL),
//                new Holiday(" Jan 17 ","Martin Luther King Jr. Day", Holiday.Type.FEDERAL),
//                new Holiday(" July 4 ","Independence Day", Holiday.Type.FEDERAL),
//                new Holiday(" Sep 5 ","Labor Day", Holiday.Type.FEDERAL),
//                new Holiday(" Nov 11 ","Veterans Day", Holiday.Type.FEDERAL)
//        );
//        Holiday.Type[] types = Holiday.Type.values();
//        for (Holiday.Type type : types) {
////            if(festival == false){
////
////            }
//            model.addAttribute(type.toString(),
//                    (holidays.stream().filter(holiday -> holiday.getType().equals(type)).collect(Collectors.toList())));
//        }
//
//        return "holidays.html";
//    }


