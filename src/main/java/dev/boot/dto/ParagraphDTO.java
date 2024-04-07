package dev.boot.dto;

import dev.boot.domain.Paragraph;

public class ParagraphDTO extends BaseDTO{
    private final Paragraph paragraph;

    public ParagraphDTO(Paragraph paragraph){
        this.paragraph = paragraph;
    }

    public ParagraphDTO(){
        this(new Paragraph());
    }

    public Paragraph toParagraph(){
        return paragraph;
    }

    @Override
    public Long getId(){
        return paragraph.getId();
    }

    @Override
    public void setId(Long id) {
        paragraph.setId(id);
    }

//    public Set<SubParagraph> getSubParagraphs(){
//        return paragraph.getSubParagraphs();
//    }
//
//    public void setSubParagraphs(Set<SubParagraph> subParagraphs){
//        paragraph.setSubParagraphs(subParagraphs);
//    }
//
//    @JsonIgnore
//    public Article getArticle(){
//        return paragraph.getArticle();
//    }
//
//    @JsonIgnore
//    public void setArticle(Article article){
//        paragraph.setArticle(article);
//    }
//
//    @JsonIgnore
//    public Base getBase(){
//        return paragraph.getBase();
//    }
//
//    @JsonIgnore
//    public void setBase(Base base){
//        paragraph.setBase(base);
//    }
}
