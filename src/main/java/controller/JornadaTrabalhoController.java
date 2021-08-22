package controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import model.JornadaTrabalho;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.JornadaTrabalhoService;

import java.util.List;

@RestController
@RequestMapping("/jornada")
public class JornadaTrabalhoController {

    @Autowired
    private JornadaTrabalhoService jornadaTrabalhoService;
    //------------------------------------------------------------------------------------------------------------------
    @ApiOperation( value="Insere uma nova Jornada de Trabalho.", notes="Insere uma nova Jornada de Trabalho." )
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "Retorna a jornada de trabalho."),
            @ApiResponse(code = 500, message = "Houve o lançamento de uma exceção.")
    })
    @PostMapping
    public JornadaTrabalho criarJornada( @RequestBody JornadaTrabalho jornadaTrabalho ) {
        return jornadaTrabalhoService.salvarOuAtualizar( jornadaTrabalho );
    }
    //------------------------------------------------------------------------------------------------------------------
    @ApiOperation( value="Retorna os dados de uma jornada de trabalho, se ela existir.", notes="Retorna os dados de uma jornada de trabalho, se ela existir." )
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "Jornada de trabalho encontrada com sucesso."),
            @ApiResponse(code = 404, message = "Jornada de trabalho não existe.")
    })
    @GetMapping(value="/{id}")
    public ResponseEntity<Object> obterJornada( @ApiParam(value="ID da Jornada de Trabalho.") @PathVariable("id") Long id ) {

        JornadaTrabalho jornadaTrabalho = jornadaTrabalhoService.obterPorId( id );
        ResponseEntity<Object> respJornadaTrabalho = null;

        if( jornadaTrabalho != null ) {
            respJornadaTrabalho = new ResponseEntity<>( jornadaTrabalho, HttpStatus.OK );
        } else {
            respJornadaTrabalho = new ResponseEntity<>( "Elemento NÃO encontrado!", HttpStatus.NOT_FOUND );
        }

        return respJornadaTrabalho;
    }
    //------------------------------------------------------------------------------------------------------------------
    @ApiOperation( value="Insere todas as Jornadas de Trabalho.", notes="Insere todas as Jornadas de Trabalho." )
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "Retorna todas as jornadas de trabalho ou nenhuma, quando não existir.")
    })
    @GetMapping
    public List<JornadaTrabalho> obterTodos() {
        return jornadaTrabalhoService.retornarTodos();
    }
    //------------------------------------------------------------------------------------------------------------------
    @ApiOperation( value="Remove uma nova Jornada de Trabalho.", notes="Remove uma nova Jornada de Trabalho." )
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "Jornada de trabalho removida com sucesso."),
            @ApiResponse(code = 403, message = "Erro ao remover uma Jornada de Trabalho.")
    })
    @DeleteMapping(value="/{id}")
    public ResponseEntity<Object> removerPorId( @ApiParam(value="ID da Jornada de Trabalho.") @PathVariable("id") Long id ) {

        ResponseEntity<Object> objRemovido = null;

        try {
            jornadaTrabalhoService.removerPorId( id );
            objRemovido = new ResponseEntity<Object>( "Dado da jornada removido!", HttpStatus.OK );

        } catch ( Exception ex ) {
            objRemovido = new ResponseEntity<Object>( "Falha ao remover a jornada!", HttpStatus.FORBIDDEN );
        }

        return objRemovido;
    }
    //------------------------------------------------------------------------------------------------------------------
    @ApiOperation( value="Altera uma nova Jornada de Trabalho existente.", notes="Altera uma nova Jornada de Trabalho existente." )
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "Jornada de trabalho foi alterada/inserida com sucesso.")
    })
    @PutMapping
    public JornadaTrabalho alterarJornada( @RequestBody JornadaTrabalho jornadaTrabalho ) {
        return jornadaTrabalhoService.salvarOuAtualizar( jornadaTrabalho );
    }
    //------------------------------------------------------------------------------------------------------------------
}
