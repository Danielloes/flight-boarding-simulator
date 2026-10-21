public final class Aviao {
    private final String modelo;
    private final int numeroAssentos;
    private final double pesoMaximo;
    public Aviao(String modelo, int numeroAssentos, double pesoMaximo) {
        if (modelo == null || modelo.isBlank()) throw new IllegalArgumentException("Informe o modelo.");
        if (numeroAssentos <= 0) throw new IllegalArgumentException("A capacidade deve ser positiva.");
        if (!Double.isFinite(pesoMaximo) || pesoMaximo <= 0) throw new IllegalArgumentException("Limite de peso inválido.");
        this.modelo = modelo.trim(); this.numeroAssentos = numeroAssentos; this.pesoMaximo = pesoMaximo;
    }
    public String getModelo() { return modelo; }
    public int getNumeroAssentos() { return numeroAssentos; }
    public double getPesoMaximo() { return pesoMaximo; }
}
