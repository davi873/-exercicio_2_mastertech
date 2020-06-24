package br.com.matertech.kafka.consumer;


import br.com.matertech.api.model.Empresa;

import br.com.matertech.kafka.producer.EmpresaProducer;
import br.com.matertech.kafka.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;


@Component
public class EmpresaConsumer {

    @Autowired
    private EmpresaService empresaService;

    @Autowired
    private EmpresaProducer empresaProducer;

    @KafkaListener(topics = "spec2-davi-pires-2", groupId = "oneGroup")
    public void capturaNovasEmpresas(@Payload Empresa empresa){
        String log = "";
        try {
            Empresa empresaTrusted = empresaService.validarEmpresa(empresa);
            log = "Empresa " + empresaTrusted.getNome() + " cadastrada com sucesso!";
        } catch (Exception e){
           log = e.getMessage();
        }
        empresaProducer.enviaAoCsv(log);
    }
}
