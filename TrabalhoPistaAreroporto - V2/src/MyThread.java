
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 18911
 */
public class MyThread implements Runnable {

    public Principal form;
    Aviao aviao;

    MyThread(Principal form, Aviao aviao) {
        this.form = form;
        this.aviao = aviao;
    }

    public void run() {
        form.teste(aviao);
        try {
            wait();
        } catch (InterruptedException ex) {
            Logger.getLogger(MyThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
