package dev.boot.dto;

import dev.boot.domain.SubParagraph;

public class SubParagraphDTO extends BaseDTO{
    private final SubParagraph subParagraph;

    public SubParagraphDTO(SubParagraph subParagraph) {
        this.subParagraph = subParagraph;
    }

    public SubParagraphDTO(){
        this(new SubParagraph());
    }

    public SubParagraph toSubParagraph(){
        return subParagraph;
    }

    public Long getId(){
        return subParagraph.getId();
    }

    public void setId(Long id){
        subParagraph.setId(id);
    }

//    @JsonIgnore
//    public Base getBase(){
//
//        return subParagraph.getBase();
//    }
//
//    @JsonIgnore
//    public void setBase(Base base){
//        subParagraph.setBase(base);
//    }
//
//    @JsonIgnore
//    public Paragraph getParagraph(){
//        return subParagraph.getParagraph();
//    }
//
//    @JsonIgnore
//    public void setParagraph(Paragraph paragraph){
//        subParagraph.setParagraph(paragraph);
//    }
//
//    public Set<BaseParagraph> getBaseParagraphSet(){
//        return subParagraph.getBaseParagraphs();
//    }
//
//    public void setBaseParagraphs(Set<BaseParagraph> paragraphs){
//        subParagraph.setBaseParagraphs(paragraphs);
//    }


}
