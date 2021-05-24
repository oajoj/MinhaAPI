package com.runas.api.Controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.runas.api.Entity.RunaModel;
import com.runas.api.InputModel.RunaInputModel;
import com.runas.api.Mapper.RunaMapper;
import com.runas.api.OutputModel.RunaOutputModel;
import com.runas.api.Repository.RunaRepository;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

//Boas práticas pendentes

@RestController
@RequestMapping("/runas")
public class RunaController {

    private RunaRepository repository;
    private RunaMapper mapper;

    public RunaController(RunaRepository repository, RunaMapper mapper){
        this.repository = repository;
        this.mapper = mapper;
    }

    @GetMapping
    public List<RunaModel> listar(){
        return repository.findAll();
    }

    @GetMapping("/{nomeRuna}")
    public ResponseEntity<RunaModel> selecionarPorNome(@PathVariable String nomeRuna){
        Optional<RunaModel> optRuna = repository.findByNomeContaining(nomeRuna);
        if(optRuna.isPresent()){
            return ResponseEntity.ok(optRuna.get());
        }
        return ResponseEntity.notFound().build();
    }

/*
    @GetMapping("/{id}")
    public ResponseEntity<RunaModel> selecionar(@PathVariable Long id){
        Optional<RunaModel> findById = repository.findById(id);
        if(findById.isPresent()){
            return ResponseEntity.ok(findById.get());
        }
        return ResponseEntity.notFound().build();
    }
*/

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<RunaOutputModel> atualizarRuna(@PathVariable Long id, @RequestBody RunaInputModel model){
        Optional<RunaModel> runa = repository.findById(id);
        if(runa.isPresent()){
            runa.get().atualizar(model.getNome(), model.getGlifo(), model.getCamada(), model.getCalice());
            return ResponseEntity.ok(mapper.toOutput(runa.get()));
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public RunaModel cadastrarRuna(@RequestBody @Valid RunaModel runa){
        return repository.save(runa);
    }

    @DeleteMapping("/{id}")
    public void deletarRuna(@PathVariable Long id){
        repository.deleteById(id);
    }

}
