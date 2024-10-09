package com.softwareii.appstoreit.controller;
import com.softwareii.appstoreit.model.Bodega;

public class ModelFactoryController {

    Bodega bodega;


    private static class SingletonHolder {
        private final static ModelFactoryController eINSTANCE = new ModelFactoryController();
    }
    public static ModelFactoryController getInstance() {
        return SingletonHolder.eINSTANCE;
    }

}
