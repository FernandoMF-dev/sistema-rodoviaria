package br.com.fmf.sistemarodoviaria.servico.service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

import static org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE;

@FeignClient(name = "documento", path = "/api/documento", url = "${application.module.documento}")
public interface DocumentoClient {

	@PostMapping(consumes = {MULTIPART_FORM_DATA_VALUE})
	UUID create(MultipartFile file);

	@DeleteMapping(value = "{uuid}")
	void delete(@PathVariable UUID uuid);

	@GetMapping(value = "{uuid}")
	byte[] find(@PathVariable UUID uuid);

}
