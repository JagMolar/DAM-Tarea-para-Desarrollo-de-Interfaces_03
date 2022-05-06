/*
 * La clase Alarma, contiene las propiedades y métodos necesarios para 
 * recoger los datos que introduzca el usuario.
 */
package relojdigital;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author juang <juangmuelas@gmail.com>
 * @since 30/12/2021
 * @version 1
 */
public class Alarma implements Serializable {
    private Date horaAlarma;
    private boolean activar;

    public Alarma(Date horaAlarma, boolean activar) {
        this.horaAlarma = horaAlarma;
        this.activar = activar;
    }

    public Date getHoraAlarma() {
        return horaAlarma;
    }

    public void setHoraAlarma(Date horaAlarma) {
        this.horaAlarma = horaAlarma;
    }

    public boolean isActivar() {
        return activar;
    }

    public void setActivar(boolean activar) {
        this.activar = activar;
    }
    
}
