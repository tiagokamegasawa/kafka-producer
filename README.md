# Kafka Producer
### Objetivo
- Produtor de dados do arquivo da bolsa família.  
Essa aplicação é responsável por ler os registros do arquivo da bolsa família, realizar o parse para o formato JSON
e enviar os registros para um tópico do kafka.

### Tecnologias
- Kotlin
- Maven
- Spring boot
- Kafka
- Docker

#### Configurações do Producer
- Devem ser editadas as seguintes variávies no arquivo docker-compose.yml. 
    - TOPIC_BOLSA: Nome do topic de onde serão postadas as mensagens. Por default vem com o nome BOLSA_FAMILIA.
    - KAFKA_HOST: Host onde está disponível o serviço do kafka, incluindo a porta. Por default o arquivo está configurado para acessar a imagem que também será instânciada pelo arquivo docker-compose.yml
    - FILE_PATH: Path de acesso ao arquivo do bolsa familia.
    - FILE_NAME: Nome do arquivo para o kafka-producer.
- Também devem ser alteradas as variáveis de ambiente no arquivo .env com o mesmo valor configurado no arquivo docker-compose.yml:
    - FILE_PATH: Path de acesso ao arquivo do bolsa familia.
    - FILE_NAME: Nome do arquivo para o kafka-producer.

#### Configurações dos Consumidores
- Para os consumidores devem ser editadas as seguintes variáveis: 
    - KAFKA_HOST: Host onde está disponível o serviço do kafka, incluindo a porta. Por default o arquivo está configurado para acessar a imagem que também será instânciada pelo arquivo docker-compose.yml
    - KAFKA_GROUP_ID: group id para acessar o topic do kafka. Deve ser diferente em cada um dos consumers para que todos recebam todas as mensagens.
    - TOPIC_BOLSA: Nome do topic de onde serão consumidas as mensagens. Por default vem com o nome BOLSA_FAMILIA. Deve seguir o mesmo nome que está definido na variavel KAFKA_CREATE_TOPICS da definição da container do kafka.


### Executar na IDE

- Alterar o arquivo application.properties substituindo as seguintes propriedades:   
    - kafka.bootstrapAddress=<Endereço_do_serviço_do_kafka>  
    - topic.bolsaFamilia=<Nome_do_topico>   
    - file.path=<Caminho_do_arquivo>   
    - file.name=<Nome_do_arquivo>
- Executar a classe ProducerApplication.

### Endpoints

- ***POST*** /bolsa-familia - Realiza o processo de parse e envio dos registros para o tópico no Kafka.    
Obs: Obter IP do container do producer para realizar a chamada. Para isso, utilize o comando `docker inspect <ID_CONTAINER>`.

##### Exemplo de registro enviado:

      {
        "mesReferencia": "201901",
        "mesCompetencia": "201806",
        "uf": "RJ",
        "codMunicipioSiafi": "5833",
        "nomeMunicipio": "DUQUE DE CAXIAS",
        "nisFavorecido": "12345678901",
        "nomeFavorecido": "GABRIEL GABES DA SILVA",
        "valorParcela": "89"
      }
    
