package br.com.fiap.producer.sender

interface TopicMessageSender {

    fun sendMessage(topicName: String, message: String)

}