package practica.patrones.ejercicio03;
public class MediaPlayer {
    private Media media;

    public MediaPlayer(Media media){
        this.media = media;
    }

    public void play(){
        this.media.play();
    }
}
