package storage.memory;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import domain.Custos;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fonis
 */
public class StorageMemoryCustos {

    List<Custos> custoses;
    
    public StorageMemoryCustos() {
        custoses = new ArrayList(){{
            add(new Custos("pera", "pera", "pera", "pera"));
            add(new Custos("mika", "mika", "mika", "mika"));
            add(new Custos("zika", "zika", "zika", "zika"));
        }};
    }
    
    public List<Custos> getAll(){
        return custoses;
    }
    
    
}
