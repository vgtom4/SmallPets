package it.smallcode.smallpets.manager;
/*

Class created by SmallCode
02.07.2020 15:11

*/

import java.util.HashMap;

/**
 *
 * The petMapManager keeps track of all the pets available in each version
 *
 */

public abstract class PetMapManager {

    protected HashMap<String, Class> petMap;

    /**
     *
     * Creates an PetMapManager
     *
     */

    public PetMapManager(){

        petMap = new HashMap<String, Class>();

        registerPets();

    }

    /**
     *
     * Returns the petMap
     *
     * @return the petMap
     */

    public HashMap<String, Class> getPetMap() {
        return petMap;
    }

    /**
     *
     * Registers all the pets of a version
     *
     */

    protected abstract void registerPets();

}
