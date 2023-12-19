package models.enums;

public enum TipoIva {
    // TODO: 02/12/2023 validar como hacer un enum de valores numericos
    a(0.025f),
    b(0.05f),
    c(0.105f),
    d(0.21f),
    e(0.27f);
    private final float percentage;
    private TipoIva(float percentage){
        this.percentage = percentage;
    }

    public float getPercentage(){
        return percentage;
    }
}
