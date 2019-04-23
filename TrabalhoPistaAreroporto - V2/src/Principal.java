
import static java.lang.Thread.sleep;
import java.util.LinkedList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Crhistopher, Vinicius, gabriel netto, willian zottele
 */
public class Principal extends javax.swing.JFrame {

    //variaveis de controle
    public String tipoPrioridade[] = {"Normal", "Pesado", "Emergência"};
    public String[] statusAviao = {"Aguardando pouso", "Pousando", "Taxiando", "Decolando", "Saindo da pista", "Estacionamento"};
    public String origens[] = {"Brasília", "Cuiabá", "Rio de Janeiro", "Manaus", "Vitória", "Londrina", "Belo Horizonte", "Florianópolis", "Fortaleza", "Porto Alegre"};
    Random random = new Random();
    public int quantidadeAviao = 0;
    public int hora = 0;

    //listas das filas
    LinkedList<Aviao> filaPouso = new LinkedList<>();
    LinkedList<Aviao> filaTaxiamento = new LinkedList<>();
    LinkedList<Aviao> filaEstacionamento = new LinkedList<>();
    Aeroporto aeroporto = new Aeroporto();
    //

    //modelo das tabelas
    DefaultTableModel modelFilaPouso;
    DefaultTableModel modelFilaTaxiamento;
    DefaultTableModel modelFilaEstacionamento;
    DefaultTableModel modelPista;
    DefaultTableModel modelGates;

    public Principal() throws InterruptedException {
        initComponents();
        //modelos das tabelas
        modelFilaPouso = (DefaultTableModel) jTableFilaPouso.getModel();
        modelFilaTaxiamento = (DefaultTableModel) jTableFilaTaxiamento.getModel();
        modelFilaEstacionamento = (DefaultTableModel) jTableFilaEstacionamento.getModel();
//        modelPista = (DefaultTableModel) jTablePista.getModel();
        modelGates = (DefaultTableModel) jTableGates.getModel();

        //setar hora
        jLabelHora.setText("HORA: ");
        atualizaHora();

        //inica com 30 aviões na fila de pouso
        criarAviao(filaPouso, 0, 0, 30);
        populaTabela(modelFilaPouso, filaPouso);

        //inicar o funcionamento do aeroporto
        //iniciar();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableFilaPouso = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTableFilaTaxiamento = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jButtonIniciar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaHistorico = new javax.swing.JTextArea();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTableGates = new javax.swing.JTable();
        jScrollPane10 = new javax.swing.JScrollPane();
        jTableFilaEstacionamento = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButtonPopular = new javax.swing.JButton();
        jLabelHora = new javax.swing.JLabel();
        jLabelUpdateHora = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTextAreaPista = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("FILA PARA USO DA PISTA DO AEROPORTO");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("FILA POUSO");

        jTableFilaPouso.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Origem", "Combustível", "Peso", "Prioridade", "Hora", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableFilaPouso);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("PISTA PRINCIPAL");

        jTableFilaTaxiamento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Origem", "Combustível", "Peso", "Prioridade", "Hora", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(jTableFilaTaxiamento);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("FILA TAXIAMENTO");

        jButtonIniciar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonIniciar.setText("INICIAR");
        jButtonIniciar.setToolTipText("");
        jButtonIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIniciarActionPerformed(evt);
            }
        });

        jTextAreaHistorico.setColumns(20);
        jTextAreaHistorico.setRows(5);
        jScrollPane2.setViewportView(jTextAreaHistorico);

        jTableGates.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Código", "Origem", "Combustível", "Peso", "Prioridade", "Hora", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(jTableGates);

        jTableFilaEstacionamento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Origem", "Combustível", "Peso", "Prioridade", "Hora", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane10.setViewportView(jTableFilaEstacionamento);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("FILA ESTACIONAMENTO");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("GATES");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("HISTORICO");

        jButtonPopular.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonPopular.setText("POPULAR FILAS");
        jButtonPopular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPopularActionPerformed(evt);
            }
        });

        jLabelHora.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelHora.setText("HORA: ");

        jLabelUpdateHora.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jTextAreaPista.setColumns(20);
        jTextAreaPista.setRows(5);
        jScrollPane6.setViewportView(jTextAreaPista);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 771, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelHora)
                                .addGap(1, 1, 1)
                                .addComponent(jLabelUpdateHora, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonPopular, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                                .addComponent(jButtonIniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(10, 10, 10)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel1)
                        .addGap(11, 11, 11))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 21, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jButtonIniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonPopular, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelHora)
                        .addComponent(jLabelUpdateHora, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonPopularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPopularActionPerformed
        //limpar listas antes de popular
        filaPouso.clear();
        filaTaxiamento.clear();
        filaEstacionamento.clear();

        // criar um dialogo que pede quantidade de avioes em cada fila
        //Chama o criarAviao(LinkedList<Aviao> fila, int status, int tipoFila, int quantidade)
        // tipoFila = 0 - filaPouso  1 - filaTaxiamento 2 - filaEstacioamento
        // status = "Aguardando pouso", "Pousando", "Taxiando", "Decolando", "Saindo da pista", "Estacionamento"
//        int qtdFila = Integer.parseInt(JOptionPane.showInputDialog("Quantidade para fila POUSO: "));
//        criarAviao(filaPouso, 0, 0, qtdFila);
//        qtdFila = Integer.parseInt(JOptionPane.showInputDialog("Quantidade para fila TAXIAMENTO: "));
//        criarAviao(filaTaxiamento, 2, 1, qtdFila);
//        qtdFila = Integer.parseInt(JOptionPane.showInputDialog("Quantidade para fila ESTACIONAMENTO: "));
//        criarAviao(filaEstacioamento, 5, 2, qtdFila);
        //POPULAR TABELAS
        populaTabela(modelFilaPouso, filaPouso);
        populaTabela(modelFilaTaxiamento, filaTaxiamento);
        populaTabela(modelFilaEstacionamento, filaEstacionamento);
        //liberar o iniciar
        jButtonIniciar.setEnabled(true);
    }//GEN-LAST:event_jButtonPopularActionPerformed

    private void jButtonIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIniciarActionPerformed
        //Criar metodo que inicia o sistema todo, todo o funcionamento entre o Aeroporto (servidor) e as listas de avioes
        iniciar();
    }//GEN-LAST:event_jButtonIniciarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {

        } catch (InstantiationException ex) {
            
        } catch (IllegalAccessException ex) {
            
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Principal().setVisible(true);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    //inicia todo o funcionamento do aeroporto
    private void iniciar() {
        //estancia o aeroporto

        aeroporto.statusPista = false;

        int iteracoes = 0;

        //enquanto tiver avioes para usar a pista, continua o funcionamento
        while (!filaPouso.isEmpty() || !filaEstacionamento.isEmpty() || !filaTaxiamento.isEmpty()) {

            //verificar pista
            if (!aeroporto.statusPista) {
                //ocupa a pista
                aeroporto.statusPista = true;

                //atribui ao objeto "aviao" o aviao com maior prioridade
                Aviao aviao = filaPouso.get(getMaxPrioridade(filaPouso, tipoPrioridade, 0));
                //print teste
                System.out.println("Código do voo com maior prioridade: " + aviao.getCodigoVoo() + " Prioridade " + aviao.getPrioridade());

                //antes de remover o aviao de fila de pouso, adiciona na filaEstacionamento
                filaEstacionamento.add(aviao);
                //remove da fila de pouso
                filaPouso.remove(filaPouso.get(getMaxPrioridade(filaPouso, tipoPrioridade, 0)));

                //NÃO ESTÁ FUNCI0NANDO1!!
                //mostra a PISTA sendo ocupada por 2 segundos                 
                //populaTabela(modelPista, aviao);
//                modelPista.setRowCount(0);
//                modelPista.addRow(new String[]{
//                    aviao.getCodigoVoo(),
//                    aviao.getOrigem(),
//                    Float.toString(aviao.getQuantidadeCombustivel()),
//                    Float.toString(aviao.getPeso()),
//                    tipoPrioridade[aviao.getPrioridade()],
//                    Integer.toString(aviao.getHoraVoo()),
//                    statusAviao[aviao.getStatus()]});
//                jTextAreaPista.append(aviao.getCodigoVoo()+"\n");
                Runnable r = new MyThread(this, aviao);
                new Thread(r).start();

                try {
                    Thread.sleep(2000);
                    notify();
                } catch (InterruptedException ex) {

                }
                jTextAreaPista.setText("");

                //popula as tabelas
                populaTabela(modelFilaPouso, filaPouso);
                populaTabela(modelFilaEstacionamento, filaEstacionamento);

                //inseri no histórico
                jTextAreaHistorico.append("Aviao " + aviao.getCodigoVoo() + " pousou \n");
                //inserir que o aviao foi para a fila de estacionamento
                jTextAreaHistorico.append("Aviao " + aviao.getCodigoVoo() + " foi para Estacionamento \n");

                //preencher gates
                for (int x = 0; x < filaEstacionamento.size(); x++) {
                    for (int i = 0; i < aeroporto.portoes.length; i++) {
                        if (aeroporto.portoes[i] == null) {
                            aeroporto.portoes[i] = filaEstacionamento.get(x);
                            jTextAreaHistorico.append("Aviao " + filaEstacionamento.get(x).getCodigoVoo() + " foi para o portão " + (i + 1) + "\n");
                            filaEstacionamento.remove(x);
                            x--;
                            populaTabela(modelFilaEstacionamento, filaEstacionamento); //atualizar tabela estacionamento
                            break;
                        }
                    }
                }

                //popular tabela gates
                populaTabela(modelGates, aeroporto.portoes);

                //aqui temos que verificar prioridades
                // 1 maior prioridade é aquele que esta voando e tem pouco combustivel 
                // 2 próximo é aquele que esta atrasado para decolar
                //fora isso é uma sincronia 1d - 2p de decolagem e pouso
                //quando entra na pista muda seu status, quando sai da pista muda o status
                //a pista tem que mostrar na tabela os dois por loop, o que esta pousando ou decolando e o que esta saindo da pista
                //usar um sleep para mostrar movimentação entre tabelas
                //o aviao que sai do taxiamneto e decola sai do sistema
                //o aviao que pousa vai para a fila de estacionamento e espera um gate
                //a cada duas iterações um aviao sai dos gates e vai para fila de taxiamento
                //a cada loop tem que haver um starvation 
                //o starvation vai ser um gasto de gasolina para todos que estao voando (pesados gastam mais)
                //o starvation da hora, a cada loop aumenta o horario fictício do sistema
                //a fila de taximanto verifica a hora para mudar seus status para atrasado(emergencia) caso tenha 
                //libera a pista
                aeroporto.statusPista = false;
            }
            //setar nova hora
            jLabelHora.setText("HORA: " + hora);
            break;//para teste de somente, retirar depois
        }

    }

    //método para pegar o index do aviao com maior prioridade na fila
    private int getMaxPrioridade(LinkedList<Aviao> fila, String tipoPrioridade[], int tipoFila) {
        // 0 - filaPouso  1 - filaTaxiamento 2 - filaEstacioamento
        if (tipoFila == 0) {
            for (int i = tipoPrioridade.length - 1; i <= tipoPrioridade.length; i--) {
                for (int j = 0; j < filaPouso.size(); j++) {
                    if (filaPouso.get(j).getPrioridade() == i) {

                        float gasolina = filaPouso.get(j).getQuantidadeCombustivel();
                        gasolina -= 50;
                        filaPouso.get(j).setQuantidadeCombustivel(gasolina);

                        return j;
                    }
                }
            }
            if (tipoFila == 1) {
                //implementar prioridade pela hora do voo
            }

        }
        return -1;
    }
    //metodo que recebe uma lista, o status e o tipo da fila e a quanitdade. 
    //Cria n avioes e adiciona na lista 

    private void criarAviao(LinkedList<Aviao> fila, int status, int tipoFila, int quantidade) {

        for (int i = 0; i < quantidade; i++) {
            Aviao aviao = new Aviao();
            //setar valores do aviao
            aviao.setCodigoVoo("COD0" + quantidadeAviao);
            aviao.setHoraVoo(hora + random.nextInt(100));
            aviao.setOrigem(origens[random.nextInt(origens.length)]);
            aviao.setPeso(random.nextInt(1000) + 1000);
            aviao.setPosicaoFila(fila.size());
            //aviao.setQuantidadeCombustivel(random.nextInt(100) + 100);
            aviao.setQuantidadeCombustivel(random.nextInt(100));

            aviao.setStatus(status);
            aviao.setTipoFila(tipoFila);// 0 - filaPouso  1 - filaTaxiamento 2 - filaEstacioamento
            aviao.setTransponder("TSP-0" + quantidadeAviao);

            aviao.setPrioridade(0); //normal
            if (tipoFila == 0) {
                if (aviao.getPeso() > 1600) {
                    aviao.setPrioridade(1); //pesado no ar
                }
//                if (aviao.getQuantidadeCombustivel() < 60) {
                if (aviao.getQuantidadeCombustivel() < 10) {
                    aviao.setPrioridade(2); //emergencia pelo combustivel
                }
            }
            if (tipoFila == 1) {
                if (aviao.getHoraVoo() < hora + 20) {
                    aviao.setPrioridade(2); //emergencia por horario
                }
            }

            quantidadeAviao++;

            fila.add(aviao);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonIniciar;
    private javax.swing.JButton jButtonPopular;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabelHora;
    private javax.swing.JLabel jLabelUpdateHora;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTable jTableFilaEstacionamento;
    private javax.swing.JTable jTableFilaPouso;
    private javax.swing.JTable jTableFilaTaxiamento;
    private javax.swing.JTable jTableGates;
    private javax.swing.JTextArea jTextAreaHistorico;
    private javax.swing.JTextArea jTextAreaPista;
    // End of variables declaration//GEN-END:variables

    //metodo que recebe um modelo da tabela e uma lista, 
    //escreve na tabela os elementos da lista
    private void populaTabela(DefaultTableModel model, LinkedList<Aviao> fila) {
        model.setRowCount(0);
        fila.forEach((aviao) -> {
            model.addRow(new String[]{
                aviao.getCodigoVoo(),
                aviao.getOrigem(),
                Float.toString(aviao.getQuantidadeCombustivel()),
                Float.toString(aviao.getPeso()),
                tipoPrioridade[aviao.getPrioridade()],
                Integer.toString(aviao.getHoraVoo()),
                statusAviao[aviao.getStatus()]});
        });
    }

    //metodo que recebe um modelo da tabela e um vetor de avioes , 
    //escreve na tabela os elementos do vetor
    private void populaTabela(DefaultTableModel model, Aviao[] vetor) {
        model.setRowCount(0);
        for (Aviao aviao : vetor) {
            if (aviao != null) {
                model.addRow(new String[]{
                    aviao.getCodigoVoo(),
                    aviao.getOrigem(),
                    Float.toString(aviao.getQuantidadeCombustivel()),
                    Float.toString(aviao.getPeso()),
                    tipoPrioridade[aviao.getPrioridade()],
                    Integer.toString(aviao.getHoraVoo()),
                    statusAviao[aviao.getStatus()]});
            }

        }
    }

    //metodo que recebe um modelo da tabela e um objeto do tipo aviao, 
    //basicamente, será usado para popular a tebela Pista
    private void populaTabela(DefaultTableModel model, Aviao aviao) {
        model.setRowCount(0);
        model.addRow(new String[]{
            aviao.getCodigoVoo(),
            aviao.getOrigem(),
            Float.toString(aviao.getQuantidadeCombustivel()),
            Float.toString(aviao.getPeso()),
            tipoPrioridade[aviao.getPrioridade()],
            Integer.toString(aviao.getHoraVoo()),
            statusAviao[aviao.getStatus()]});
    }
    //FIM TESTE

    private void limpaTabela(DefaultTableModel model) {
        model.setRowCount(0);
    }

    //método que cria uma thread para ficar atualizando o label HORA de 1 em 1s
    private void atualizaHora() {

        Thread t = new Thread() {

            public void run() {
                while (true) {
                    jLabelUpdateHora.setText("");
                    jLabelUpdateHora.setText(Integer.toString(hora));
                    hora++;
                    try {
                        sleep(1000);
                    } catch (InterruptedException ex) {

                    }
                }
            }
        };
        t.start();
    }

    void teste(Aviao aviao) {
        this.jTextAreaPista.append(aviao.getCodigoVoo());
    }
}
