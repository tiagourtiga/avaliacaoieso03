package br.com.iesp.avaliacao.microservice;

import br.com.iesp.avaliacao.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FinalService {

    @Autowired
    private AlunoRepository alunoRepository;


    public AlunoFinal salvar(AlunoFinal avaliacaoFinal){
        return alunoRepository.save(avaliacaoFinal);
    }

    public AlunoFinal atualizar(AlunoFinal avaliacaoFinal){
        return alunoRepository.save(avaliacaoFinal);
    }

    public Optional<AlunoFinal> consultarPorId(Long id){
        return alunoRepository.findById(id);
    }

    public void removerPorID(Long id){
        alunoRepository.deleteById(id);
    }

    public List<AlunoFinal> listarAlunos(){
        return alunoRepository.findAll();
    }

    public void consultar(Integer idAluno) {
    }
}
