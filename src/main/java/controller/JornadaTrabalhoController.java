package controller;

import model.JornadaTrabalho;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.JornadaTrabalhoService;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/jornada")
public class JornadaTrabalhoController {

    @Autowired
    private JornadaTrabalhoService jornadaTrabalhoService;

    @PostMapping
    public JornadaTrabalho criarJornada( @RequestBody JornadaTrabalho jornadaTrabalho ) {
        return jornadaTrabalhoService.salvarOuAtualizar( jornadaTrabalho );
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<Object> obterJornada( @PathVariable("id") Long id ) {

        JornadaTrabalho jornadaTrabalho = jornadaTrabalhoService.obterPorId( id );
        ResponseEntity<Object> respJornadaTrabalho = null;

        if( jornadaTrabalho != null ) {
            respJornadaTrabalho = new ResponseEntity<>( jornadaTrabalho, HttpStatus.OK );
        } else {
            respJornadaTrabalho = new ResponseEntity<>( new NoSuchElementException("Elemento NÃO encontrado!"), HttpStatus.NOT_FOUND );
        }

        return respJornadaTrabalho;
    }

    @GetMapping
    public List<JornadaTrabalho> obterTodos() {
        return jornadaTrabalhoService.retornarTodos();
    }

    @DeleteMapping(value="/{id}")
    public void removerPorId( @PathVariable("id") Long id ) {
        jornadaTrabalhoService.removerPorId( id );
    }

}
