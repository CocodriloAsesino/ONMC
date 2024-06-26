
package onmc;

import java.nio.file.Paths;
import javafx.beans.InvalidationListener;
import javafx.scene.control.Slider;
import javafx.scene.control.ToggleButton;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

public class audio{
    ToggleButton plst;
    Slider volumen;
    
    audio(Slider volumen, ToggleButton plst){
        this.plst= plst;
        this.volumen= volumen;
    } 
    
    Media audio1 = new Media(Paths.get("src/audio/jungla.wav").toUri().toString());
    MediaPlayer aud1=new MediaPlayer(audio1);

    Media audio2 = new Media(Paths.get("src/audio/cocodrilo2.wav").toUri().toString());
    MediaPlayer aud2=new MediaPlayer(audio2);

    Media audio3 = new Media(Paths.get("src/audio/Chipi.wav").toUri().toString());
    MediaPlayer aud3=new MediaPlayer(audio3); 
    
    Media audio4 = new Media(Paths.get("src/audio/cocodrilo.wav").toUri().toString());
    MediaPlayer aud4=new MediaPlayer(audio4);
    
    public void musicaAudio1(){
        aud1.setOnEndOfMedia(()->{aud1.seek(Duration.ZERO);});
        aud1.play();
        volumen.setValue(aud1.getVolume() * 50);
        volumen.valueProperty().addListener(new InvalidationListener() {
            @Override
            public void invalidated(javafx.beans.Observable observable) {
                aud1.setVolume(volumen.getValue() / 100);
            } 
        });
        plst.setOnAction(reproductor ->{
            if(plst.isSelected()){
                aud1.stop();  
            } 
            else {
                aud1.play(); 
            }
        });
    }
    public void musicaAudio2(){
        aud2.play();
        volumen.setValue(aud2.getVolume() * 50);
        volumen.valueProperty().addListener(new InvalidationListener() {
            @Override
            public void invalidated(javafx.beans.Observable observable) {
                aud2.setVolume(volumen.getValue() / 100);
            } 
        });
        plst.setOnAction(reproductor ->{
            if(plst.isSelected()){
                aud2.stop();  
            } 
            else {
                aud2.play(); 
            }
        });
    }
    public void musicaAudio3(){
        aud3.play();
        volumen.setValue(aud3.getVolume() * 50);
        volumen.valueProperty().addListener(new InvalidationListener() {
            @Override
            public void invalidated(javafx.beans.Observable observable) {
                aud3.setVolume(volumen.getValue() / 100);
            } 
        });
        plst.setOnAction(reproductor ->{
            if(plst.isSelected()){
                aud3.stop();  
            } 
            else {
                aud3.play(); 
            }
        });
    }
    public void musicaAudio4(){
        aud4.play();
        volumen.setValue(aud4.getVolume() * 50);
        volumen.valueProperty().addListener(new InvalidationListener() {
            @Override
            public void invalidated(javafx.beans.Observable observable) {
                aud4.setVolume(volumen.getValue() / 100);
            } 
        });
        plst.setOnAction(reproductor ->{
            if(plst.isSelected()){
                aud4.stop();  
            } 
            else {
                aud4.play(); 
            }
        });
    }

    public void musicaOff1(){
        aud1.stop();
    }
    public void musicaOff2(){
        aud2.stop();
    }
    public void musicaOff3(){
        aud3.stop();
    }
    public void musicaOff4(){
        aud4.stop();
    }
}
