/*
 * TAREA DI_03.
 * crear un reloj digital que poder insertar en cualquier interfaz, 
 * el reloj debe tener al menos las siguientes características:
 *  Una propiedad booleana para indicar si el formato es de 12 o 24 horas.
 *  Una propiedad booleana para indicar si queremos activar una alarma. 
 *   El funcionamiento de la alarma consistirá en que se podrá configurar
 *   el componente para que a una determinada hora nos muestre un mensaje. 
 *  Dos propiedades para determinar la hora y minuto para el cual 
 *   queremos programar la alarma. Ambas propiedades serán de tipo entero.
 *  Una propiedad para configurar el mensaje de texto, que queremos que 
 *   se muestre, cuando se produzca el salto de la alarma.
 *   Esta propiedad será de tipo texto (String).     
 *  Función de alarma, si se programa a una hora, debe generar un evento 
 *   cuando se llegue a esa hora.
 *
 */
package relojdigital;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.EventListener;
import javax.swing.JLabel;
import javax.swing.Timer;

/**
 *
 * @author juang <juangmuelas@gmail.com>
 * @since 30/12/2021
 * @version 1
 */
public class RelojDigitalBean extends JLabel implements ActionListener, Serializable {
    
    private boolean formato;
    private boolean activar;
    private int hora;
    private int minuto;
    private int segundo;
    private String mensaje;
    private final DateTimeFormatter format12 = DateTimeFormatter.ofPattern("hh:mm:ss a");
    private final DateTimeFormatter format24 = DateTimeFormatter.ofPattern("HH:mm:ss");
    private LocalDateTime horaReloj;
    private final Timer t;
    private AlarmaRelojListener receptor;
    private Alarma alarma;
    
    public interface AlarmaRelojListener extends EventListener{
        public void capturarAlarmaReloj(AlarmaRelojEvent ev);
    }
    
      
    /**
     * getters y setters generados
     */

    /**
     * Get the value of formato
     *
     * @return the value of formato
     */
    public boolean isFormato() {
        return formato;
    }

    /**
     * Set the value of formato
     *
     * @param formato new value of formato
     */
    public void setFormato(boolean formato) {
        this.formato = formato;
    }
  
    /**
     * Get the value of activar
     *
     * @return the value of activar
     */
    public boolean isActivar() {
        return activar;
    }

    /**
     * Set the value of activar
     *
     * @param activar new value of activar
     */
    public void setActivar(boolean activar) {
        this.activar = activar;
    }      

    /**
     * Get the value of hora
     *
     * @return the value of hora
     */
    public int getHora() {
        return hora;
    }

    /**
     * Set the value of hora
     *
     * @param hora new value of hora
     */
    public void setHora(int hora) {
        this.hora = hora;
    }
           
    /**
     * Get the value of minuto
     *
     * @return the value of minuto
     */
    public int getMinuto() {
        return minuto;
    }

    /**
     * Set the value of minuto
     *
     * @param minuto new value of minuto
     */
    public void setMinuto(int minuto) {
        this.minuto = minuto;
    }
    
    
    /**
     * Get the value of segundo
     *
     * @return the value of segundo
     */
    public int getSegundo() {
        return segundo;
    }

    /**
     * Set the value of segundo
     *
     * @param segundo new value of segundo
     */
    public void setSegundo(int segundo) {
        this.segundo = segundo;
    }
          

    /**
     * Get the value of mensaje
     *
     * @return the value of mensaje
     */
    public String getMensaje() {
        return mensaje;
    }

    /**
     * Set the value of mensaje
     *
     * @param mensaje new value of mensaje
     */
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    /**
     * Get the value of horaReloj
     *
     * @return the value of horaReloj
     */
    public LocalDateTime getHoraReloj() {
        return horaReloj;
    }
    
    /**
     * Set the value of horaReloj
     *
     * @param horaReloj new value of horaReloj
     */
    public void setHoraReloj(LocalDateTime horaReloj) {
        this.horaReloj = horaReloj;
    }
    
    /**
     * Get the value of alarma
     *
     * @return the value of alarma
     */
    public Alarma getAlarma() {
        return alarma;
    }
    
    /**
     * Set the value of alarma
     *
     * @param alarma new value of alarma
     */
    public void setAlarma(Alarma alarma) {
        this.alarma = alarma;
    }
    
    
    /**
     * Constructor vacio
     */
    public RelojDigitalBean() {
        t = new Timer (1000, this); //inicializar objeto Timer.
        t.start();
    }
    
    public boolean activarAlarma(Date horaAlarma,LocalDateTime horaReloj){
        
        /**
         * Creo una instancia de Calendar para manejar el Date 
         * recibido por la alarma, pues el Spinner no deja
         * castear los datos que recibe desde java.Util.Date a Time.
         * La hora actual si la recogemos con un objeto Time.
         */
        Calendar reloj = Calendar.getInstance();
        horaReloj = LocalDateTime.now();
        //Por seguimiento particular de ejecución recojo los datos
        System.out.println("hora reloj" + horaReloj);
        System.out.println("hora alarma" + horaAlarma);
        int hReloj = LocalDateTime.now().getHour();
        int mReloj = LocalDateTime.now().getMinute();
        int sReloj = LocalDateTime.now().getSecond();

        reloj.setTime(horaAlarma);
        hora = reloj.get(Calendar.HOUR_OF_DAY);
        minuto = reloj.get(Calendar.MINUTE);
        segundo = reloj.get(Calendar.SECOND);
        
        //Si los datos coinciden, retorna true para activar el evento
        if( hReloj == hora && mReloj == minuto && sReloj == segundo){
            return true;
        }else{
            return false;
        }
    }//fin método activarAlarma
    
    
    @Override
    public void actionPerformed(ActionEvent e)
    {   
        /**
         * Comprobamos hora y recogemos formato
         */
        horaReloj = LocalDateTime.now();
        if(formato){
            setText(format12.format(LocalDateTime.now()));
        }else{
            setText(format24.format(LocalDateTime.now()));
        }
        //hacemos que refresque lo mostrado
        repaint();
        
        //evitamos un nullpointerException con este primer if
        if(alarma != null){
            
            /**
             * Si la alarma está activada y recibimos datos 
             * correctos desde el método, mandamos el evento
             */
            if(alarma.isActivar() && activarAlarma(alarma.getHoraAlarma(), horaReloj)){
            receptor.capturarAlarmaReloj(new AlarmaRelojEvent(this));
            }
        }
    }//fin del ActionPerformed
        
    public void addAlarmaRelojListener(AlarmaRelojListener receptor){
        this.receptor = receptor;
    }

    public void removeAlarmaRelojListener(AlarmaRelojListener receptor){
        this.receptor=null;
    }
      
} //fin clase RelojDigitalBean
