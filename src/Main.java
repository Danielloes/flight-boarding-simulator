public class Main {
    public static void main(String[] args) {
        Voo voo = new Voo(new Aviao("Avião demonstrativo", 2, 500));
        voo.embarcar(new Tripulante("Piloto de exemplo", 80, Funcao.PILOTO));
        voo.embarcar(new Passageiro("Pessoa de exemplo", 70, "1A"));
        voo.embarcar(new Bagagem(20));
        try { voo.embarcar(new Passageiro("Outro exemplo", 65, "1a")); }
        catch (IllegalArgumentException e) { System.out.println("Embarque recusado: " + e.getMessage()); }
        System.out.println("Passageiros: " + voo.getQuantidadePassageirosAtuais());
        System.out.println("Bagagem: " + voo.obterPesoBagagem() + " kg");
        System.out.println("Peso total: " + voo.obterPesoTotal() + " kg");
    }
}
