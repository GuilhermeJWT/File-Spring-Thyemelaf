package br.com.systemsgs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.systemsgs.model.ModelFile;
import br.com.systemsgs.service.FileService;

@Controller
@RequestMapping(value = "/file")
public class FileController {
	
	@Autowired
	private FileService fileService;
	
	public String get(Model model) {
		List<ModelFile> arquivos = fileService.listaTodosFiles();
		model.addAttribute("arquivos", arquivos);
		
		return "file";
	}

}
