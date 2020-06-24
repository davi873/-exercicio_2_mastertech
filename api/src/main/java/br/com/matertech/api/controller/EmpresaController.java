package br.com.matertech.api.controller;

import br.com.matertech.api.model.Empresa;
import br.com.matertech.api.producer.EmpresaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmpresaController {

    @Autowired
    EmpresaProducer empresaProducer;

    @PostMapping("/empresa/{cnpj}")
    public void cadastra(@PathVariable(value = "cnpj", required = true) String cnpj){
        Empresa emp = new Empresa();
        emp.setCnpj(cnpj);
        empresaProducer.enviaAoKafka(emp);
    }


}
