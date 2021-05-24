package com.runas.api.Common;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {
    
    @Bean //Torna injetável
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
