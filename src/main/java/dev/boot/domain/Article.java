package dev.boot.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@SequenceGenerator(name = "gen_5", sequenceName = "seq_5", allocationSize = 1)
@Getter
@Setter
@NoArgsConstructor
//მუხლი
public class Article extends Base{
    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen_5")
    private long Id;

    @Column
    private String title;


    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL)
    private Set<Paragraph> paragraphs;


    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "base_id")
    private Base base;


    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "normativeActs_id")
    private NormativeActs normativeActs;

}
