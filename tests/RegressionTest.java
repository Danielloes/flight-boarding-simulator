public class RegressionTest {

    private static int checks;
    private static void check(boolean condition) {
        checks++;
        if (!condition) throw new AssertionError("Verificação " + checks + " falhou.");
    }
    @FunctionalInterface private interface Action { void run() throws Exception; }
    private static void expect(Class<? extends Exception> type, Action action) throws Exception {
        try { action.run(); }
        catch (Exception e) {
            check(type.isInstance(e)); return;
        }
        throw new AssertionError("Esperada exceção " + type.getSimpleName());
    }

    public static void main(String[] args) throws Exception {
        Voo voo = new Voo(new Aviao("Exemplo", 2, 250));
        Tripulante piloto = new Tripulante("Piloto", 80, Funcao.PILOTO);
        voo.embarcar(piloto); voo.embarcar(new Passageiro("A", 70, "1A"));
        voo.embarcar(new Bagagem(20));
        check(voo.getQuantidadePassageirosAtuais() == 1);
        check(voo.obterPesoBagagem() == 20 && voo.obterPesoTotal() == 170);
        expect(IllegalArgumentException.class, () -> voo.embarcar(new Passageiro("B", 60, " 1a ")));
        expect(IllegalArgumentException.class, () -> voo.embarcar(new Bagagem(81)));
        expect(IllegalArgumentException.class, () -> voo.embarcar(piloto));
        expect(NullPointerException.class, () -> voo.embarcar(null));
        check(voo.getItensEmbarcados().size() == 3 && voo.obterPesoTotal() == 170);
        voo.embarcar(new Passageiro("B", 80, "1B"));
        check(voo.obterPesoTotal() == 250 && voo.getQuantidadePassageirosAtuais() == 2);
        expect(IllegalArgumentException.class, () -> voo.embarcar(new Passageiro("C", 1, "2A")));
        expect(UnsupportedOperationException.class, () -> voo.getItensEmbarcados().clear());
        expect(IllegalArgumentException.class, () -> new Bagagem(Double.NaN));
        expect(IllegalArgumentException.class, () -> new Bagagem(Double.POSITIVE_INFINITY));
        expect(IllegalArgumentException.class, () -> new Bagagem(-1));
        expect(IllegalArgumentException.class, () -> new Pessoa("", 80));
        expect(IllegalArgumentException.class, () -> new Passageiro("A", 80, " "));
        expect(IllegalArgumentException.class, () -> new Aviao("A", 0, 300));
        expect(IllegalArgumentException.class, () -> new Aviao("A", 3, Double.NaN));
        check(voo.obterPesoTotal() == 250 && voo.getItensEmbarcados().size() == 4);
        System.out.println("Embarque: " + checks + " verificações OK");
    }

}
