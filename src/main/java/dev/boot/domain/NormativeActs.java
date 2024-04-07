package dev.boot.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@SequenceGenerator(name = "gen_6", sequenceName = "seq_6", allocationSize = 1)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NormativeActs {
    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen_6")
    private long id;

    private long prevId;

//    private NormativeType type;

    private String title;

    private String sentence;

    @OneToMany(mappedBy = "normativeActs", cascade = CascadeType.ALL)
    private Set<Article> articles;

    private LocalDate startDate;
    private LocalDate endDate;
}
