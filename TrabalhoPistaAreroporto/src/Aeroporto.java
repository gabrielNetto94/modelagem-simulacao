
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author usrlab25
 */
public class Aeroporto {
    public boolean statusPista = false;
    public Aviao portoes[] = {null, null, null, null, null};
    public void usarPista() {
        statusPista = true;
        try {
            sleep(500);
        } catch (InterruptedException ex) {
            System.out.println(ex);
        }
        statusPista = false;
    }
}
