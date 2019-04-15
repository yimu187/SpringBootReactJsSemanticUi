package com.example.demo.dao;

import com.example.demo.dto.SonucDto;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class DataDao {


    private List<SonucDto> list = new ArrayList<>();

    public DataDao() {
        super();

        SonucDto sonucDto1 = new SonucDto(UUID.randomUUID().toString(),1L, "A", "2019-04-01");
        SonucDto sonucDto2 = new SonucDto(UUID.randomUUID().toString(),2L, "B", "2019-04-02");

        list.add(sonucDto1);
        list.add(sonucDto2);
    }

    public List<SonucDto> findAllList(){
        return list;
    }

    public SonucDto findSonucDtoByRecordId(String recordId){
        Optional<SonucDto> opt = list.stream().filter(dto -> dto.getRecordId().equals(recordId)).findFirst();
        return opt.isPresent() ? opt.get() : null;
    }

    public void deleteSonucDto(SonucDto sonucDto){
        if(sonucDto.getRecordId() != null){
            SonucDto sonucDtoInList = findSonucDtoByRecordId(sonucDto.getRecordId());
            if(sonucDtoInList != null){
                list.remove(sonucDtoInList);
            }else{
                throw new RuntimeException("Geçerli bir kayda ait işlem yapılmalıdır");
            }
        }else{
            throw new RuntimeException("Kaydedilmemiş kayıt silinmemelidir");
        }
    }

    public SonucDto saveSonucDto(SonucDto sonucDto){
        SonucDto result = sonucDto;
        if(sonucDto.getRecordId() != null){
            SonucDto sonucDtoInList = findSonucDtoByRecordId(sonucDto.getRecordId());
            if(sonucDtoInList != null){
                list.remove(sonucDtoInList);
                list.add(sonucDto);
            }else{
                throw new RuntimeException("Geçerli bir kayda ait işlem yapılmalıdır");
            }
        }else{
            sonucDto.setRecordId(UUID.randomUUID().toString());
            list.add(sonucDto);
            result = sonucDto;
        }
        return result;
    }

}
