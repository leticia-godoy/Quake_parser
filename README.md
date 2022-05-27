# Quake_parser
Leitura e armazenamento das principais informações do arquivo game.log

##### Descrição
<p>->Main :<br>
        - Declaração do documento e exibição de Menu simples, conectado ao Parser.<br>
        -Ativa o parser, que realiza a leitura. <br> 
<p>->Parser : <br>
        - Constrói lista de jogos que são repassados ao main;<br>
        - Leitura linha a linha do documento repassado pelo main, através do BufferedReader;<br>
        - Enquanto o documento não acabar, recuperação de linhas que contém palavras-chave de comando;<br>
        - Procedimentos que leem mais afundo linhas específicas recuperadas anteriormente, e especificações de conteúdo através do Regex.<br>
        - Após separações via Regex, atributos de jogadores ativos são alterados e adicionados ao jogo da vez;<br>
        - No caso de fim do jogo, adição de atributos do jogo atual são adicionados à lista geral de jogos. <br>
<p>->Game : <br>
        -Atributos de rolagem de jogo(Id do jogo), mortes totais do jogo(kills_total), e LinkedList de Jogadores.<br>
<p>->Player : <br>
        -Atributos de Id, nome do jogador , mortes do Jogo e LinkedList com mortes gerais.</p>

