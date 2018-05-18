package utils;

public enum Camera {
    CAMERA_FRONTAL(0),
    CAMERA_TRASEIRA(1);

    private final int valor;
    Camera(int valorOpcao){
        valor = valorOpcao;
    }
    public int getValor(){
        return valor;
    }
}
