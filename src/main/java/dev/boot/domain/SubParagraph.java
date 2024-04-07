package dev.boot.domain;
//ქვეპუნქტი

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@SequenceGenerator(name = "gen_2", sequenceName = "seq_2", allocationSize = 1)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//ქვეპუნქტი
public class SubParagraph extends Base {
    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen_2")
    private long Id;

    @OneToMany(mappedBy = "subParagraph", cascade = CascadeType.ALL)
    private Set<BaseParagraph> baseParagraphs;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "base_id")
    private Base base;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "paragraph_id")
    private Paragraph paragraph;
}