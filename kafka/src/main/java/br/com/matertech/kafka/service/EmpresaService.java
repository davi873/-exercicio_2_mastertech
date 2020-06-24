package br.com.matertech.kafka.service;

import br.com.matertech.api.model.Empresa;
import br.com.matertech.kafka.client.EmpresaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpresaService {

    @Autowired
    private EmpresaClient empresaClient;
    private final int CAPITAL_MINIMO = 100000;


    public Empresa validarEmpresa(Empresa empresa) throws Exception{

        Empresa empresaTrusted = empresaClient.getEmpresaReceita(empresa.getCnpj());
        if(empresaTrusted.getCapital_social() > CAPITAL_MINIMO){
            return empresaTrusted;
        }else {
            throw new Exception("Empresa não validada");
        }
    }
}
