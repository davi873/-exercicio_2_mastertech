package br.com.matertech.csv.consumer;



import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.FileWriter;
import java.io.PrintWriter;

@Component
public class EmpresaConsumer {

    @KafkaListener(topics = "spec2-davi-pires-3", groupId = "csvGroup")
    public void salvaEmpresas(@Payload String log){
        try {
            FileWriter fileWriter = new FileWriter("./log_kafka.csv",true);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.append(log);
            fileWriter.close();
        }catch (Exception e){
            System.out.println(e);
        }
    }

}
