public final class Bagagem implements Pesavel {
    private final double peso;
    public Bagagem(double peso) {
        if (!Double.isFinite(peso) || peso <= 0) throw new IllegalArgumentException("Peso deve ser positivo e finito.");
        this.peso = peso;
    }
    public double getPeso() { return peso; }
}
