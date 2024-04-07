package dev.boot.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@SequenceGenerator(name = "gen_4", sequenceName = "seq_4", allocationSize = 1)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//პუნქტი
public class Paragraph extends Base{
    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen_4")
    private long Id;


    @OneToMany(mappedBy = "paragraph", cascade = CascadeType.ALL)
    private Set<SubParagraph> subParagraphs;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "article_id")
    private Article article;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "base_id")
    private Base base;
}
