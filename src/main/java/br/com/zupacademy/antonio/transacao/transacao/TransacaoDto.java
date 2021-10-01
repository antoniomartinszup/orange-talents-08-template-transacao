package br.com.zupacademy.antonio.transacao.transacao;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TransacaoDto {

    private LocalDateTime efetivada;
    private String endereco;
    private String nome;
    private BigDecimal valor;

    public TransacaoDto(Transacao transacao) {
        this.efetivada = transacao.getEfetivadaEm();
        this.endereco = transacao.getEstabelecimento().getEndereco();
        this.nome = transacao.getEstabelecimento().getNome();
        this.valor = transacao.getValor();
    }

    public static List<TransacaoDto> converteEmListaTransacaoDto(List<Transacao> transacaoList) {
        List<TransacaoDto> transacaoDtos = new ArrayList<>();
        for (Transacao transacaoAux : transacaoList) {
            TransacaoDto transacaoDto = new TransacaoDto(transacaoAux);
            transacaoDtos.add(transacaoDto);
        }
        return transacaoDtos;
    }

    public LocalDateTime getEfetivada() {
        return efetivada;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getNome() {
        return nome;
    }

    public BigDecimal getValor() {
        return valor;
    }
}
