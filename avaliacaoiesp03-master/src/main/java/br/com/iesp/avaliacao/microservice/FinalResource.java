package br.com.iesp.avaliacao.microservice;


import com.sun.jdi.VoidType;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api")
public class FinalResource {

    @Autowired
    private FinalService finalService;

    @Autowired
    private ModelMapper modelMapper;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AlunoFinal salvar(@RequestBody AlunoFinal alunoFinal){
       return finalService.salvar(alunoFinal);
    }


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<AlunoFinal> alunoFinal(){
        return finalService.listarAlunos();
    }

    @GetMapping("{/id}")
    @ResponseStatus(HttpStatus.OK)
    public void buscarAlunoPorID(@PathVariable("id") Long id){
        finalService.consultarPorId(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Aluno nao encontrado"));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerAluno(@PathVariable("id") Long id) {
        finalService.consultarPorId(id)
                .map(alunoFinal -> {
                    finalService.removerPorID(alunoFinal.getId());
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Aluno nao encontrado"));
    }

@PutMapping("/id")
@ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizarAluno(@PathVariable("id") Long id, @RequestBody AlunoFinal alunoFinal){
        finalService.consultarPorId(id)
                .map(alunoFinalBase -> {
                    modelMapper.map(alunoFinal, alunoFinalBase);
                    return Void.TYPE;

                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Aluno nao encontrado"));
    }
}
