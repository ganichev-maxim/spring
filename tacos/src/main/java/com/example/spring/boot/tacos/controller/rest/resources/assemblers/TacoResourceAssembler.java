package com.example.spring.boot.tacos.controller.rest.resources.assemblers;

import com.example.spring.boot.tacos.controller.DesignTacoController;
import com.example.spring.boot.tacos.controller.rest.DesignTacoRestController;
import com.example.spring.boot.tacos.controller.rest.resources.TacoResource;
import com.example.spring.boot.tacos.model.Taco;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;

public class TacoResourceAssembler
        extends RepresentationModelAssemblerSupport<Taco, TacoResource> {

    public TacoResourceAssembler() {
        super(DesignTacoRestController.class, TacoResource.class);
    }

    @Override
    protected TacoResource instantiateModel(Taco taco) {
        return new TacoResource(taco);
    }

    @Override
    public TacoResource toModel(Taco taco) {
        return createModelWithId(taco.getId(), taco);
    }
}
