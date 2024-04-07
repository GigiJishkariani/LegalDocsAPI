package dev.boot.service;

import dev.boot.dto.NormativeActsDTO;
import dev.boot.exception.NormativeActNotFoundException;
import dev.omedia.boot.domain.*;
import dev.omedia.boot.repository.*;
import dev.omedia.boot.exception.*;
import dev.boot.repository.NormativeActsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class NormativeActsService {
    private final NormativeActsRepository repository;

    public NormativeActsDTO save(NormativeActsDTO normativeActsDTO) {
        normativeActsDTO.toNormativeActs().getArticles().forEach(article -> {
            article.setNormativeActs(normativeActsDTO.toNormativeActs());
            article.setBase(article);
        });
        normativeActsDTO.toNormativeActs().getArticles().forEach(article -> article.getParagraphs().forEach(paragraph -> {
            paragraph.setArticle(article);
            paragraph.setBase(paragraph);
        }));
        normativeActsDTO.toNormativeActs().getArticles().forEach(article -> article.getParagraphs().forEach(paragraph -> paragraph.getSubParagraphs().forEach(subParagraph -> {
            subParagraph.setParagraph(paragraph);
            subParagraph.setBase(subParagraph);
        })));
        normativeActsDTO.toNormativeActs().getArticles().forEach(article -> article.getParagraphs().forEach(paragraph -> paragraph.getSubParagraphs().forEach(subParagraph-> subParagraph.getBaseParagraphs().forEach(baseParagraph -> {
            baseParagraph.setSubParagraph(subParagraph);
            baseParagraph.setBase(baseParagraph);
        }))));

        return new NormativeActsDTO(repository.save(normativeActsDTO.toNormativeActs()));
    }


    public NormativeActsDTO updateForTypo(long id, NormativeActsDTO normativeActsDTO){
        Optional<NormativeActsDTO> normativeActsDTO1 = findById(id);
        normativeActsDTO1.orElseThrow(NormativeActNotFoundException::new);
        normativeActsDTO.setId(id);
        deleteById(id);
        return save(normativeActsDTO);
    }

    public NormativeActsDTO update(NormativeActsDTO normativeActsDTO){
        Optional<NormativeActsDTO> normativeActsDTO1 = findById(normativeActsDTO.getPrevId());
        normativeActsDTO1.ifPresent(actsDTO -> actsDTO.setEndDate(normativeActsDTO.getStartDate()));
        normativeActsDTO1.orElseThrow(NormativeActNotFoundException::new);
        return save(normativeActsDTO);
    }


    public Optional<NormativeActsDTO> findById(Long aLong) {
        return repository.findById(aLong).map(NormativeActsDTO::new);
    }

    public Iterable<NormativeActsDTO> findAll() {
        return StreamSupport.stream(repository.findAll().spliterator(), false)
                .map(NormativeActsDTO::new)
                .collect(Collectors.toSet());
    }

    public void deleteById(Long aLong) {
        repository.deleteById(aLong);
    }
}