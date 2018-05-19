package utils;

public enum Camera {
    CAMERA_FRONTAL(1),
    CAMERA_TRASEIRA(0);

    private final int valor;
    Camera(int valorOpcao){
        valor = valorOpcao;
    }
    public int getValor(){
        return valor;
    }
}
