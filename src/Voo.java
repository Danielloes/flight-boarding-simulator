import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class Voo {
    private final Aviao aviao;
    private final List<Pesavel> itensEmbarcados = new ArrayList<>();
    public Voo(Aviao aviao) { this.aviao = Objects.requireNonNull(aviao); }
    public List<Pesavel> getItensEmbarcados() { return List.copyOf(itensEmbarcados); }
    public long getQuantidadePassageirosAtuais() {
        return itensEmbarcados.stream().filter(Passageiro.class::isInstance).count();
    }

    public void embarcar(Pesavel item) {
        Objects.requireNonNull(item, "Informe um item.");
        if (!(item instanceof Passageiro || item instanceof Tripulante || item instanceof Bagagem))
            throw new IllegalArgumentException("Tipo de item não suportado.");
        if (itensEmbarcados.contains(item)) throw new IllegalArgumentException("Item já embarcado.");
        if (item instanceof Passageiro passageiro) {
            if (getQuantidadePassageirosAtuais() >= aviao.getNumeroAssentos()) throw new IllegalArgumentException("Capacidade de passageiros excedida.");
            boolean ocupado = itensEmbarcados.stream().filter(Passageiro.class::isInstance).map(Passageiro.class::cast)
                .anyMatch(p -> p.getAssento().equals(passageiro.getAssento()));
            if (ocupado) throw new IllegalArgumentException("Assento já ocupado.");
        }
        if (obterPesoTotal() + item.getPeso() > aviao.getPesoMaximo()) throw new IllegalArgumentException("Peso máximo excedido.");
        itensEmbarcados.add(item);
    }
    public double obterPesoBagagem() {
        return itensEmbarcados.stream().filter(Bagagem.class::isInstance).mapToDouble(Pesavel::getPeso).sum();
    }
    public double obterPesoTotal() { return itensEmbarcados.stream().mapToDouble(Pesavel::getPeso).sum(); }
}
