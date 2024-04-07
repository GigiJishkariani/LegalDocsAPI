package dev.boot.dto;

import dev.boot.domain.Article;
import dev.boot.domain.NormativeActs;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDate;
import java.util.Set;

public class NormativeActsDTO {
    private final NormativeActs normativeActs;

    public NormativeActsDTO(NormativeActs normativeActs) {
        this.normativeActs = normativeActs;
    }

    public NormativeActsDTO(){
        this(new NormativeActs());
    }

    public NormativeActs toNormativeActs(){
        return normativeActs;
    }

    public long getId(){
        return normativeActs.getId();
    }

    @Schema(hidden = true)
    public void setId(long id) {
        normativeActs.setId(id);
    }

    public long getPrevId(){
        return normativeActs.getPrevId();
    }

    public void setPrevId(long id) {
        normativeActs.setPrevId(id);
    }


    public String getTitle(){
        return normativeActs.getTitle();
    }

    public void setTitle(String title){
        normativeActs.setTitle(title);
    }

    public String getSentence(){
        return normativeActs.getSentence();
    }

    public void setSentence(String sentence){
        normativeActs.setSentence(sentence);
    }

    public Set<Article> getArticles(){
        return normativeActs.getArticles();
    }

    public void setArticles(Set<Article> articles){
        normativeActs.setArticles(articles);
    }


    public LocalDate getStartDate(){
        return normativeActs.getStartDate();
    }


    public LocalDate getEndDate(){
        return normativeActs.getEndDate();
    }

    public void setEndDate(LocalDate endDate){
        normativeActs.setEndDate(endDate);
    }
    public void setStartDate(LocalDate endDate){
        normativeActs.setStartDate(endDate);
    }

}
