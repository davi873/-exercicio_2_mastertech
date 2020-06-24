package br.com.matertech.api.producer;

import br.com.matertech.api.model.Empresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class EmpresaProducer {

    @Autowired
    private KafkaTemplate<String, Empresa> producer;

    public void enviaAoKafka(Empresa empresa){
        producer.send("spec2-davi-pires-2",empresa);
    }
}
