/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onmc;


import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import utilidades.bbdd.Bd;
import utilidades.bbdd.Gestor_conexion_POSTGRE;


/**
 * FXML Controller class
 *
 * @author Usuario
 */
public class JuegoPCController{

    @FXML
    private boolean TurnoJugA = false;
    private boolean TurnoJugB = false;
    private int Turno;
    //private InicioController nom = new InicioController();
    
    @FXML
    private Button a00, a01, a02, a03, a04, a10, a11, a12, a13, a14, a20, a21, a22, a23, a24, a30, a31, a32, a33, a34, a40, a41, a42, a43, a44;
   
    @FXML
    private final Button[][] TABLA1= {{a00, a01, a02, a03, a04},{a10, a11, a12, a13, a14},{a20, a21, a22, a23, a24},{a30, a31, a32, a33, a34},{a40, a41, a42, a43, a44}};
   
    @FXML
    private Button b00, b01, b02, b03, b04, b10, b11, b12, b13, b14, b20, b21, b22, b23, b24, b30, b31, b32, b33, b34, b40, b41, b42, b43, b44;
    
    public Button [] tablita1;
    public Button [] tablita2;
    
    @FXML
    private tablajuego pantano1, pantano2;
  
    @FXML
    private Button config, salir;
    
    @FXML
    private ProgressBar vida1, vida2;
   
    @FXML
    private Label puntoA, puntoB, turnoA, turnoB, usuarioA, usuarioB, idPartida;
    @FXML
    String [] nombre = {"Jose", "Dani", "Monica", "Ana", "Mila"};
    

    

    
    
    public void initialize() throws Exception{
        Random rnd=new Random();
         
            Turno = rnd.nextInt(2);

            pantano1=new tablajuego();
            pantano1.pantanoPersonas();
            turnoA.setText(pantano1.getTurno()+"");
            puntoA.setText(pantano1.getPt()+"");
            usuarioA.setText(InicioController.user);
            
            Button [] tablaTemp = {a00, a01, a02, a03, a04,a10, a11, a12, a13, a14,a20, a21, a22, a23, a24,a30, a31, a32, a33, a34,a40, a41, a42, a43, a44};
            Button [] tablaTemp2 = {b00, b01, b02, b03, b04,b10, b11, b12, b13, b14,b20, b21, b22, b23, b24,b30, b31, b32, b33, b34,b40, b41, b42, b43, b44};
            
            tablita1=tablaTemp;
            tablita2=tablaTemp2;
            
            pantano2=new tablajuego();
            pantano2.pantanoPersonas();
            turnoB.setText(pantano2.getTurno()+"");
            puntoB.setText(pantano2.getPt()+"");
            usuarioB.setText(nombre[rnd.nextInt(5)]);
            
            idPartida.setText(InicioController.idPar);
        
        //pantano2.jugadorBot(puntoB,turnoB,pantano2,vida2, TABLA2);

        
        
        if(Turno==1){
            TurnoJugA=true;
            TurnoJugB=false;
        }else {
            TurnoJugA=false;
            TurnoJugB=true;
            AccionTablaB();
        }
    }
    
    
    

    public void CambioTurno() throws Exception{
        
        if(TurnoJugA==true){
            TurnoJugB=true;
            TurnoJugA=false;
            AccionTablaB();
        }else {
            TurnoJugB=false;
            TurnoJugA=true;
        }
    }

    public void setTurnoJugA(boolean TurnoJugA) {
        this.TurnoJugA = TurnoJugA;
    }

    public void setTurnoJugB(boolean TurnoJugB) {
        this.TurnoJugB = TurnoJugB;
    }
    
   
    
    @FXML
    public void btnSalir(ActionEvent event) throws Exception {
        Parent loader = FXMLLoader.load(getClass().getResource("Escenas/Perfil.fxml"));
        ONMC.stage.getScene().setRoot(loader);
        ONMC.stage.show();
    }
   
    //BOTONES TABLA

    public void ases(int x, int y) throws Exception{
        
        Random rnd=new Random();
        
        String temp = "a" + x + y;
        
        for (int i = 0; i < tablita1.length; i++) {
            if(temp.equals(tablita1[i].getId())) 
               if(TurnoJugA==true){
                 if(pantano1.Casilla(puntoA,turnoA,tablita1[i],pantano1,vida1,x,y) != 1){
                     CambioTurno();
                 }
             }                       
        }
    }
    
    
    @FXML
    public void a00(ActionEvent Event) throws Exception{
        ases(0,0);
    }
    
    @FXML
    public void a01(ActionEvent Event) throws Exception{
         ases(0,1);
    }
    
    @FXML
    public void a02(ActionEvent Event) throws Exception{
        ases(0,2);
    }
    
    @FXML
    public void a03(ActionEvent Event) throws Exception{
       ases(0,3); 
    }
    
    @FXML
    public void a04(ActionEvent Event) throws Exception{
       ases(0,4);
    }
    
    @FXML
    public void a10(ActionEvent Event) throws Exception{
        ases(1,0); 
    }
    
    @FXML
    public void a11(ActionEvent Event) throws Exception{
        ases(1,1);
    }
    
    @FXML
    public void a12(ActionEvent Event) throws Exception{
       ases(1,2); 
    }
    
    @FXML
    public void a13(ActionEvent Event) throws Exception{
        ases(1,3);
    }
    
    @FXML
    public void a14(ActionEvent Event) throws Exception{
        ases(1,4);
    }
    
    @FXML
    public void a20(ActionEvent Event) throws Exception{
       ases(2,0);
    }
    
    @FXML
    public void a21(ActionEvent Event) throws Exception{
       ases(2,1);
    }
    
    @FXML
    public void a22(ActionEvent Event) throws Exception{
      ases(2,2);
    }
    
    @FXML
    public void a23(ActionEvent Event) throws Exception{
       ases(2,3);
    }
    
    @FXML
    public void a24(ActionEvent Event) throws Exception{
       ases(2,4);
    }
    
    @FXML
    public void a30(ActionEvent Event) throws Exception{
       ases(3,0);
    }
    
    @FXML
    public void a31(ActionEvent Event) throws Exception{
      ases(3,1);
    }
    
    @FXML
    public void a32(ActionEvent Event) throws Exception{
      ases(3,2);
    }
    
    @FXML
    public void a33(ActionEvent Event) throws Exception{
       ases(3,3);
    }
    
    @FXML
    public void a34(ActionEvent Event) throws Exception{
        ases(3,4);
    }
    
    @FXML
    public void a40(ActionEvent Event) throws Exception{
       ases(4,0);
    }
    
    @FXML
    public void a41(ActionEvent Event) throws Exception{
       ases(4,1); 
    }
    
    @FXML
    public void a42(ActionEvent Event) throws Exception{
       ases(4,2);
    }
    
    @FXML
    public void a43(ActionEvent Event) throws Exception{
       ases(4,3);
    }
    
    @FXML
    public void a44(ActionEvent Event) throws Exception{
        ases(4,4);
    }
    
    @FXML
    public void AccionTablaB() throws Exception{
        Random rnd=new Random();
        int x=rnd.nextInt(5),y=rnd.nextInt(5);
        String boton = "b" + x + y;

        for (int i = 0; i < tablita2.length; i++) {
            if(boton.equals(tablita2[i].getId())){
                if(TurnoJugB==true){
                    if(pantano2.Casilla(puntoB,turnoB,tablita2[i],pantano2,vida2,x,y) != 1) 
                        CambioTurno();
                    else
                        AccionTablaB();
                }
            }
        }
    }

    @FXML
    public void b00(ActionEvent Event) throws Exception{
        int x=0,y=0;
        if(TurnoJugB==true){
            if(pantano2.Casilla(puntoB,turnoB,b00,pantano2,vida2,x,y) != 1) 
                CambioTurno();
            else
                AccionTablaB();
        }
    }
    
    @FXML
    public void b01(ActionEvent Event) throws Exception{
        int x=0,y=1;
        if(TurnoJugB==true){
            if(pantano2.Casilla(puntoB,turnoB,b01,pantano2,vida2,x,y) != 1) 
                CambioTurno();
            else
                AccionTablaB();
        }
    }
    
    @FXML
    public void b02(ActionEvent Event) throws Exception{
        int x=0,y=2;
        if(TurnoJugB==true){
            if(pantano2.Casilla(puntoB,turnoB,b02,pantano2,vida2,x,y) != 1)  
                CambioTurno();
            else
                AccionTablaB();
        } 
    }
    
    @FXML
    public void b03(ActionEvent Event) throws Exception{
        int x=0,y=3;
        if(TurnoJugB==true){
            if(pantano2.Casilla(puntoB,turnoB,b03,pantano2,vida2,x,y) != 1)  
                CambioTurno();
            else
                AccionTablaB();
        }
    }
    
    @FXML
    public void b04(ActionEvent Event) throws Exception{
        int x=0,y=4;
        if(TurnoJugB==true){
            if(pantano2.Casilla(puntoB,turnoB,b04,pantano2,vida2,x,y) != 1) 
                CambioTurno();
            else
                AccionTablaB();
        } 
    }
    
    @FXML
    public void b10(ActionEvent Event) throws Exception{
        int x=1,y=0;
        if(TurnoJugB==true){
            if(pantano2.Casilla(puntoB,turnoB,b10,pantano2,vida2,x,y) != 1) 
                CambioTurno();
            else
                AccionTablaB();
        } 
    }
    
    @FXML
    public void b11(ActionEvent Event) throws Exception{
        int x=1,y=1;
        if(TurnoJugB==true){
            if(pantano2.Casilla(puntoB,turnoB,b11,pantano2,vida2,x,y) != 1)  
                CambioTurno();
            else
                AccionTablaB();
        }
    }
    
    @FXML
    public void b12(ActionEvent Event) throws Exception{
        int x=1,y=2;
       if(TurnoJugB==true){
            if(pantano2.Casilla(puntoB,turnoB,b12,pantano2,vida2,x,y) != 1) 
                CambioTurno();
            else
                AccionTablaB();
        }
    }
    
    @FXML
    public void b13(ActionEvent Event) throws Exception{
        int x=1,y=3;
       if(TurnoJugB==true){
            if(pantano2.Casilla(puntoB,turnoB,b13,pantano2,vida2,x,y) != 1)  
                CambioTurno();
            else
                AccionTablaB();
        }
    }
    
    @FXML
    public void b14(ActionEvent Event) throws Exception{
        int x=1,y=4;
        if(TurnoJugB==true){
            if(pantano2.Casilla(puntoB,turnoB,b14,pantano2,vida2,x,y) != 1) 
                CambioTurno();
            else
                AccionTablaB();
        } 
    }
    
    @FXML
    public void b20(ActionEvent Event) throws Exception{
        int x=2,y=0;
        if(TurnoJugB==true){
            if(pantano2.Casilla(puntoB,turnoB,b20,pantano2,vida2,x,y) != 1) 
                CambioTurno();
            else
                AccionTablaB();
        }
    }
    
    @FXML
    public void b21(ActionEvent Event) throws Exception{
        int x=2,y=1;
        if(TurnoJugB==true){
            if(pantano2.Casilla(puntoB,turnoB,b21,pantano2,vida2,x,y) != 1)  
                CambioTurno();
            else
                AccionTablaB();
        }
    }
    
    @FXML
    public void b22(ActionEvent Event) throws Exception{
        int x=2,y=2;
        if(TurnoJugB==true){
            if(pantano2.Casilla(puntoB,turnoB,b22,pantano2,vida2,x,y) != 1) 
                CambioTurno();
            else
                AccionTablaB();
        }
    }
    
    @FXML
    public void b23(ActionEvent Event) throws Exception{
        int x=2,y=3;
        if(TurnoJugB==true){
            if(pantano2.Casilla(puntoB,turnoB,b23,pantano2,vida2,x,y) != 1) 
                CambioTurno();
            else
                AccionTablaB();
        }
    }
    
    @FXML
    public void b24(ActionEvent Event) throws Exception{
        int x=2,y=4;
        if(TurnoJugB==true){
            if(pantano2.Casilla(puntoB,turnoB,b24,pantano2,vida2,x,y) != 1)  
                CambioTurno();
            else
                AccionTablaB();
        }
    }
    
    @FXML
    public void b30(ActionEvent Event) throws Exception{
        int x=3,y=0;
        if(TurnoJugB==true){
            if(pantano2.Casilla(puntoB,turnoB,b30,pantano2,vida2,x,y) != 1) 
                CambioTurno();
            else
                AccionTablaB();
        }
    }
    
    @FXML
    public void b31(ActionEvent Event) throws Exception{
        int x=3,y=1;
       if(TurnoJugB==true){
            if(pantano2.Casilla(puntoB,turnoB,b31,pantano2,vida2,x,y) != 1) 
                CambioTurno();
            else
                AccionTablaB();
        } 
    }
    
    @FXML
    public void b32(ActionEvent Event) throws Exception{
        int x=3,y=2;
        if(TurnoJugB==true){
            if(pantano2.Casilla(puntoB,turnoB,b32,pantano2,vida2,x,y) != 1) 
                CambioTurno();
            else
                AccionTablaB();
        } 
    }
    
    @FXML
    public void b33(ActionEvent Event) throws Exception{
        int x=3,y=3;
        if(TurnoJugB==true){
            if(pantano2.Casilla(puntoB,turnoB,b33,pantano2,vida2,x,y) != 1) 
                CambioTurno();
            else
                AccionTablaB();
        }
    }
    
    @FXML
    public void b34(ActionEvent Event) throws Exception{
        int x=3,y=4;
        if(TurnoJugB==true){
           if(pantano2.Casilla(puntoB,turnoB,b34,pantano2,vida2,x,y) != 1) 
                CambioTurno();
           else
                AccionTablaB();
        }
    }
    
    @FXML
    public void b40(ActionEvent Event) throws Exception{
        int x=4,y=0;
          if(TurnoJugB==true){
            if(pantano2.Casilla(puntoB,turnoB,b40,pantano2,vida2,x,y) != 1) 
                CambioTurno();
            else
                AccionTablaB();
        } 
    }
    
    @FXML
    public void b41(ActionEvent Event) throws Exception{
        int x=4,y=1;
        if(TurnoJugB==true){
            if(pantano2.Casilla(puntoB,turnoB,b41,pantano2,vida2,x,y) != 1) 
                CambioTurno();
            else
                AccionTablaB();
        }
    }
    
    @FXML
    public void b42(ActionEvent Event) throws Exception{
        int x=4,y=2;
        if(TurnoJugB==true){
            if(pantano2.Casilla(puntoB,turnoB,b42,pantano2,vida2,x,y) != 1) 
                CambioTurno();
            else
                AccionTablaB();
        }
    }
    
    @FXML
    public void b43(ActionEvent Event) throws Exception{
        int x=4,y=3;
        if(TurnoJugB==true){
            if(pantano2.Casilla(puntoB,turnoB,b43,pantano2,vida2,x,y) != 1) 
                CambioTurno();
            else
                AccionTablaB();
        } 
    }
    
    @FXML
    public void b44(ActionEvent Event) throws Exception{
        int x=4,y=4;
        if(TurnoJugB==true){
            if(pantano2.Casilla(puntoB,turnoB,b44,pantano2,vida2,x,y) != 1)  
                CambioTurno();
            else
                AccionTablaB();
        } 
    }   
    
}
