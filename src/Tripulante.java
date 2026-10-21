import java.util.Objects;
public final class Tripulante extends Pessoa {
    private final Funcao funcao;
    public Tripulante(String nome, double peso, Funcao funcao) {
        super(nome, peso); this.funcao = Objects.requireNonNull(funcao, "Informe a função.");
    }
    public Funcao getFuncao() { return funcao; }
}
