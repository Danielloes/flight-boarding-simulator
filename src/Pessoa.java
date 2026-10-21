public sealed class Pessoa implements Pesavel permits Passageiro, Tripulante {
    private final String nome;
    private final double peso;
    public Pessoa(String nome, double peso) {
        if (nome == null || nome.isBlank()) throw new IllegalArgumentException("Informe o nome.");
        if (!Double.isFinite(peso) || peso <= 0) throw new IllegalArgumentException("Peso deve ser positivo e finito.");
        this.nome = nome.trim(); this.peso = peso;
    }
    public String getNome() { return nome; }
    public final double getPeso() { return peso; }
}
