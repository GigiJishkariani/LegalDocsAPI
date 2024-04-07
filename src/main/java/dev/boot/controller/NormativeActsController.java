package dev.boot.controller;


import dev.boot.dto.NormativeActsDTO;
import dev.boot.service.NormativeActsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/normative-acts")
public class NormativeActsController {
    private final NormativeActsService normativeActsService;

    @Autowired
    public NormativeActsController(NormativeActsService normativeActsService) {
        this.normativeActsService = normativeActsService;
    }

    @GetMapping("/{id}")
    public Optional<NormativeActsDTO> findById(@PathVariable(name = "id") long id) {
        return normativeActsService.findById(id);
    }

    @PreAuthorize("hasAnyRole('CREATE_ACT_ROLE','AMEND_ACT_ROLE','EDIT_ACT_ROLE', 'PUBLIC_ROLE')")
    @GetMapping
    public Iterable<NormativeActsDTO> findAll() {
        return normativeActsService.findAll();
    }


    @Secured("CREATE_ACT_ROLE")
    @PostMapping
    public ResponseEntity<NormativeActsDTO> save(@RequestBody NormativeActsDTO normativeActsDTO) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(normativeActsService.save(normativeActsDTO));
    }

    @Secured("AMEND_ACT_ROLE")
    @PutMapping
    public ResponseEntity<NormativeActsDTO> update(@RequestBody NormativeActsDTO normativeActsDTO) {
        NormativeActsDTO updated = normativeActsService.update(normativeActsDTO);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    @Secured("EDIT_ACT_ROLE")
    @PutMapping("/{id}")
    public ResponseEntity<NormativeActsDTO> update(@PathVariable(name = "id") long id, @RequestBody NormativeActsDTO normativeActsDTO) {
        NormativeActsDTO updated = normativeActsService.updateForTypo(id, normativeActsDTO);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }


//    @DeleteMapping("/{id}")
//    public void delete(@PathVariable(name = "id") long baseId){
//        normativeActsService.delete(baseId);
//    }
}
