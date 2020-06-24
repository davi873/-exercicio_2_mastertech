package br.com.matertech.kafka.producer;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class EmpresaProducer {

    @Autowired
    private KafkaTemplate<String, String> producer;

    public void enviaAoCsv(String log){
        producer.send("spec2-davi-pires-3",log);
    }
}
