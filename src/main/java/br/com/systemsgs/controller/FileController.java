package br.com.systemsgs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import br.com.systemsgs.model.ModelFile;
import br.com.systemsgs.service.FileService;

@Controller
public class FileController {
	
	@Autowired
	private FileService fileService;
	
	@GetMapping(value = "/")
	public String get(Model model) {
		List<ModelFile> arquivos = fileService.listaTodosFiles();
		model.addAttribute("arquivos", arquivos);
		
		return "file";
	}
	
	@PostMapping(value = "/uploadFiles")
	public String uploadMultpleFiles(@RequestParam("files") MultipartFile[] files) {
		for (MultipartFile file: files) {
			fileService.salvarFile(file);
		}
		return "redirect:/";
	}
	
	public ResponseEntity<ByteArrayResource> downloadFile(@PathVariable Long id){
		ModelFile arquivo = fileService.retornaArquivoId(id).get();
		return ResponseEntity.ok().contentType(MediaType.parseMediaType(arquivo.getType()))
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + arquivo.getNomeOrigem() + "\"")
				.body(new ByteArrayResource(arquivo.getData()));
	}

}
