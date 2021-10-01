package br.com.zupacademy.antonio.transacao.transacao;

import br.com.zupacademy.antonio.transacao.cartao.Cartao;
import br.com.zupacademy.antonio.transacao.cartao.CartaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/transacao/cartao/{id}")
public class TransacaoController {

    @Autowired
    private TransacaoRepository transacaoRepository;

    @Autowired
    private CartaoRepository cartaoRepository;

    @GetMapping
    public ResponseEntity<?> listar(@PathVariable String id) {

        Cartao cartao = cartaoRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND,"O cartão não foi localizado para o numero informado"));

        List<Transacao> transacaoList = transacaoRepository.findTop10ByCartao(cartao);
        List<TransacaoDto> transacaoDtos = TransacaoDto.converteEmListaTransacaoDto(transacaoList);
        return ResponseEntity.ok(transacaoDtos);
    }
}
