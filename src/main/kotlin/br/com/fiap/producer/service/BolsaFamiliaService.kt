package br.com.fiap.producer.service

import br.com.fiap.producer.parser.FileParser
import br.com.fiap.producer.parser.vo.FileLayout
import br.com.fiap.producer.sender.TopicMessageSender
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
class BolsaFamiliaService (
    private val fileParser: FileParser<FileLayout>,
    private val topicMessageSender: TopicMessageSender,

    @Value(value = "\${topic.bolsaFamilia}")
    private val bolsaFamiliaTopic: String
) {

    fun sendFileToTopic() {
        val path = "/home/tiagokamegasawa/201901_BolsaFamilia_Pagamentos.csv"
        val entries = fileParser.parseFile(path, FileLayout::class.java)
        topicMessageSender.sendMessage(bolsaFamiliaTopic, entries.toString())
    }

}