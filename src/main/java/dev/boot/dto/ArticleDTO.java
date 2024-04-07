package dev.boot.dto;

import dev.boot.domain.Article;

public class ArticleDTO extends BaseDTO{
    private final Article article;

    public ArticleDTO(Article article) {
        this.article = article;
    }

    public ArticleDTO(){
        this(new Article());
    }

    public Article toArticle(){
        return article;
    }

    @Override
    public Long getId(){
        return article.getId();
    }


    @Override
    public void setId(Long id) {
        article.setId(id);
    }

    public String getTitle(){
        return article.getTitle();
    }

    public void setTitle(String title){
        article.setTitle(title);
    }


//    public Set<Paragraph> getParagraphs(){
//        return article.getParagraphs();
//    }
//
//    public void setParagraphs(Set<Paragraph> paragraphs){
//        article.setParagraphs(paragraphs);
//    }
//
//    @JsonIgnore
//    public NormativeActs getNormativeActs(){
//        return article.getNormativeActs();
//    }
//
//    @JsonIgnore
//    public void setNormativeActs(NormativeActs normativeActs){
//        article.setNormativeActs(normativeActs);
//    }
//
//    @JsonIgnore
//    public Base getBase(){
//        return article.getBase();
//    }
//
//    @JsonIgnore
//    public void setBase(Base base){
//        article.setBase(base);
//    }
}
