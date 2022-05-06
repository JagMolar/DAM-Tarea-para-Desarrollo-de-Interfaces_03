/*
 * La clase AlarmaEditor, recoge los datos para crear un editor de 
 * propiedades personalizado.
 */
package relojdigital;

import java.awt.Component;
import java.beans.PropertyEditorSupport;
import java.util.Date;

/**
 *
 * @author juang <juangmuelas@gmail.com>
 * @since 30/12/2021
 * @version 1
 */

public class AlarmaEditor extends PropertyEditorSupport {
    private AlarmaJP alarmaJp = new AlarmaJP();
    
    @Override
    public boolean supportsCustomEditor(){
    return true;//al estar personalizado devuelve true (por defecto es false)
    }
    
    @Override
    public Component getCustomEditor(){
        return alarmaJp;
    }
    
    @Override
    public Object getValue(){
        return alarmaJp.getSelectedValue();
    }
    
    @Override
    public String getJavaInitializationString(){
        Date horaAlarma = alarmaJp.getSelectedValue().getHoraAlarma();
        boolean activar = alarmaJp.getSelectedValue().isActivar();
        return "new relojdigital.Alarma(new java.util.Date(" 
            + horaAlarma.getTime() + "l),"  + activar + ")";
    }
}//fin clase AlarmaEditor
