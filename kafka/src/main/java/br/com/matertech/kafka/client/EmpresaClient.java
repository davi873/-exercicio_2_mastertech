package br.com.matertech.kafka.client;


import br.com.matertech.api.model.Empresa;
import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "empresaClient", url = "https://www.receitaws.com.br/v1")
public interface EmpresaClient {

    @RequestMapping("/cnpj/{cnpj}")
    Empresa getEmpresaReceita(@PathVariable("cnpj") String cnpj);
}
