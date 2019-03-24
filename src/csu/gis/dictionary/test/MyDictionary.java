package csu.gis.dictionary.test;

import csu.gis.dictionary.dic.BareBonesBrowserLaunch;
import csu.gis.dictionary.dic.Voice;
import csu.gis.dictionary.dic.Word;
import csu.gis.dictionary.dic.WordList;
import csu.gis.dictionary.ui.WindowsAbout;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class MyDictionary extends javax.swing.JFrame {

    protected ArrayList<Word> _wordsEnglishToChinese = new ArrayList<>();
    protected ArrayList<Word> _wordsChineseToEnglish = new ArrayList<>();
    protected int wordIndex = -1;
    protected String rootFilePath = "D:\\biancheng\\java\\yhcDictionar_beta2\\";

    DefaultListModel dlm = new DefaultListModel();

    public MyDictionary() throws IOException {
        initComponents();
        loadFile(rootFilePath + "langdao-ce-gb.txt", 1);
        loadFile(rootFilePath + "langdao-ec-gb.txt", 0);
        textSearchWord.setBuddy(panelSimilarWords, panelTranslating, listSimilarWords, searchType,
                _wordsEnglishToChinese, _wordsChineseToEnglish, dictionaryNowLayer);
        listNewWords.setBuddy(_wordsEnglishToChinese, _wordsChineseToEnglish,
                textSearchWord, jTabbedPane1Main, searchType, listNewWordsType);
        listHistory.setListPath(rootFilePath + "history.txt");
        listNewWords.setListPath(rootFilePath);
    }

    public void loadFile(String filePath, int type) throws FileNotFoundException, IOException {  //type=0,表示英译汉，type=1表示汉译英
        if (type == 0) {
            WordList list = new WordList(filePath, type);
            _wordsEnglishToChinese = list.getData();
        } else if (type == 1) {
            WordList list = new WordList(filePath, type);
            _wordsChineseToEnglish = list.getData();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1Main = new javax.swing.JTabbedPane();
        dictionaryPanel = new javax.swing.JPanel();
        searchPanel = new javax.swing.JPanel();
        btnSearch = new javax.swing.JButton();
        searchType = new javax.swing.JComboBox<>();
        textSearchWord = new csu.gis.dictionary.ui.TextSearchWord();
        dictionaryNowLayer = new javax.swing.JLayeredPane();
        panelSimilarWords = new javax.swing.JPanel();
        jScrollWords = new javax.swing.JScrollPane();
        listSimilarWords = new javax.swing.JList<>();
        panelTranslating = new javax.swing.JPanel();
        jScrollExplain = new javax.swing.JScrollPane();
        wordExplain = new javax.swing.JTextPane();
        jScrollWord = new javax.swing.JScrollPane();
        wordName = new javax.swing.JTextPane();
        jPanel2 = new javax.swing.JPanel();
        voiceUK = new javax.swing.JButton();
        voiceUSA = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        PanelNewWords = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jbtSortingAsLetter = new javax.swing.JButton();
        jbtSortingAsTime = new javax.swing.JButton();
        listNewWordsType = new javax.swing.JComboBox<>();
        jbtIsShowExplain = new javax.swing.JButton();
        jbtIsShowName = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        listNewWords = new csu.gis.dictionary.ui.ListNewWords();
        PanelHistory = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listHistory = new csu.gis.dictionary.ui.ListHistory();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jmenuItemExit = new javax.swing.JMenuItem();
        jMenuItemAbout = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1Main.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        jTabbedPane1Main.setFont(new java.awt.Font("宋体", 0, 18)); // NOI18N
        jTabbedPane1Main.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MainMouseClicked(evt);
            }
        });

        searchPanel.setPreferredSize(new java.awt.Dimension(566, 35));

        btnSearch.setFont(new java.awt.Font("楷体", 1, 17)); // NOI18N
        btnSearch.setText("搜索");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        searchType.setFont(new java.awt.Font("楷体", 1, 17)); // NOI18N
        searchType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "英译汉", "汉译英" }));
        searchType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchTypeActionPerformed(evt);
            }
        });

        textSearchWord.setFont(new java.awt.Font("宋体", 0, 16)); // NOI18N
        textSearchWord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textSearchWordActionPerformed(evt);
            }
        });
        textSearchWord.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textSearchWordKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout searchPanelLayout = new javax.swing.GroupLayout(searchPanel);
        searchPanel.setLayout(searchPanelLayout);
        searchPanelLayout.setHorizontalGroup(
            searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchPanelLayout.createSequentialGroup()
                .addComponent(textSearchWord, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(searchType, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        searchPanelLayout.setVerticalGroup(
            searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, searchPanelLayout.createSequentialGroup()
                .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(searchType)
                    .addComponent(btnSearch, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(textSearchWord, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );

        dictionaryNowLayer.setPreferredSize(new java.awt.Dimension(595, 655));

        listSimilarWords.setFont(new java.awt.Font("宋体", 0, 16)); // NOI18N
        listSimilarWords.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listSimilarWordsMouseClicked(evt);
            }
        });
        jScrollWords.setViewportView(listSimilarWords);

        javax.swing.GroupLayout panelSimilarWordsLayout = new javax.swing.GroupLayout(panelSimilarWords);
        panelSimilarWords.setLayout(panelSimilarWordsLayout);
        panelSimilarWordsLayout.setHorizontalGroup(
            panelSimilarWordsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollWords, javax.swing.GroupLayout.DEFAULT_SIZE, 619, Short.MAX_VALUE)
        );
        panelSimilarWordsLayout.setVerticalGroup(
            panelSimilarWordsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSimilarWordsLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jScrollWords, javax.swing.GroupLayout.DEFAULT_SIZE, 629, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        panelTranslating.setPreferredSize(new java.awt.Dimension(595, 521));

        jScrollExplain.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollExplain.setFocusCycleRoot(true);
        jScrollExplain.setHorizontalScrollBar(null);

        wordExplain.setEditable(false);
        wordExplain.setBorder(null);
        wordExplain.setFont(new java.awt.Font("宋体", 0, 16)); // NOI18N
        jScrollExplain.setViewportView(wordExplain);

        wordName.setEditable(false);
        wordName.setBorder(null);
        wordName.setFont(new java.awt.Font("宋体", 1, 26)); // NOI18N
        jScrollWord.setViewportView(wordName);

        voiceUK.setFont(new java.awt.Font("楷体", 1, 16)); // NOI18N
        voiceUK.setText("发声(英音）");
        voiceUK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voiceUKActionPerformed(evt);
            }
        });

        voiceUSA.setFont(new java.awt.Font("楷体", 1, 16)); // NOI18N
        voiceUSA.setText("发声(美音）");
        voiceUSA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voiceUSAActionPerformed(evt);
            }
        });

        btnSave.setFont(new java.awt.Font("楷体", 1, 16)); // NOI18N
        btnSave.setText("存入生词本");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(voiceUK, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
            .addComponent(voiceUSA, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
            .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(voiceUK)
                .addGap(8, 8, 8)
                .addComponent(voiceUSA)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(btnSave))
        );

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/csu/icon/csu.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(199, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelTranslatingLayout = new javax.swing.GroupLayout(panelTranslating);
        panelTranslating.setLayout(panelTranslatingLayout);
        panelTranslatingLayout.setHorizontalGroup(
            panelTranslatingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTranslatingLayout.createSequentialGroup()
                .addGroup(panelTranslatingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollExplain, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollWord, javax.swing.GroupLayout.DEFAULT_SIZE, 443, Short.MAX_VALUE))
                .addGroup(panelTranslatingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 158, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panelTranslatingLayout.setVerticalGroup(
            panelTranslatingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTranslatingLayout.createSequentialGroup()
                .addGroup(panelTranslatingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollWord, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(panelTranslatingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollExplain, javax.swing.GroupLayout.PREFERRED_SIZE, 479, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelTranslatingLayout.createSequentialGroup()
                        .addGap(156, 156, 156)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        dictionaryNowLayer.setLayer(panelSimilarWords, javax.swing.JLayeredPane.DEFAULT_LAYER);
        dictionaryNowLayer.setLayer(panelTranslating, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout dictionaryNowLayerLayout = new javax.swing.GroupLayout(dictionaryNowLayer);
        dictionaryNowLayer.setLayout(dictionaryNowLayerLayout);
        dictionaryNowLayerLayout.setHorizontalGroup(
            dictionaryNowLayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 601, Short.MAX_VALUE)
            .addGroup(dictionaryNowLayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panelSimilarWords, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(dictionaryNowLayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panelTranslating, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 601, Short.MAX_VALUE))
        );
        dictionaryNowLayerLayout.setVerticalGroup(
            dictionaryNowLayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 585, Short.MAX_VALUE)
            .addGroup(dictionaryNowLayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panelSimilarWords, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(dictionaryNowLayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dictionaryNowLayerLayout.createSequentialGroup()
                    .addGap(0, 27, Short.MAX_VALUE)
                    .addComponent(panelTranslating, javax.swing.GroupLayout.PREFERRED_SIZE, 558, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout dictionaryPanelLayout = new javax.swing.GroupLayout(dictionaryPanel);
        dictionaryPanel.setLayout(dictionaryPanelLayout);
        dictionaryPanelLayout.setHorizontalGroup(
            dictionaryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(searchPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 601, Short.MAX_VALUE)
            .addGroup(dictionaryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(dictionaryNowLayer, javax.swing.GroupLayout.DEFAULT_SIZE, 601, Short.MAX_VALUE))
        );
        dictionaryPanelLayout.setVerticalGroup(
            dictionaryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dictionaryPanelLayout.createSequentialGroup()
                .addComponent(searchPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(560, Short.MAX_VALUE))
            .addGroup(dictionaryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dictionaryPanelLayout.createSequentialGroup()
                    .addGap(0, 10, Short.MAX_VALUE)
                    .addComponent(dictionaryNowLayer, javax.swing.GroupLayout.PREFERRED_SIZE, 585, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jTabbedPane1Main.addTab("词典", dictionaryPanel);

        jbtSortingAsLetter.setText("按字母由小到大的顺序排列");
        jbtSortingAsLetter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtSortingAsLetterActionPerformed(evt);
            }
        });

        jbtSortingAsTime.setText("按时间由先到后的顺序排列");
        jbtSortingAsTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtSortingAsTimeActionPerformed(evt);
            }
        });

        listNewWordsType.setFont(new java.awt.Font("宋体", 0, 18)); // NOI18N
        listNewWordsType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "英译汉生词", "汉译英生词" }));
        listNewWordsType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listNewWordsTypeActionPerformed(evt);
            }
        });

        jbtIsShowExplain.setText("隐藏释义");
        jbtIsShowExplain.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtIsShowExplainActionPerformed(evt);
            }
        });

        jbtIsShowName.setText("隐藏单词");
        jbtIsShowName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtIsShowNameActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(listNewWordsType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jbtIsShowExplain, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                    .addComponent(jbtIsShowName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbtSortingAsTime)
                    .addComponent(jbtSortingAsLetter))
                .addGap(0, 0, 0))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(listNewWordsType)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jbtSortingAsTime)
                            .addComponent(jbtIsShowExplain))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jbtSortingAsLetter)
                            .addComponent(jbtIsShowName))))
                .addGap(0, 0, 0))
        );

        jScrollPane2.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane2.setViewportView(listNewWords);

        javax.swing.GroupLayout PanelNewWordsLayout = new javax.swing.GroupLayout(PanelNewWords);
        PanelNewWords.setLayout(PanelNewWordsLayout);
        PanelNewWordsLayout.setHorizontalGroup(
            PanelNewWordsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 601, Short.MAX_VALUE)
        );
        PanelNewWordsLayout.setVerticalGroup(
            PanelNewWordsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelNewWordsLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 537, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        jTabbedPane1Main.addTab("生词本", PanelNewWords);

        jScrollPane1.setViewportView(listHistory);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 601, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 595, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout PanelHistoryLayout = new javax.swing.GroupLayout(PanelHistory);
        PanelHistory.setLayout(PanelHistoryLayout);
        PanelHistoryLayout.setHorizontalGroup(
            PanelHistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PanelHistoryLayout.setVerticalGroup(
            PanelHistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1Main.addTab("历史记录", PanelHistory);

        jMenu1.setText("文件");
        jMenu1.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 16)); // NOI18N

        jmenuItemExit.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 16)); // NOI18N
        jmenuItemExit.setText("关闭");
        jmenuItemExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmenuItemExitActionPerformed(evt);
            }
        });
        jMenu1.add(jmenuItemExit);

        jMenuItemAbout.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 16)); // NOI18N
        jMenuItemAbout.setText("关于");
        jMenuItemAbout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAboutActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemAbout);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("编辑");
        jMenu2.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 16)); // NOI18N
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1Main)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1Main, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        try {
            doSearch();
        } catch (IOException ex) {
            Logger.getLogger(MyDictionary.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void listSimilarWordsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listSimilarWordsMouseClicked
        try {
            String selectedWord = listSimilarWords.getSelectedValue();
            if (selectedWord == null) {
                return;
            }
            textSearchWord.setText(selectedWord);
            doSearch();
        } catch (IOException ex) {
            Logger.getLogger(MyDictionary.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_listSimilarWordsMouseClicked

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        Word theWord = new Word();
        String theName = wordName.getText();
        if (searchType.getSelectedIndex() == 0) {
            for (int i = 0; i < _wordsEnglishToChinese.size(); i++) {
                if (theName.equalsIgnoreCase(_wordsEnglishToChinese.get(i).getName())) {
                    theWord = _wordsEnglishToChinese.get(i);
                }
            }
        } else if (searchType.getSelectedIndex() == 1) {
            for (int i = 0; i < _wordsChineseToEnglish.size(); i++) {
                if (theName.equalsIgnoreCase(_wordsChineseToEnglish.get(i).getName())) {
                    theWord = _wordsChineseToEnglish.get(i);
                }
            }
        }
        try {
            listNewWords.add(theWord);
        } catch (IOException ex) {
            Logger.getLogger(MyDictionary.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void voiceUKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voiceUKActionPerformed
        String name = textSearchWord.getText().trim();
        try {
            Voice.wordVoicePlay(name, 0);
        } catch (IOException ex) {
            Logger.getLogger(MyDictionary.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_voiceUKActionPerformed

    private void jmenuItemExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmenuItemExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jmenuItemExitActionPerformed

    private void jbtSortingAsLetterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtSortingAsLetterActionPerformed
        try {
            listNewWords.setSorting(true);
            listNewWords.clearList();
            listNewWords.showList(0);
        } catch (IOException ex) {
            Logger.getLogger(MyDictionary.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbtSortingAsLetterActionPerformed

    private void jbtSortingAsTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtSortingAsTimeActionPerformed
        listNewWords.setSorting(false);
        listNewWords.clearList();
        try {
            listNewWords.showList(0);
        } catch (IOException ex) {
            Logger.getLogger(MyDictionary.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbtSortingAsTimeActionPerformed

    private void listNewWordsTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listNewWordsTypeActionPerformed
        try {
            listNewWords.setSorting(true);
            listNewWords.clearList();
            listNewWords.showList(listNewWordsType.getSelectedIndex());
        } catch (IOException ex) {
            Logger.getLogger(MyDictionary.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_listNewWordsTypeActionPerformed

    private void textSearchWordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textSearchWordActionPerformed

    }//GEN-LAST:event_textSearchWordActionPerformed

    private void textSearchWordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textSearchWordKeyReleased
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            try {
                doSearch();
            } catch (IOException ex) {
                Logger.getLogger(MyDictionary.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_textSearchWordKeyReleased

    private void jTabbedPane1MainMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MainMouseClicked
        try {
            listHistory.clearList();
            listHistory.showList();
        } catch (IOException ex) {
            Logger.getLogger(MyDictionary.class.getName()).log(Level.SEVERE, null, ex);
        }
        int flag = listNewWordsType.getSelectedIndex();
        try {
            listNewWords.clearList();
            listNewWords.showList(flag);
        } catch (IOException ex) {
            Logger.getLogger(MyDictionary.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jTabbedPane1MainMouseClicked

    private void jbtIsShowExplainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtIsShowExplainActionPerformed
        if (listNewWords.isShowExplain()) {
            jbtIsShowExplain.setText("显示释义");
            listNewWords.setShowExplain(false);
            listNewWords.clearList();
        } else {
            jbtIsShowExplain.setText("隐藏释义");
            listNewWords.setShowExplain(true);
            listNewWords.clearList();
        }
        try {
            listNewWords.showList(listNewWordsType.getSelectedIndex());
        } catch (IOException ex) {
            Logger.getLogger(MyDictionary.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbtIsShowExplainActionPerformed

    private void jbtIsShowNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtIsShowNameActionPerformed
        if (listNewWords.isShowName()) {
            jbtIsShowName.setText("显示单词");
            listNewWords.setShowName(false);
            listNewWords.clearList();
        } else {
            jbtIsShowName.setText("隐藏单词");
            listNewWords.setShowName(true);
            listNewWords.clearList();
        }
        try {
            listNewWords.showList(listNewWordsType.getSelectedIndex());
        } catch (IOException ex) {
            Logger.getLogger(MyDictionary.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbtIsShowNameActionPerformed

    private void jMenuItemAboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAboutActionPerformed
        WindowsAbout about = new WindowsAbout();
        about.setVisible(true);
    }//GEN-LAST:event_jMenuItemAboutActionPerformed

    private void voiceUSAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voiceUSAActionPerformed
        String name = textSearchWord.getText().trim();
        try {
            Voice.wordVoicePlay(name, 1);
        } catch (IOException ex) {
            Logger.getLogger(MyDictionary.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_voiceUSAActionPerformed

    private void searchTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchTypeActionPerformed

    }//GEN-LAST:event_searchTypeActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MyDictionary.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MyDictionary.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MyDictionary.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MyDictionary.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new MyDictionary().setVisible(true);
            } catch (IOException ex) {
                Logger.getLogger(MyDictionary.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelHistory;
    private javax.swing.JPanel PanelNewWords;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSearch;
    private javax.swing.JLayeredPane dictionaryNowLayer;
    private javax.swing.JPanel dictionaryPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItemAbout;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollExplain;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollWord;
    private javax.swing.JScrollPane jScrollWords;
    private javax.swing.JTabbedPane jTabbedPane1Main;
    private javax.swing.JButton jbtIsShowExplain;
    private javax.swing.JButton jbtIsShowName;
    private javax.swing.JButton jbtSortingAsLetter;
    private javax.swing.JButton jbtSortingAsTime;
    private javax.swing.JMenuItem jmenuItemExit;
    private csu.gis.dictionary.ui.ListHistory listHistory;
    private csu.gis.dictionary.ui.ListNewWords listNewWords;
    private javax.swing.JComboBox<String> listNewWordsType;
    private javax.swing.JList<String> listSimilarWords;
    private javax.swing.JPanel panelSimilarWords;
    private javax.swing.JPanel panelTranslating;
    private javax.swing.JPanel searchPanel;
    private javax.swing.JComboBox<String> searchType;
    private csu.gis.dictionary.ui.TextSearchWord textSearchWord;
    private javax.swing.JButton voiceUK;
    private javax.swing.JButton voiceUSA;
    private javax.swing.JTextPane wordExplain;
    private javax.swing.JTextPane wordName;
    // End of variables declaration//GEN-END:variables

    public void doSearch() throws IOException {
        dictionaryNowLayer.moveToFront(panelTranslating);
        dictionaryNowLayer.moveToBack(panelSimilarWords);
        try {
            ((DefaultListModel) listSimilarWords.getModel()).removeAllElements();
        } finally {
            String name = textSearchWord.getText().trim();
            int type = searchType.getSelectedIndex();
            if (type == 0) {
                for (int i = 0; i < _wordsEnglishToChinese.size(); i++) {
                    if (name == null ? _wordsEnglishToChinese.get(i).getName() == null : name.equals(_wordsEnglishToChinese.get(i).getName())) {
                        wordName.setText(_wordsEnglishToChinese.get(i).getName());
                        wordExplain.setText(_wordsEnglishToChinese.get(i).getExplain());
                        wordIndex = i;
                        listHistory.add(_wordsEnglishToChinese.get(i));
                        break;
                    }
                    if (i == _wordsEnglishToChinese.size() - 1) {
                        wordName.setText(name);
                        wordExplain.setText("对不起！没有查到你所查的单词。");
                        int res = JOptionPane.showConfirmDialog(null, "对不起！没有查到你所查的单词。是否打开浏览器进行网上查单词？", "暖心的建议", JOptionPane.YES_NO_OPTION);
                        if (res == JOptionPane.YES_OPTION) { 
                            BareBonesBrowserLaunch.openURL("http://www.youdao.com/w/eng/"+name+"/#keyfrom=dict2.index");
                        } else {
                            return;
                        }
                    }
                }

            } else if (type == 1) {
                for (int i = 0; i < _wordsChineseToEnglish.size(); i++) {
                    if (name == null ? _wordsChineseToEnglish.get(i).getName() == null : name.equals(_wordsChineseToEnglish.get(i).getName())) {
                        wordName.setText(_wordsChineseToEnglish.get(i).getName());
                        wordExplain.setText(_wordsChineseToEnglish.get(i).getExplain());
                        wordIndex = i;
                        listHistory.add(_wordsChineseToEnglish.get(i));
                        break;
                    }
                    if (i == _wordsChineseToEnglish.size() - 1) {
                        wordName.setText(name);
                        wordExplain.setText("对不起！没有查到对应的单词。");
                        int res = JOptionPane.showConfirmDialog(null, "对不起！没有查到你所查的单词。是否打开浏览器进行网上查单词？", "暖心的建议", JOptionPane.YES_NO_OPTION);
                        if (res == JOptionPane.YES_OPTION) {
                            BareBonesBrowserLaunch.openURL("http://www.youdao.com/w/eng/"+name+"/#keyfrom=dict2.index");
                        } else {
                            return;
                        }
                    }
                }
            }
        }
    }
}
