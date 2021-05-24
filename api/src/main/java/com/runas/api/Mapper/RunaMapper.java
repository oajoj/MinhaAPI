package com.runas.api.Mapper;

import com.runas.api.Entity.RunaModel;
import com.runas.api.InputModel.RunaInputModel;
import com.runas.api.OutputModel.RunaOutputModel;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class RunaMapper {

    private ModelMapper mapper;

    public RunaMapper(ModelMapper mapper){
        this.mapper = mapper;
    }

    public RunaOutputModel toOutput(RunaModel runa){
        return mapper.map(runa, RunaOutputModel.class);
    }

    public RunaOutputModel toOutput(RunaInputModel runa){
        return mapper.map(runa, RunaOutputModel.class);
    }

    public RunaModel toModel(RunaInputModel runa){
        return mapper.map(runa, RunaModel.class);
    }
}
