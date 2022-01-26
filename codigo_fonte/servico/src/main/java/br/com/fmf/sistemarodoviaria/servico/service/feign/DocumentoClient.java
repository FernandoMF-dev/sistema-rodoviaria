package br.com.fmf.sistemarodoviaria.servico.service.feign;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "documento", path = "/api/documento", url = "http://localhost:8081")
public interface DocumentoClient {
}
