package dev.boot.dto;

import dev.boot.domain.Base;

import java.time.LocalDate;

public class BaseDTO {
    private final Base base;

    public BaseDTO(){
        this(new Base());
    }

    public BaseDTO(Base base){
        this.base = base;
    }


    public Base toBase(){
        return base;
    }

    public Long getId(){
        return base.getId();
    }

    public void setId(Long id){
        base.setId(id);
    }

    public String getContent(){
        return base.getContent();
    }

    public void setContent(String content){
        base.setContent(content);
    }

    public LocalDate getStartDate(){
        return base.getStartDate();
    }

    public void setStartDate(LocalDate startDate){
        base.setStartDate(startDate);
    }

    public LocalDate getEndDate(){
        return base.getEndDate();
    }

    public void setEndDate(LocalDate endDate){
        base.setEndDate(endDate);
    }
}
