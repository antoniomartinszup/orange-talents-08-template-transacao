package br.com.zupacademy.antonio.transacao.kafka;

import br.com.zupacademy.antonio.transacao.transacao.Transacao;
import br.com.zupacademy.antonio.transacao.transacao.TransacaoForm;
import br.com.zupacademy.antonio.transacao.transacao.TransacaoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ListenerTransacao {

    private final Logger logger = LoggerFactory.getLogger(ListenerTransacao.class);

    @Autowired
    TransacaoRepository transacaoRepository;

    @KafkaListener(topics = "${spring.kafka.topic.transactions}")
    public void escuta(TransacaoForm transacaoForm) {

        try {
            Transacao transacao = transacaoForm.toModel();
            transacaoRepository.save(transacao);
            logger.info("Transação com sucesso para o id {} ", transacaoForm.getId());

        } catch (Exception exception){
            logger.error("Falha com o status {} para a transaçao com id {} ", exception.getMessage(), transacaoForm.getId());
        }
    }
}
