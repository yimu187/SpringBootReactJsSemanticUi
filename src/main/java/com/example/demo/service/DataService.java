package com.example.demo.service;

import com.example.demo.dao.DataDao;
import com.example.demo.dto.SonucDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class DataService {

    @Autowired
    DataDao dao;

    public List<SonucDto> findAllList(){
        return dao.findAllList();
    }

    public SonucDto findSonucDtoByRecordId(String recordId){
        return dao.findSonucDtoByRecordId(recordId);
    }

    public void deleteSonucDto(SonucDto sonucDto){
        dao.deleteSonucDto(sonucDto);
    }

    public SonucDto saveSonucDto(SonucDto sonucDto){
        return dao.saveSonucDto(sonucDto);
    }
}
