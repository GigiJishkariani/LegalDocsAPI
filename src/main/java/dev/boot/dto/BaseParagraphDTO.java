package dev.boot.dto;

import dev.boot.domain.BaseParagraph;

public class BaseParagraphDTO extends BaseDTO{
    private final BaseParagraph baseParagraph;

    public BaseParagraphDTO(BaseParagraph baseParagraph) {
        this.baseParagraph = baseParagraph;
    }

    public BaseParagraphDTO(){
        this(new BaseParagraph());
    }


    public BaseParagraph toBaseParagraph(){
        return baseParagraph;
    }
    public Long getId(){
        return baseParagraph.getId();
    }

    public void setId(long id){
        baseParagraph.setId(id);
    }

//    @JsonIgnore
//    public SubParagraph getSubParagraph(){
//        return baseParagraph.getSubParagraph();
//    }
//
//    @JsonIgnore
//    public void setSubParagraph(SubParagraph subParagraph){
//        baseParagraph.setSubParagraph(subParagraph);
//    }
//
//    public BaseDTO getBase(){
//        return new BaseDTO(baseParagraph.getBase());
//    }
//
//
//    public void setBase(Base base){
//        baseParagraph.setBase(base);
//    }

}
