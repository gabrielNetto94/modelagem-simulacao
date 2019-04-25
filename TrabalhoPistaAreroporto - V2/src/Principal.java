
import static java.lang.Thread.sleep;
import java.util.LinkedList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 * @author Crhistopher, Vinicius, gabriel netto, willian zottele
 */
public class Principal extends javax.swing.JFrame {

    //variaveis de controle
    public String tipoPrioridade[] = {"Normal", "Pesado", "Emergência"};
    public String[] statusAviao = {"Aguardando pouso", "Pousando", "Taxiando", "Decolando", "Saindo da pista", "Aguarda Gate", "Aeronave no Gate"};
    public String origens[] = {"Brasília", "Cuiabá", "Rio de Janeiro", "Manaus", "Vitória", "Londrina", "Belo Horizonte", "Florianópolis", "Fortaleza", "Porto Alegre"};
    Random random = new Random();
    public int quantidadeAviao = 1;
    public int hora = 0;

    //listas das filas
    LinkedList<Aviao> filaPouso = new LinkedList<>();
    LinkedList<Aviao> filaTaxiamento = new LinkedList<>();
    LinkedList<Aviao> filaEstacionamento = new LinkedList<>();
    LinkedList<Aviao> filaGate = new LinkedList<>();
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
        modelPista = (DefaultTableModel) jTablePista.getModel();
        modelGates = (DefaultTableModel) jTableGates.getModel();

        //setar hora
        jLabelHora.setText("HORA: ");
        atualizaHora();

        //inica com 30 aviões na fila de pouso
        criarAviao(filaPouso, 0, 0, 10);
        //popula a tabela de pouso
        populaTabela(modelFilaPouso, filaPouso);

        //cria uma thread para inicar o funcionanmento do aeroporto, para não travar a interface gráfica no click do mouse
        Thread t = new Thread() {
            @Override
            public void run() {
                iniciar();
            }
        };
        t.start();
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
        jScrollPane3 = new javax.swing.JScrollPane();
        jTablePista = new javax.swing.JTable();

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

        jTablePista.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Código", "Origem", "Combustível", "Peso", "Prioridade", "Hora", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(jTablePista);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 839, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelHora)
                                .addGap(1, 1, 1)
                                .addComponent(jLabelUpdateHora, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jScrollPane3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonPopular, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 124, Short.MAX_VALUE)
                                .addComponent(jButtonIniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 413, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(10, 10, 10)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))))
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
                        .addGap(23, 23, 23)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 57, Short.MAX_VALUE))
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

    Aviao aviao;
    int count = 0;
//inicia todo o funcionamento do aeroporto

    private void iniciar() {
        //iteracoes da pista 

        //enquanto tiver avioes para usar a pista, continua o funcionamento
        while (!filaPouso.isEmpty() || !filaEstacionamento.isEmpty() || !filaTaxiamento.isEmpty() || !filaGate.isEmpty()) {

            System.out.println("iteracoes: " + count);
//atribui ao objeto "aviao" o aviao com maior prioridade
//            if (!filaPouso.isEmpty()) {
//                aviao = filaPouso.get(getMaxPrioridade(filaPouso, tipoPrioridade, 0));
//            }

            if (!filaPouso.isEmpty()) {
                aviao = filaPouso.getFirst();
                removeFilaPouso();
            }

//REMOVE DO GATE E MANDA PARA TAXIAMENTO 
            if (count % 2 == 0) {
                if (!filaGate.isEmpty()) {
                    mandaDoGateParaTaxiamento();
                    count++;
                }
            }
// A CADA 3 POUSO 1 DECOLA 
            if (filaPouso.isEmpty() || filaTaxiamento.isEmpty()) {
                decolaAviao();
            }
            if (count % 3 == 0) {
                System.out.println("decola");
                if (!filaTaxiamento.isEmpty()) {
                    decolaAviao();
                }
            }
// PREENCHE GATES ATÉ 5 
            if (filaGate.size() < 5 && filaEstacionamento.isEmpty()) {
                adicionaGate();
                count++;
            }
// GATE >5 MANDA PARA ESTACIONAMENTO       
            if (filaGate.size() >= 5) {
                filaPousoParaEstacionamento();
                count++;
            }
//SE GATE <5 REMOVE DO ESTACIONAMENTO E MANDA PARA O GATE        
            if (filaGate.size() < 5 && !filaEstacionamento.isEmpty()) {
                removeEstacionamentoMandaParaGate();
            }
        }
    }
    //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@    
    //@@@@@@@@@@@@@@@@@ MÉTODOS @@@@@@@@@@@@@@@@
    //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

    private void adicionaGate() {
        //remova aviao do estacionamento
        filaGate.add(aviao); //popular tabela gates
        // status GATE
        aviao.setStatus(6);
        //zera o combustível
        aviao.setQuantidadeCombustivel(0);
        //"abastece o aviao"
        aviao.setQuantidadeCombustivel(random.nextInt(100) + 100);
        //atualiza a hora de voo do aviao, pega a variável hora que está sendo incrementada pela thread e adiciona mais um tempo random
        //aviao.setHoraVoo(hora + random.nextInt(50));
        aviao.setHoraVoo(100 + hora);

        populaTabela(modelGates, filaGate);
        jTextAreaHistorico.append("Aviao " + aviao.getCodigoVoo() + " foi para o portão " + filaGate.size() + "\n");
        //auto scroll
        jTextAreaHistorico.setCaretPosition(jTextAreaHistorico.getDocument().getLength());
    }

    private void removeEstacionamentoMandaParaGate() {
        Aviao aviaoGate = filaEstacionamento.get(0);
        filaEstacionamento.removeFirst();

        filaGate.add(aviao); //popular tabela gates
        // status GATE
        aviao.setStatus(6);
        //zera o combustível
        aviao.setQuantidadeCombustivel(0);
        //"abastece o aviao"
        aviao.setQuantidadeCombustivel(random.nextInt(100) + 100);
        //atualiza a hora de voo do aviao, pega a variável hora que está sendo incrementada pela thread e adiciona mais um tempo random
        //aviao.setHoraVoo(hora + random.nextInt(50));
        //aviao.setHoraVoo(100 + hora);
        aviao.setHoraVoo(random.nextInt(100) + hora);

        //atualiza as 2 tabelas que foram alteradas
        populaTabela(modelGates, filaGate);
        populaTabela(modelFilaEstacionamento, filaEstacionamento);
        jTextAreaHistorico.append("Aviao " + aviao.getCodigoVoo() + " foi para o portão " + filaGate.size() + "\n");
        //auto scroll
        jTextAreaHistorico.setCaretPosition(jTextAreaHistorico.getDocument().getLength());
    }

    private void filaPousoParaEstacionamento() {
        //adiciona na filaEstacionamento
        filaEstacionamento.add(aviao);
        //muda o status para "ESTACIONAMENTO"
        aviao.setStatus(5);
        //atualiza as tabelas
        populaTabela(modelFilaPouso, filaPouso);
        populaTabela(modelFilaEstacionamento, filaEstacionamento);

        //inseri no histórico que o aviao foi para a fila de estacionamento
        jTextAreaHistorico.append("Aviao " + aviao.getCodigoVoo() + " foi para Estacionamento \n");
        //auto scroll
        jTextAreaHistorico.setCaretPosition(jTextAreaHistorico.getDocument().getLength());
    }

    private void mandaDoGateParaTaxiamento() {
        //como gate não tem prioridade, pega sempre o 1º aviao da lista
        Aviao aviaoTaxiamento = filaGate.get(0);

        filaTaxiamento.add(aviaoTaxiamento);
        filaGate.removeFirst();

        //atualiza o status para "TAXIANDO"
        aviaoTaxiamento.setStatus(2);

        //atualiaz as tabelas
        populaTabela(modelGates, filaGate);
        populaTabela(modelFilaTaxiamento, filaTaxiamento);

        //inseri no histórico que o aviao foi para a fila de estacionamento
        jTextAreaHistorico.append("Aviao " + aviaoTaxiamento.getCodigoVoo() + " está taxiando \n");
        //auto scroll
        jTextAreaHistorico.setCaretPosition(jTextAreaHistorico.getDocument().getLength());
    }

    private void removeFilaPouso() {
        filaPouso.remove(aviao);
        //status para "POUSANDO"
        aviao.setStatus(1);
        //atualiza a tabela filaPouso
        populaTabela(modelFilaPouso, filaPouso);
        //mostra por 2s o aviao ocupando a pista 
        populaTabela(modelPista, aviao);
        //inseri no histórico
        jTextAreaHistorico.append("Aviao " + aviao.getCodigoVoo() + " pousou \n");
        //auto scroll
        jTextAreaHistorico.setCaretPosition(jTextAreaHistorico.getDocument().getLength());
        //espera 2s
        threadSleep();
        //limpa a pista
        modelPista.setRowCount(0);
    }

    private void decolaAviao() {
        //método que pega o aviao com maior prioridade para decolar
        Aviao aviaoDecolar = filaTaxiamento.get(getMaxPrioridade(filaTaxiamento, tipoPrioridade, 1));
        //Aviao aviaoDecolar = filaTaxiamento.get(0);

        filaTaxiamento.remove(aviaoDecolar);
        //filaTaxiamento.removeFirst();
        populaTabela(modelFilaTaxiamento, filaTaxiamento);
        aviaoDecolar.setStatus(3);

        //mostra por 2s o aviao ocupando a pista 
        populaTabela(modelPista, aviaoDecolar);
        jTextAreaHistorico.append("Aviao " + aviaoDecolar.getCodigoVoo() + " decolou! hora do voo: " + aviaoDecolar.getHoraVoo() + "\n");
        jTextAreaHistorico.setCaretPosition(jTextAreaHistorico.getDocument().getLength());
        threadSleep();
        modelPista.setRowCount(0);

    }

    private void threadSleep() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {

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
        }

        //retorna o index do aviao com menor hora de voo    
        if (tipoFila == 1) {
            int menor = 9999;
            int index = 0;
            for (int i = 0; i < filaTaxiamento.size(); i++) {
                if (filaTaxiamento.get(i).getHoraVoo() < menor) {
                    menor = filaTaxiamento.get(i).getHoraVoo();
                    index = i;
                }
            }
            return index;
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
            aviao.setQuantidadeCombustivel(random.nextInt(100) + 100);
            aviao.setStatus(status);
            aviao.setTipoFila(tipoFila);// 0 - filaPouso  1 - filaTaxiamento 2 - filaEstacioamento
            aviao.setTransponder("TSP-0" + quantidadeAviao);

            aviao.setPrioridade(0); //normal
            if (tipoFila == 0) {
                if (aviao.getPeso() > 1600) {
                    aviao.setPrioridade(1); //pesado no ar
                }
                if (aviao.getQuantidadeCombustivel() < 60) {

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
    //basicamente, será usado para popular a tabela Pista
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
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jTableFilaEstacionamento;
    private javax.swing.JTable jTableFilaPouso;
    private javax.swing.JTable jTableFilaTaxiamento;
    private javax.swing.JTable jTableGates;
    private javax.swing.JTable jTablePista;
    private javax.swing.JTextArea jTextAreaHistorico;
    // End of variables declaration//GEN-END:variables

}
