package com.asus.Insurance.Controller;

import java.io.FileNotFoundException;
import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/policies")

/**
 * Handles policy document file operations. 
 * Note: Stores PDFs in the project's static directory.
 */
public class PolicyController { 
	
	  /**
     * Downloads a policy PDF document by its ID.
     * 
     * @param policyId ID matching an existing policy PDF file (format: policy_{id}.pdf)
     * @return PDF file as downloadable attachment with:
     *         - Content-Type: application/pdf
     *         - Content-Disposition header forcing download
     * @throws FileNotFoundException If no PDF exists for the given ID (HTTP 500)
     * @throws IOException For general file system errors
     * 
     */
	@GetMapping("/download/{policyId}")
	public ResponseEntity<Resource> downloadPolicy(@PathVariable Long policyId) throws IOException
	{      
		    String fileName= "policy_" + policyId + ".pdf";
	        Path filePath= Paths.get("src/main/resources/static/" +fileName);
	        
	        if(!Files.exists(filePath)) {
	        	throw new FileNotFoundException("Policy document not found");
	           }
	        
	        Resource resource = new UrlResource(filePath.toUri());
	        return ResponseEntity.ok()
	        		.contentType(MediaType.APPLICATION_PDF)
	        		.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileName+ "\"")
	        		.body(resource);
		
	}

}
