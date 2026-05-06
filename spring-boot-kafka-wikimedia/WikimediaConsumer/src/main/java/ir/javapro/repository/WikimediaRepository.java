package ir.javapro.repository;

import ir.javapro.entity.WikimediaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WikimediaRepository extends JpaRepository<WikimediaEntity,Long> {
}
