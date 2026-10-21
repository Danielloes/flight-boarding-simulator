import java.util.Locale;
public final class Passageiro extends Pessoa {
    private final String assento;
    public Passageiro(String nome, double peso, String assento) {
        super(nome, peso);
        if (assento == null || assento.isBlank()) throw new IllegalArgumentException("Informe o assento.");
        this.assento = assento.trim().toUpperCase(Locale.ROOT);
    }
    public String getAssento() { return assento; }
}
