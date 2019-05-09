
public class Aviao {

    private int posicaoFila;
    private String transponder;
    private float peso;
    private float quantidadeCombustivel;
    private int prioridade;
    private String codigoVoo;
    private String origem;
    private int horaVoo;
    private int tipoFila; // 0 - filaPouso  1 - filaTaxiamento 2 - filaEstacioamento
    private int status; //{"Aguardando pouso", "Pousando", "Taxiando", "Decolando", "Saindo da pista", "Estacionamento"}

    public String getCodigoVoo() {
        return codigoVoo;
    }

    public void setCodigoVoo(String codigoVoo) {
        this.codigoVoo = codigoVoo;
    }

    public int getHoraVoo() {
        return horaVoo;
    }

    public void setHoraVoo(int horaVoo) {
        this.horaVoo = horaVoo;
    }

    public int getTipoFila() {
        return tipoFila;
    }

    public void setTipoFila(int tipoFila) {
        this.tipoFila = tipoFila;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Aviao(int posicaoFila, String transponder, float peso,
            float quantidadeCombustivel, int prioridade, String CodigoVoo,
            String origem, int HoraVoo, int TipoFila, int status) {

        this.posicaoFila = posicaoFila;
        this.transponder = transponder;
        this.peso = peso;
        this.quantidadeCombustivel = quantidadeCombustivel;
        this.prioridade = prioridade;
        this.codigoVoo = CodigoVoo;
        this.origem = origem;
        this.horaVoo = HoraVoo;
        this.tipoFila = TipoFila;
        this.status = status;
    }

    public Aviao() {

    }

    public int getPosicaoFila() {
        return posicaoFila;
    }

    public void setPosicaoFila(int posicaoFila) {
        this.posicaoFila = posicaoFila;
    }

    public String getTransponder() {
        return transponder;
    }

    public void setTransponder(String transponder) {
        this.transponder = transponder;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public float getQuantidadeCombustivel() {
        return quantidadeCombustivel;
    }

    public void setQuantidadeCombustivel(float quantidadeCombustivel) {
        this.quantidadeCombustivel = quantidadeCombustivel;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }
}
