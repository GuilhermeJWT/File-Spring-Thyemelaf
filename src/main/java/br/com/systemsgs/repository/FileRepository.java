package br.com.systemsgs.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.systemsgs.model.ModelFile;

@Repository
public interface FileRepository extends JpaRepository<ModelFile, Long>{

	Optional<ModelFile> findByHash(String hash);
	
}
