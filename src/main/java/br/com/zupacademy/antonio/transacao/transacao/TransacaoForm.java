package br.com.zupacademy.antonio.transacao.transacao;

import br.com.zupacademy.antonio.transacao.cartao.CartaoForm;
import br.com.zupacademy.antonio.transacao.estabelecimento.EstabelecimentoForm;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransacaoForm {

    private String id;
    private BigDecimal valor;
    private LocalDateTime efetivadaEm;
    private EstabelecimentoForm estabelecimento;
    private CartaoForm cartao;

    public Transacao toModel() {
        return new Transacao(this.id, this.valor, this.efetivadaEm,
                this.estabelecimento.toModel(), this.cartao.toModel());
    }

    public String getId() {
        return id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }

    public EstabelecimentoForm getEstabelecimento() {
        return estabelecimento;
    }

    public CartaoForm getCartao() {
        return cartao;
    }
}
