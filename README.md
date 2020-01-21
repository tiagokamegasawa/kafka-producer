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

### Executar na IDE

- Alterar o arquivo application.properties substituindo as seguintes propriedades:
kafka.bootstrapAddress=<Endereço_do_serviço_do_kafka>  
topic.bolsaFamilia=<Nome_do_topico>

- Executar a classe ProducerApplication.

### Endpoints

- ***POST*** /bolsa-familia - Realiza o processo de parse e envio dos registros para o tópico no Kafka.

##### Exemplo de registro enviado:

    ```json
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
    ```
    </p>