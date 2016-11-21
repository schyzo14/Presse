/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.ArrayList;
import java.util.HashMap;
import javax.ejb.Local;
import presse.titre;
import presse.volume;


/**
 *
 * @author Khadija
 */
@Local
public interface archivesBeanLocal {
    public volume addVolume(String vol);
    public ArrayList<titre> getTitreParNom(String nomT);
    public ArrayList<titre> getTitres();
    public ArrayList<titre> getTitreParMC(String nomT);
    public volume getVolume(String numV, String nomT);
}
