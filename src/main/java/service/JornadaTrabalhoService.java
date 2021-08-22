package service;

import model.JornadaTrabalho;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.JornadaTrabalhoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class JornadaTrabalhoService {

    @Autowired
    private JornadaTrabalhoRepository jornadaTrabalhoRepository;

    public JornadaTrabalho salvarOuAtualizar(JornadaTrabalho jornadaTrabalho ) {
        JornadaTrabalho entidade = null;

        if( jornadaTrabalho != null ) {
            entidade = jornadaTrabalhoRepository.save( jornadaTrabalho );
        }

        return entidade;
    }

    public JornadaTrabalho obterPorId( Long id ) {
        JornadaTrabalho entidade = null;
        Optional<JornadaTrabalho> existeJornada = jornadaTrabalhoRepository.findById( id );

        if( existeJornada.isPresent() ) {
            entidade = new JornadaTrabalho ( existeJornada.get().getId(), existeJornada.get().getDescricao()) ;
        }

        return entidade;
    }

    public List<JornadaTrabalho> retornarTodos() {
        List<JornadaTrabalho> listaJornada = jornadaTrabalhoRepository.findAll();
        return listaJornada;
    }

    public void removerPorId( Long id ) {
        jornadaTrabalhoRepository.deleteById( id );
    }


}
