package dev.boot.repository;

import dev.boot.domain.NormativeActs;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface NormativeActsRepository extends CrudRepository<NormativeActs, Long> {
}
