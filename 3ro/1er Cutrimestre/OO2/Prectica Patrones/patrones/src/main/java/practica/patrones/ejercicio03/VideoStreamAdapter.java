package practica.patrones.ejercicio03;
public class VideoStreamAdapter extends Media {

    private VideoStream videoStream;

    public VideoStreamAdapter(VideoStream videoStream){
        this.videoStream = videoStream;
    }

    @Override
    public void play(){
        this.videoStream.reproduce();
    }
}
