package br.com.systemsgs.service;

import java.util.List;
import java.util.Optional;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.com.systemsgs.model.ModelFile;
import br.com.systemsgs.repository.FileRepository;

@Service
public class FileService {

	@Autowired
	private FileRepository fileRepository;
	
	public ModelFile salvarFile(MultipartFile file) {
		String fileName = file.getOriginalFilename();
		String fileDownloadUri = "Teste URI de Download";
		
		try {
			ModelFile arquivo = new ModelFile(fileDownloadUri, fileName, 1, 1, "Descricao Arquivo", file.getSize(), "Flag Migr", geradorMd5DigestUtil(file), "SIM");
			return fileRepository.save(arquivo);
		}catch (Exception e){
            throw new RuntimeException("Erro ao tentar salvar Arquivo, Tente Novamente.");
        }
	}
	
	public Optional<ModelFile> retornaArquivo(String hash) {
		return fileRepository.findByHash(hash);
	}
	
	public List<ModelFile> listaTodosFiles(){
		return fileRepository.findAll();
	}
	
	public String geradorMd5DigestUtil(MultipartFile file){
        String hashMd5 = DigestUtils.md5Hex(file.toString()).toUpperCase();
        return hashMd5;
    }
	
}
