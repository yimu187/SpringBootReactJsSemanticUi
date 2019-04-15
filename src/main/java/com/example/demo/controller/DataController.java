package com.example.demo.controller;

import com.example.demo.dto.SonucDto;
import com.example.demo.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping()
public class DataController {

    @Autowired
    DataService dataService;

    @RequestMapping(value = "/data", method = RequestMethod.GET)
    public ModelMap doGetAllData(){

        ModelMap result = new ModelMap();

        List<SonucDto> list = dataService.findAllList();

        result.addAttribute("list", list);
        result.addAttribute("message", "İşlem Başarılı");
        result.addAttribute("success", true);

        return result;
    }

    @RequestMapping(value = "/download/{recordId}", method = RequestMethod.GET)
    public void serveFile(@PathVariable(name="recordId") String recordId
            ,HttpServletResponse response) throws IOException {

//        ClassLoader classLoader = this.getClass().getClassLoader();
//        InputStream in = classLoader.getResourceAsStream("Geçiş_Onayı.pdf");
//        byte[] csvContent = IOUtils.toByteArray(in);

        SonucDto dto = dataService.findSonucDtoByRecordId(recordId);
        StringBuilder builder = new StringBuilder();
        builder.append(dto.getRecordId() + ";");
        builder.append(dto.getTarih() + ";");
        builder.append(dto.getMetin() + ";");
        builder.append(dto.getSayi());

        String csv = builder.toString();
        byte[] csvContent = csv.getBytes();

        response.setContentType("application/text");
        response.addHeader("Content-Disposition", "attachment; filename=" + dto.getTarih() + ".csv");
        response.getOutputStream().write(csvContent);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelMap doSaveData(@RequestBody SonucDto param){

        ModelMap result = new ModelMap();
        SonucDto sonucDto = null;
        try{
            sonucDto = dataService.saveSonucDto(param);
            result.addAttribute("sonuc", sonucDto);
            result.addAttribute("message", "İşlem Başarılı");
            result.addAttribute("success", true);
        }catch (RuntimeException runEx){
            result.addAttribute("message", runEx.getMessage());
            result.addAttribute("success", false);
        }

        return result;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public ModelMap doDeleteData(@RequestBody SonucDto param){

        ModelMap result = new ModelMap();
        try{
            dataService.deleteSonucDto(param);
            result.addAttribute("message", "İşlem Başarılı");
            result.addAttribute("success", true);
        }catch (RuntimeException runEx){
            result.addAttribute("message", runEx.getMessage());
            result.addAttribute("success", false);
        }

        return result;
    }
}
