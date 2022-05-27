# Quake_parser
Leitura e armazenamento das principais informações do arquivo game.log

##### Descrição
->Main : 
        - Declaração do documento e exibição de Menu simples, conectado ao Parser.
        -Ativa o parser, que realiza a leitura.
->Parser : 
        - Constrói lista de jogos que são repassados ao main;
        - Leitura linha a linha do documento repassado pelo main, através do BufferedReader;
        - Enquanto o documento não acabar, recuperação de linhas que contém palavras-chave de comando;
        - Procedimentos que leem mais afundo linhas específicas recuperadas anteriormente, e especificações de conteúdo através do Regex.
        - Após separações via Regex, atributos de jogadores ativos são alterados e adicionados ao jogo da vez;
        - No caso de fim do jogo, adição de atributos do jogo atual são adicionados à lista geral de jogos.
->Game : 
        -Atributos de rolagem de jogo(Id do jogo), mortes totais do jogo(kills_total), e LinkedList de Jogadores.
->Player : 
        -Atributos de Id, nome do jogador , mortes do Jogo e LinkedList com mortes gerais.

