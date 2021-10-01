package br.com.zupacademy.antonio.transacao.transacao;

import br.com.zupacademy.antonio.transacao.cartao.Cartao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, String> {
    List<Transacao> findTop10ByCartao(Cartao cartao);
}
