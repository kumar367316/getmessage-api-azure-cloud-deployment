package com.htc.pclconverter;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.htc.pclconverter.service.AzureBlobService;

@SpringBootApplication
@RestController
public class SpringAzureDemoApplication {
	
	@Autowired
	AzureBlobService azureAdapter;

	@GetMapping("/message")
	public String message(){
		return "Congrats ! your application deployed successfully in Azure Platform. !";
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringAzureDemoApplication.class, args);
	}
	
	@GetMapping(path = "/download")
	public String uploadFile(@RequestParam(value = "file") String file) throws IOException {
		return azureAdapter.getFile(file);
		/*
		 * ByteArrayResource resource = new ByteArrayResource(data);
		 * 
		 * return ResponseEntity.ok().contentLength(data.length).header("Content-type",
		 * "application/octet-stream") .header("Content-disposition",
		 * "attachment; filename=\"" + file + "\"").body(resource);
		 */
	}

}
