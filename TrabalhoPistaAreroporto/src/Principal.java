
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

        atualizaHora();

        //inica com 30 aviões na fila de pouso
        criarAviao(filaPouso, 0, 0, 15);
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
                false, false, false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableFilaPouso);
        if (jTableFilaPouso.getColumnModel().getColumnCount() > 0) {
            jTableFilaPouso.getColumnModel().getColumn(5).setPreferredWidth(20);
        }

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
        jButtonIniciar.setText("ADD +1 AVIÃO");
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
        jLabel6.setText("HISTÓRICO");

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabelHora)
                                .addGap(1, 1, 1)
                                .addComponent(jLabelUpdateHora, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(946, 946, 946)
                                .addComponent(jButtonIniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 1025, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(144, 144, 144)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 694, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(245, 245, 245)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(328, 328, 328)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(29, 29, 29)
                                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 691, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 1028, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 1025, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel3))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 3, Short.MAX_VALUE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelHora)
                            .addComponent(jLabelUpdateHora, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58)
                        .addComponent(jButtonIniciar)
                        .addGap(16, 16, 16)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIniciarActionPerformed
        criarAviao(filaPouso, 0, 0, 1);
        populaTabela(modelFilaPouso, filaPouso);

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

    //iteracoes da pista 
    int qtdPouso = 0;
    boolean teste = false;

    //inicia todo o funcionamento do aeroporto
    private void iniciar() {
        //enquanto tiver avioes para usar a pista, continua o funcionamento
        while (!filaPouso.isEmpty() || !filaEstacionamento.isEmpty() || !filaTaxiamento.isEmpty() || !filaGate.isEmpty()) {

            if (qtdPouso % 2 == 0) {
                System.out.println("pousa");
                if (!filaTaxiamento.isEmpty()) {
                    taxiamentoParaDecolar();
//                    qtdPouso = 0;
                }
            }

            //se a filaPous for <5 vai dar erro, pq ele vai preencher 5 aviões no gate por causa do for, e não tem 5 aviões na filaPouso
            if (filaPouso.size() >= 5) {
                if (teste == false) {
                    if (!filaPouso.isEmpty()) {
                        //enra 1 vez só, para preencher todos os gates
                        for (int i = 0; i < 5; i++) {
                            pousoParaGate();
                            starvation("gasolina");
                        }
                        teste = true;
                    }
                }
            }

            if (filaGate.size() < 5) {
                if (!filaPouso.isEmpty()) {
                    pousoParaGate();
                    starvation("gasolina");
                    qtdPouso++;
                }

            }
            if (!filaPouso.isEmpty()) {
                pousoParaEstacionamento();
                starvation("gasolina");
            }

            if (!filaEstacionamento.isEmpty()) {
                //so manda para o gate se tiver espaço
                if (filaGate.size() < 5) {
                    estacionamentoParaGate();
                }

            }

            if (!filaGate.isEmpty()) {
                gateParaTaxiamento();

            }

//            if (qtdPouso == 3 || filaPouso.isEmpty()) {
//                if (!filaTaxiamento.isEmpty()) {
//                    taxiamentoParaDecolar();
//                    qtdPouso = 0;
//                }
//            }
            //a cada volta do laço starvation na fila de taxiamento
            if (!filaTaxiamento.isEmpty()) {
                starvation("hora");
            }
            System.out.println("qtdPouso " + qtdPouso);
        }
    }
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@    
//@@@@@@@@@@@@@@@@@ MÉTODOS @@@@@@@@@@@@@@@@
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

    private void starvation(String tipoStarvation) {
        if (tipoStarvation.equals("gasolina")) {
            for (Aviao aviao : filaPouso) {
                aviao.setQuantidadeCombustivel(aviao.getQuantidadeCombustivel() - 5);

                if (aviao.getQuantidadeCombustivel() < 60) {
                    aviao.setPrioridade(1);
                }
                if (aviao.getQuantidadeCombustivel() < 30) {
                    aviao.setPrioridade(2);
                }
            }
        }

        if (tipoStarvation.equals("hora")) {
            for (Aviao aviao : filaTaxiamento) {
                aviao.setHoraVoo(aviao.getHoraVoo() - random.nextInt(20));
                populaTabela(modelFilaTaxiamento, filaTaxiamento);
            }
        }
    }

    //remove da fila de pouso e adiciona na fila do gate
    private void pousoParaGate() {
        Aviao aviaoPouso = filaPouso.get(getMaxPrioridade(filaPouso, tipoPrioridade, 0));
//        Aviao aviaoPouso = filaPouso.getFirst();

        filaPouso.remove(aviaoPouso);
        //status para "POUSANDO"
        aviaoPouso.setStatus(1);
        //atualiza a tabela filaPouso
        populaTabela(modelFilaPouso, filaPouso);
        //mostra avião pousando
        populaTabela(modelPista, aviaoPouso);
        //inseri no histórico
        jTextAreaHistorico.append("Aviao " + aviaoPouso.getCodigoVoo() + " pousou \n");
        //auto scroll
        jTextAreaHistorico.setCaretPosition(jTextAreaHistorico.getDocument().getLength());
        //espera 2s
        threadSleep();
        //limpa a pista
        modelPista.setRowCount(0);

        filaGate.add(aviaoPouso); //popular tabela gates
        // status GATE
        aviaoPouso.setStatus(6);
        //zera o combustível
        aviaoPouso.setQuantidadeCombustivel(0);
        //"abastece o aviao"
        aviaoPouso.setQuantidadeCombustivel(random.nextInt(100) + 100);
        //atualiza a hora de voo do aviao, pega a variável hora que está sendo incrementada pela thread e adiciona mais um tempo random
        //aviao.setHoraVoo(hora + random.nextInt(50));
        aviaoPouso.setHoraVoo(100 + hora);
        populaTabela(modelGates, filaGate);
        jTextAreaHistorico.append("Aviao " + aviaoPouso.getCodigoVoo() + " foi para o portão " + filaGate.size() + "\n");
        //auto scroll
        jTextAreaHistorico.setCaretPosition(jTextAreaHistorico.getDocument().getLength());
        threadSleep();

    }

    //remove da fila de pouso e adiciona na fila de estacionamento
    private void pousoParaEstacionamento() {

        Aviao aviaoPouso = filaPouso.get(getMaxPrioridade(filaPouso, tipoPrioridade, 0));
//        Aviao aviaoPouso = filaPouso.getFirst();

        filaPouso.remove(aviaoPouso);
        //status para "POUSANDO"
        aviaoPouso.setStatus(1);
        //atualiza a tabela filaPouso
        populaTabela(modelFilaPouso, filaPouso);
        //mostra avião pousando
        populaTabela(modelPista, aviaoPouso);
        //inseri no histórico
        jTextAreaHistorico.append("Aviao " + aviaoPouso.getCodigoVoo() + " pousou \n");
        //auto scroll
        jTextAreaHistorico.setCaretPosition(jTextAreaHistorico.getDocument().getLength());
        //espera 2s
        threadSleep();
        //limpa a pista
        modelPista.setRowCount(0);

        //adiciona na filaEstacionamento
        filaEstacionamento.add(aviaoPouso);
        //muda o status para "ESTACIONAMENTO"
        aviaoPouso.setStatus(5);
        //atualiza as tabelas
//        populaTabela(modelFilaPouso, filaPouso); //talvez não precisa pois, a tabela já atualizada logo a cima no método
        populaTabela(modelFilaEstacionamento, filaEstacionamento);

        //inseri no histórico que o aviao foi para a fila de estacionamento
        jTextAreaHistorico.append("Aviao " + aviaoPouso.getCodigoVoo() + " foi para Estacionamento \n");
        //auto scroll
        jTextAreaHistorico.setCaretPosition(jTextAreaHistorico.getDocument().getLength());
    }

    //remove da fila do estacionamento e adiciona na fila do gate
    private void estacionamentoParaGate() {
        Aviao aviaoGate = filaEstacionamento.getFirst(); //pega o primeito da lista, pq não tem prioridade
        //filaEstacionamento.remove(aviaoGate);
        filaEstacionamento.removeFirst();

        filaGate.add(aviaoGate);

        // status GATE
        aviaoGate.setStatus(6);
        //zera o combustível
        aviaoGate.setQuantidadeCombustivel(0);
        //"abastece o aviao"
        aviaoGate.setQuantidadeCombustivel(random.nextInt(100) + 100);
        //atualiza a hora de voo do aviao, pega a variável hora que está sendo incrementada pela thread e adiciona mais um tempo random        
        aviaoGate.setHoraVoo(random.nextInt(100) + hora);

        //atualiza as 2 tabelas que foram alteradas
        populaTabela(modelGates, filaGate);
        populaTabela(modelFilaEstacionamento, filaEstacionamento);

        threadSleep();

        jTextAreaHistorico.append("Aviao " + aviaoGate.getCodigoVoo() + " foi para o portão " + filaGate.size() + "\n");
        //auto scroll
        jTextAreaHistorico.setCaretPosition(jTextAreaHistorico.getDocument().getLength());
    }

    //remove da fila do gate e adiciona na fila do taxiamento
    private void gateParaTaxiamento() {
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
        threadSleep();
    }

    //remova da fila de taxiamento e sai do sistema
    private void taxiamentoParaDecolar() {
        //método que pega o aviao com maior prioridade para decolar
        Aviao aviaoDecolar = filaTaxiamento.get(getMaxPrioridade(filaTaxiamento, tipoPrioridade, 1));
        //Aviao aviaoDecolar = filaTaxiamento.get(0);

        filaTaxiamento.remove(aviaoDecolar);
        //filaTaxiamento.removeFirst();
        populaTabela(modelFilaTaxiamento, filaTaxiamento);
        aviaoDecolar.setStatus(3);

        //mostra por 2s o aviao ocupando a pista 
        populaTabela(modelPista, aviaoDecolar);
        jTextAreaHistorico.append("Aviao " + aviaoDecolar.getCodigoVoo() + " decolando! hora do voo: " + aviaoDecolar.getHoraVoo() + "\n");
        jTextAreaHistorico.setCaretPosition(jTextAreaHistorico.getDocument().getLength());
        threadSleep();
        modelPista.setRowCount(0);
        jTextAreaHistorico.append("Aviao " + aviaoDecolar.getCodigoVoo() + " decolou! hora do voo: " + aviaoDecolar.getHoraVoo() + "\n");
        jTextAreaHistorico.setCaretPosition(jTextAreaHistorico.getDocument().getLength());

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
            //aviao.setHoraVoo(hora + random.nextInt(100));
            aviao.setOrigem(origens[random.nextInt(origens.length)]);
            aviao.setPeso(random.nextInt(1000) + 1000);
            aviao.setPosicaoFila(fila.size());
            aviao.setQuantidadeCombustivel(random.nextInt(50) + 80);
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
