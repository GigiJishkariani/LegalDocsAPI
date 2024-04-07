package dev.boot.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(name = "gen_1", sequenceName = "seq_1", allocationSize = 1)
//ქვეპუნქტის ქვეპუნქტი
public class BaseParagraph extends Base {
    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen_1")
    private long Id;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "Sub_Paragraph_Id")
    private SubParagraph subParagraph;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "base_id")
    private Base base;
}